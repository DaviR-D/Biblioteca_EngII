package biblioteca;

import java.util.Date;

public class ItemDevolucao {
    private Date dataDevolucao;
    private float valor;
    private int diasAtraso;
    private float multa;

    // Construtor
    public ItemDevolucao(Date dataDevolucao, float valor, int diasAtraso, float multa) {
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.diasAtraso = diasAtraso;
        this.multa = multa;
    }

    // Getters e Setters
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    // Métodos adicionais
    public float calcularMultaPorLivro() {
        // Implementação futura
        return 0;
    }
}
