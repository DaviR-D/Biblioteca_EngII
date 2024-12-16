package biblioteca;

public class AlunoService {
    private AlunoDAO alunoDAO;

    // Construtor
    public AlunoService(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    // Métodos
    public void salvarAluno(Aluno aluno) {
        // Implementação futura
    }

    public Aluno buscarAlunoPorCPF(String cpf) {
        // Implementação futura
        return null;
    }

    public boolean verificarPendencias(Aluno aluno) {
        // Implementação futura
        return false;
    }
}
