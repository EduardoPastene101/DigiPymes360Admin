package Microservicio.de.Administracion.del.Sistema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PreferenceItemDTO {
    private String title;
    private Integer quantity;
    private Double unitPrice;


}
