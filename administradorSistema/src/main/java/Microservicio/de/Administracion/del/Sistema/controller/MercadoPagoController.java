package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.DTO.CreatePreferenceRequest;
import Microservicio.de.Administracion.del.Sistema.service.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pago")
@CrossOrigin("*")
public class MercadoPagoController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/preferencia")
    public Map<String, Object> crearPreferencia(@RequestBody CreatePreferenceRequest req) throws Exception {
        return mercadoPagoService.crearPreferencia(req);
    }
}
