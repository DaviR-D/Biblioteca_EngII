package biblioteca;

public class LivroService {
    private LivroDAO livroDAO;

    public LivroService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }
    
    public Livro buscarLivroPorISBN(String isbn) {
        // Busca livro pelo ISBN
        return null;
    }
    
    public boolean verificarDisponibilidadeLivro(Livro livro) {
        return livro.isDisponivel();
    }
    
}