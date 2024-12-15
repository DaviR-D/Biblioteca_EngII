package biblioteca;

public class LivroFactory {
    public Livro criarLivro(String titulo, String autor, String isbn) {
        return new Livro();
    }
    
}