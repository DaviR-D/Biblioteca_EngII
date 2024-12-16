package biblioteca;

import java.util.Date;

public class Debito {
    private float valor;
    private Date data;
    private boolean pago;
    private Emprestimo emprestimo;

    // Construtor
    public Debito(float valor, Date data, boolean pago, Emprestimo emprestimo) {
        this.valor = valor;
        this.data = data;
        this.pago = pago;
        this.emprestimo = emprestimo;
    }

    // Getters e Setters
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    // Métodos adicionais
    public void marcarComoPago() {
        this.pago = true;
    }
}
