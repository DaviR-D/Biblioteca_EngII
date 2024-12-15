package biblioteca;

public class AlunoFactory {
    public Aluno criarAluno(String nome, String cpf, String endereco) {
        return new Aluno(0, nome, cpf, endereco);
    }
    
}