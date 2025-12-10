package Microservicio.de.Administracion.del.Sistema.DTO;

import java.util.List;

public class CreatePreferenceRequest {
    private List<ItemDTO> items;

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
