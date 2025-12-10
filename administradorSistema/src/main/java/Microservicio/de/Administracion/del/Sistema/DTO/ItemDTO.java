package Microservicio.de.Administracion.del.Sistema.DTO;

import java.math.BigDecimal;

public class ItemDTO {
    private String title;
    private BigDecimal unitPrice;
    private int quantity;

    // GETTERS
    public String getTitle() {
        return title;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
