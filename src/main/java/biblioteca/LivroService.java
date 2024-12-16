package biblioteca;
import java.util.List;

public class LivroService {
    private LivroDAO livroDAO;

    public LivroService() {
        livroDAO = new LivroDAO();
    }

    public void salvarLivro(Livro livro) {
        livroDAO.save(livro);
    }

    public Livro buscarLivroPorId(int id) {
        return livroDAO.findById(id);
    }

    public List<Livro> listarLivros() {
        return livroDAO.findAll();
    }
}

