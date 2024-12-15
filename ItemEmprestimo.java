public class ItemEmprestimo {
    private Date dataDevolucao;
    private float valor;
    private float multa;
    private Livro livro;
    
    public ItemEmprestimo(Livro livro, Date dataDevolucao, float valor) {
        this.livro = livro;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.multa = 0;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public float calcularMultaPorLivro() {
        // Calcular a multa por livro com base na data de devolução
        return multa;
    }
    
    public boolean verificarAtraso(Date dataPrevista) {
        // Verifica se o item está atrasado em relação à data prevista
        return dataDevolucao.after(dataPrevista);
    }
    
}