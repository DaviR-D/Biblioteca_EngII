package biblioteca;

import java.util.Date;

public class Reserva {
    private Date data;
    private Aluno aluno;
    private Livro livro;

    // Construtor
    public Reserva(Date data, Aluno aluno, Livro livro) {
        this.data = data;
        this.aluno = aluno;
        this.livro = livro;
    }

    // Getters e Setters
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    // Métodos adicionais
    public void associarReserva(Aluno aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
    }

    public void cancelarReserva() {
        this.aluno = null;
        this.livro = null;
    }

    public boolean isReservado() {
        return this.livro != null;
    }
}
