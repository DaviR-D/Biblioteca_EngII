package biblioteca;

public class Titulo {
    private int prazo;
    private String isbn;
    private int edicao;
    private int ano;

    // Construtor
    public Titulo(int prazo, String isbn, int edicao, int ano) {
        this.prazo = prazo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
    }

    // Getters e Setters
    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
