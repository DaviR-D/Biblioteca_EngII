package biblioteca;

public class ItemDevolucao {
    private Date dataDevolucao;
    private float valor;
    private float multa;
    
    public ItemDevolucao(Livro livro, Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.valor = livro.getValor();
        this.multa = 0;
    }
    
    public void setLivro(Livro livro) {
        // Atribui um livro
    }
    
    public Livro getLivro() {
        // Retorna o livro
        return null;
    }
    
    public float calcularMultaPorLivro() {
        // Calcula a multa
        return multa;
    }
    
}