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
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;

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

        // ITEMS
        List<PreferenceItemRequest> items = req.getItems().stream()
                .map(item -> PreferenceItemRequest.builder()
                        .title(item.getTitle())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())   // BigDecimal
                        .currencyId("CLP")
                        .build()
                )
                .collect(Collectors.toList());

        PreferencePayerRequest payer = PreferencePayerRequest.builder()
                .email("cliente@testuser.com")   // si tienes este campo
                .name(req.getPayerName())     // opcional
                .build();

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("https://img.freepik.com/free-vector/successful-business-man-holding-trophy_1150-35042.jpg?semt=ais_hybrid&w=740&q=80")
                .failure("https://static.vecteezy.com/system/resources/previews/007/545/724/non_2x/failed-grunge-stamp-free-vector.jpg")
                .pending("https://static.vecteezy.com/system/resources/thumbnails/007/957/428/small_2x/grunge-pending-word-rubber-stamp-pending-red-sign-sticker-set-grunge-vintage-square-label-illustration-isolated-on-white-background-vector.jpg")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .payer(payer)
                .backUrls(backUrls)
                .autoReturn("approved")
                .build();


        Preference preference;

        try {
            preference = client.create(preferenceRequest);
        } catch (MPApiException e) {
            System.out.println("⚠️ Error MercadoPago:");
            System.out.println(e.getApiResponse().getContent());
            throw e;
        }

        // RESPUESTA AL APP
        Map<String, Object> response = new HashMap<>();
        response.put("id", preference.getId());
        response.put("init_point", preference.getInitPoint());
        response.put("sandbox_init_point", preference.getSandboxInitPoint());

        return response;
    }
}
