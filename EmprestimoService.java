package biblioteca;

public class EmprestimoService {
    private EmprestimoDAO emprestimoDAO;
    private AlunoDAO alunoDAO;
    
    public Emprestimo realizarEmprestimo(Aluno aluno, List<Livro> livros) {
        // Realiza um empréstimo
        return null;
    }
    
    public Devolucao registrarDevolucao(Emprestimo emprestimo, List<ItemDevolucao> devolucoes) {
        return null;
    }
    
    public boolean verificarAtrasos(Aluno aluno, List<Livro> livros) {
        // Verifica atrasos
        return false;
    }
    
}