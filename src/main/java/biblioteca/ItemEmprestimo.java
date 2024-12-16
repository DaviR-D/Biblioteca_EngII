package biblioteca;

import java.util.Date;

public class ItemEmprestimo {
    private Date dataDevolucao;
    private Date dataPrevista;
    private Livro livro;

    // Construtor
    public ItemEmprestimo(Date dataDevolucao, Date dataPrevista, Livro livro) {
        this.dataDevolucao = dataDevolucao;
        this.dataPrevista = dataPrevista;
        this.livro = livro;
    }

    // Getters e Setters
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
