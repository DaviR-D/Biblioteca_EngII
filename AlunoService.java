package biblioteca;

public class AlunoService {
    private AlunoDAO alunoDAO;

    public AlunoService(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }
    
    public void salvarAluno(Aluno aluno) {
        alunoDAO.save(aluno);
    }
    
    public Aluno buscarAlunoPorCPF(String cpf) {
        // Implementação de busca por CPF
        return null;
    }
    
    public boolean verificarPendencias(Aluno aluno) {
        return aluno.possuiPendencias();
    }
    
}