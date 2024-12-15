package biblioteca;

public class Livro {
    private boolean disponivel;
    private boolean emprestadoBiblioteca;
    private boolean reservado;
    
    public boolean isDisponivel() {
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}