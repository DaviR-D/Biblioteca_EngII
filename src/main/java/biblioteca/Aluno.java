package biblioteca;

public class Aluno {
    private int matricula;
    private String nome;
    private String cpf;
    private String endereco;

    // Construtor
    public Aluno(int matricula, String nome, String cpf, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Getters e Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Métodos adicionais
    public boolean possuiPendencias() {
        // Implementação futura
        return false;
    }

    public boolean validarCpf() {
        // Implementação futura
        return false;
    }
}
