package biblioteca;

import java.util.Date;

public class Emprestimo {
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private float multa;
    private boolean atraso;

    // Construtor
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, float multa, boolean atraso) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
        this.atraso = atraso;
    }

    // Getters e Setters
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public boolean isAtraso() {
        return atraso;
    }

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }

    // Métodos adicionais
    public void calcularDataDevolucao(Titulo titulo) {
        // Implementação futura
    }
}
