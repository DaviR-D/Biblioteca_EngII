package biblioteca;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "itens_emprestimo")
public class ItemEmprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_prevista")
    private Date dataPrevista;

    @ManyToOne
    @JoinColumn(name = "livro_isbn", referencedColumnName = "isbn", nullable = false)
    private Livro livro;


    @ManyToOne
    @JoinColumn(name = "emprestimo_id", nullable = false)
    private Emprestimo emprestimo;

    // Construtor
    public ItemEmprestimo(Date dataDevolucao, Date dataPrevista, Livro livro) {
        this.dataDevolucao = dataDevolucao;
        this.dataPrevista = dataPrevista;
        this.livro = livro;
    }

    public ItemEmprestimo(){}

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

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
}

