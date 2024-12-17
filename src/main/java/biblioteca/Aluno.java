package biblioteca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    private Integer matricula;
    private String nome;
    private String cpf;
    private String endereco;

    // Construtor
    public Aluno(Integer matricula, String nome, String cpf, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Aluno(){}

    // Getters e Setters
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
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

    // Método para verificar pendências (por exemplo)
    public boolean possuiPendencias() {
        // Lógica para verificar pendências
        return false;
    }
}


