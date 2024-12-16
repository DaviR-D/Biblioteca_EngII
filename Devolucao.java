package biblioteca;

import java.util.Date;

public class Devolucao {
    private Date dataDevolucao;
    private boolean atraso;
    private float valorTotal;
    private float multa;

    // Construtor
    public Devolucao(Date dataDevolucao, boolean atraso, float valorTotal, float multa) {
        this.dataDevolucao = dataDevolucao;
        this.atraso = atraso;
        this.valorTotal = valorTotal;
        this.multa = multa;
    }

    // Getters e Setters
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtraso() {
        return atraso;
    }

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    // Métodos adicionais
    public float calcularMulta() {
        // Implementação futura
        return 0;
    }

    public boolean verificarAtraso(Date dataPrevista) {
        // Implementação futura
        return false;
    }
}
