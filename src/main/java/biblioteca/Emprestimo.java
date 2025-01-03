package biblioteca;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_emprestimo", nullable = false)
    private Date dataEmprestimo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    @Column(name = "multa", nullable = false)
    private float multa;

    @Column(name = "atraso", nullable = false)
    private boolean atraso;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemEmprestimo> itensEmprestados = new ArrayList<>();    

    // Construtor padrão para JPA
    public Emprestimo() {
    }

    // Construtor personalizado
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, float multa, boolean atraso, Aluno aluno) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
        this.atraso = atraso;
        this.aluno = aluno;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public boolean isAtraso() {
        return atraso;
    }

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }

    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<ItemEmprestimo> getItensEmprestados() {
        return itensEmprestados;
    }

    public void adicionarItem(ItemEmprestimo item) {
        itensEmprestados.add(item);
        item.setEmprestimo(this); // Vincula o item ao empréstimo
    }

    public void removerItem(ItemEmprestimo item) {
        itensEmprestados.remove(item);
        item.setEmprestimo(null); // Remove a vinculação
    }

    public Date getDataPrevistaDevolucao() {
        if (!itensEmprestados.isEmpty()) {
            return itensEmprestados.get(0).getDataPrevista(); 
        }
        return null;
    }
}
