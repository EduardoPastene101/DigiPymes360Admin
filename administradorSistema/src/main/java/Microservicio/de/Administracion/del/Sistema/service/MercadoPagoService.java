package Microservicio.de.Administracion.del.Sistema.service;

import Microservicio.de.Administracion.del.Sistema.DTO.CreatePreferenceRequest;
import Microservicio.de.Administracion.del.Sistema.DTO.ItemDTO;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MercadoPagoService {

    @Value("${mercadopago.access-token}")
    private String accessToken;

    public Map<String,Object> crearPreferencia(CreatePreferenceRequest req) throws Exception {

        // CONFIGURAR SDK
        MercadoPagoConfig.setAccessToken(accessToken);
        PreferenceClient client = new PreferenceClient();

        // CONVERTIR ITEMS DTO → MercadoPago Item Request
        List<PreferenceItemRequest> items = req.getItems().stream()
                .map(item -> PreferenceItemRequest.builder()
                        .title(item.getTitle())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())   // Ya es BigDecimal
                        .currencyId("CLP")
                        .build()
                )
                .collect(Collectors.toList());

        // CONSTRUIR LA PREFERENCIA
        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .build();
        Preference preference;
        try {
            preference = client.create(preferenceRequest);
            //return preference;
        } catch (MPApiException e) {
            System.out.println("⚠️ Error MercadoPago:");
            System.out.println(e.getApiResponse().getContent()); // <-- ESTA ES LA CAUSA REAL
            throw e;
        }


        // RETORNAR EL ID PARA ANDROID

        Map<String, Object> response = new HashMap<>();
        response.put("id", preference.getId());
        response.put("init_point", preference.getInitPoint());
        response.put("sandbox_init_point", preference.getSandboxInitPoint());

        return response;
    }
}
