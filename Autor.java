package biblioteca;

public class Autor {
    private String nome;
    private String sobrenome;
    private String titulacao;

    // Construtor
    public Autor(String nome, String sobrenome, String titulacao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.titulacao = titulacao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
