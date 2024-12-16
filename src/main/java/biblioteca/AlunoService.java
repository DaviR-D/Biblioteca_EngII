package biblioteca;
import java.util.List;


public class AlunoService {
    private AlunoDAO alunoDAO;

    public AlunoService() {
        alunoDAO = new AlunoDAO();
    }

    public void salvarAluno(Aluno aluno) {
        alunoDAO.save(aluno);
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        return alunoDAO.findById(matricula);
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.findAll();
    }
}

