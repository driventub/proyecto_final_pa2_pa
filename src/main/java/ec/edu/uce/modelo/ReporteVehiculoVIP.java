package ec.edu.uce.modelo;

import java.math.BigDecimal;

public class ReporteVehiculoVIP {
    
    private String placa;
    private BigDecimal valorICE;
    private BigDecimal valorTotal;

    
    public ReporteVehiculoVIP() {
    }

    

    public ReporteVehiculoVIP(String placa, BigDecimal valorICE, BigDecimal valorTotal) {
        this.placa = placa;
        this.valorICE = valorICE;
        this.valorTotal = valorTotal;
    }



    // Set y GEt
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public BigDecimal getValorICE() {
        return valorICE;
    }
    public void setValorICE(BigDecimal valorICE) {
        this.valorICE = valorICE;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }



    @Override
    public String toString() {
        return "ReporteVehiculoVIP [placa=" + placa + ", valorICE=" + valorICE + ", valorTotal=" + valorTotal + "]";
    }

    
    
}
