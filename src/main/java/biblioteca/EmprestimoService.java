package biblioteca;
import biblioteca.EmprestimoFactory;
import biblioteca.ImpressoraService;
import biblioteca.AlunoDAO;
import biblioteca.EmprestimoDAO;
import java.util.List;
import java.util.ArrayList;


public class EmprestimoService {
    private EmprestimoDAO emprestimoDAO;
    private AlunoDAO alunoDAO;
    private LivroDAO livroDAO;
    private ReservaDAO reservaDAO;
    private DevolucaoDAO devolucaoDAO;
    private ImpressoraService impressoraService;
    private EmprestimoFactory emprestimoFactory;

    // Construtor
    public EmprestimoService(EmprestimoDAO emprestimoDAO, AlunoDAO alunoDAO, LivroDAO livroDAO,
                             ReservaDAO reservaDAO, DevolucaoDAO devolucaoDAO, ImpressoraService impressoraService) {
        this.emprestimoDAO = emprestimoDAO;
        this.alunoDAO = alunoDAO;
        this.livroDAO = livroDAO;
        this.reservaDAO = reservaDAO;
        this.devolucaoDAO = devolucaoDAO;
        this.impressoraService = impressoraService;
    }

    // Métodos
    public void realizarEmprestimo(Aluno aluno, List<String> isbns) {
        List<Livro> livros = new ArrayList<>();
        for (String isbn : isbns) {
            Livro livro = livroDAO.findByISBN(isbn.trim());
            if (livro != null && livro.isDisponivel()) {
                livros.add(livro);
            } else {
                throw new RuntimeException("Livro com ISBN " + isbn + " não está disponível ou não foi encontrado.");
            }
        }
    
        if (livros.isEmpty()) {
            throw new RuntimeException("Nenhum livro válido encontrado para empréstimo.");
        }
    
        Emprestimo emprestimo = new EmprestimoFactory().criarEmprestimo(aluno, livros);
        emprestimoDAO.save(emprestimo);
    
        for (Livro livro : livros) {
            livro.setDisponivel(false);
            livroDAO.update(livro);
        }
    }
        

    public void registrarDevolucao(Emprestimo emp, List<ItemDevolucao> itens) {
        // Implementação futura
    }

    public boolean verificarFluxosAlternativos(Aluno aluno, List<Livro> livros) {
        if (alunoDAO.possuiDebitos(aluno) || alunoDAO.possuiReservasPendentes(aluno)) {
            return true;
        }
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                return true;
            }
        }
        return false;
    }
    

    public Devolucao processarAtraso(Emprestimo emp) {
        // Implementação futura
        return null;
    }

    
    
}
