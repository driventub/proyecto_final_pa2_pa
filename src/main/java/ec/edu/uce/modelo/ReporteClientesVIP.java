package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReporteClientesVIP {
    
    private BigDecimal valorSubTotal;

    private BigDecimal valorTotal;

    private String cedulaCliente;

    

    public ReporteClientesVIP() {
    }

    

    public ReporteClientesVIP(BigDecimal valorSubTotal, BigDecimal valorTotal, String cedulaCliente) {
        this.valorSubTotal = valorSubTotal;
        this.valorTotal = valorTotal;
        this.cedulaCliente = cedulaCliente;
    }



    public BigDecimal getValorSubTotal() {
        return valorSubTotal;
    }

    public void setValorSubTotal(BigDecimal valorSubTotal) {
        this.valorSubTotal = valorSubTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }



    @Override
    public String toString() {
        return "ReporteClientesVIP [cedulaCliente=" + cedulaCliente + ", valorSubTotal=" + valorSubTotal
                + ", valorTotal=" + valorTotal + "]";
    }

    

    
   
}
