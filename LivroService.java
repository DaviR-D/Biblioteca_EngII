package biblioteca;

public class LivroService {
    private LivroDAO livroDAO;

    // Construtor
    public LivroService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    // Métodos
    public void salvarLivro(Livro livro) {
        // Implementação futura
    }

    public Livro buscarLivroPorISBN(String isbn) {
        // Implementação futura
        return null;
    }

    public boolean verificarDisponibilidade(Livro livro) {
        // Implementação futura
        return false;
    }
}
