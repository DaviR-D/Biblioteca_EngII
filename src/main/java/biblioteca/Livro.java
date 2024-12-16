package biblioteca;

public class Livro {
    private boolean disponivel;
    private boolean exemplarBiblioteca;
    private boolean reservado;

    // Construtor
    public Livro(boolean disponivel, boolean exemplarBiblioteca, boolean reservado) {
        this.disponivel = disponivel;
        this.exemplarBiblioteca = exemplarBiblioteca;
        this.reservado = reservado;
    }

    // Getters e Setters
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isExemplarBiblioteca() {
        return exemplarBiblioteca;
    }

    public void setExemplarBiblioteca(boolean exemplarBiblioteca) {
        this.exemplarBiblioteca = exemplarBiblioteca;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    // Métodos adicionais
    public Titulo getTitulo() {
        // Implementação futura
        return null;
    }
}
