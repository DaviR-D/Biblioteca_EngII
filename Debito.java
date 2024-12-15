public class Debito {
    private float valor;
    private String descricao;
    private Date data;
    private boolean pago;
    
    public Debito(float valor, String descricao, Date data) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.pago = false;
    }
    
    public float getValor() {
        return valor;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    
    public void pagar() {
        this.pago = true;
    }
    
    public void marcarComoPago() {
        this.pago = true;
    }
    
}