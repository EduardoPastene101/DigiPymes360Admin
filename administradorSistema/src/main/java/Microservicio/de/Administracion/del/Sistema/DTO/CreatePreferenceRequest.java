package Microservicio.de.Administracion.del.Sistema.DTO;
import java.util.List;

public class CreatePreferenceRequest {

    private List<ItemDTO> items;

    // Datos del pagador
    private String payerName;
    private String payerEmail;

    // Datos adicionales
    private String descripcion;
    private Double monto;
    private Long usuarioId;

    // URLs opcionales
    private String successUrl;
    private String failureUrl;
    private String pendingUrl;

    public CreatePreferenceRequest() {}

    public CreatePreferenceRequest(
            List<ItemDTO> items,
            String payerName,
            String payerEmail,
            String descripcion,
            Double monto,
            Long usuarioId,
            String successUrl,
            String failureUrl,
            String pendingUrl
    ) {
        this.items = items;
        this.payerName = payerName;
        this.payerEmail = payerEmail;
        this.descripcion = descripcion;
        this.monto = monto;
        this.usuarioId = usuarioId;
        this.successUrl = successUrl;
        this.failureUrl = failureUrl;
        this.pendingUrl = pendingUrl;
    }

    // -------- GETTERS & SETTERS --------

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailureUrl() {
        return failureUrl;
    }

    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    public String getPendingUrl() {
        return pendingUrl;
    }

    public void setPendingUrl(String pendingUrl) {
        this.pendingUrl = pendingUrl;
    }
}
