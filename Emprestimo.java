public class Emprestimo {
    private Date dataEmprestimo;
    private Date dataPrevistaDevolucao;
    private float multa;
    private Aluno aluno;
    
    public void setDataDevolucao(Date data) {
        this.dataPrevistaDevolucao = data;
    }
    
}