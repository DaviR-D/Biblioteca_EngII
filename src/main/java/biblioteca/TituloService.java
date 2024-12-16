package biblioteca;
import java.util.List;


public class TituloService {
    private TituloFactory tituloFactory;
    private TituloDAO tituloDAO;

    public TituloService() {
        this.tituloFactory = new TituloFactory();
        this.tituloDAO = new TituloDAO();
    }

    public Titulo criarTitulo(int id, int prazo, String isbn, int edicao, int ano, Area area) {
        return tituloFactory.criarTitulo(id, prazo, isbn, edicao, ano, area);
    }

    public void salvarTitulo(Titulo titulo) {
        tituloDAO.save(titulo);
    }

    public Titulo buscarTitulo(int id) {
        return tituloDAO.findById(id);
    }

    public List<Titulo> listarTodosTitulos() {
        return tituloDAO.findAll();
    }
}
