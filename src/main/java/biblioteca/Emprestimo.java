package biblioteca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    private int id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Livro livro;

    // Construtores
    public Emprestimo() {}

    public Emprestimo(Aluno aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
