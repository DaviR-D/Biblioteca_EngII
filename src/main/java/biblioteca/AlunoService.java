package biblioteca;
import java.util.List;


public class AlunoService {
    private AlunoDAO alunoDAO = new AlunoDAO();

    public void salvarAluno(Aluno aluno) {
        // Validação dos dados obrigatórios
        if (aluno.getMatricula() == null || aluno.getMatricula() <= 0) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório!");
        }
        if (aluno.getCpf() == null || aluno.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório!");
        }

        // Salva no banco
        alunoDAO.save(aluno);
    }
}


