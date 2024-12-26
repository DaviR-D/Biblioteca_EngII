package biblioteca;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import biblioteca.Aluno;


public class EmprestimoFactory {

    public Emprestimo criarEmprestimo(Aluno aluno, List<Livro> livros) {
        Date dataAtual = new Date();
        Date dataDevolucaoPrevista = calcularDataDevolucao(dataAtual, 15);
        Emprestimo emprestimo = new Emprestimo(dataAtual, dataDevolucaoPrevista, 0.0f, false, aluno);
        
        for (Livro livro : livros) {
            ItemEmprestimo item = new ItemEmprestimo(null, dataDevolucaoPrevista, livro);
            emprestimo.adicionarItem(item);
        }
        return emprestimo;
    }
    
    private Date calcularDataDevolucao(Date dataEmprestimo, int prazoDias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);
        calendar.add(Calendar.DAY_OF_MONTH, prazoDias);
        return calendar.getTime();
    }

    
    
}
