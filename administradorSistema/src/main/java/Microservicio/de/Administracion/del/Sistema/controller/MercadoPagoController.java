package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.DTO.CreatePreferenceRequest;
import Microservicio.de.Administracion.del.Sistema.service.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin("*")
public class MercadoPagoController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/crear-preferencia")
    public String crearPreferencia(@RequestBody CreatePreferenceRequest req) throws Exception {
        return mercadoPagoService.crearPreferencia(req);
    }
}
