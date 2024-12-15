package biblioteca;

public class Aluno {
    private int matricula;
    private String nome;
    private String cpf;
    private String endereco;
    
    public Aluno(int matricula, String nome, String cpf, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    public boolean possuiPendencias() {
        // Implementação para verificar pendências
        return false;
    }
    
    public boolean validarCPF() {
        // Implementação de validação do CPF
        return true;
    }
    
}