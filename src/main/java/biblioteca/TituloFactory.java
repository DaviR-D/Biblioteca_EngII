package biblioteca;

public class TituloFactory {
    public Titulo criarTitulo(int id, int prazo, String isbn, int edicao, int ano, Area area) {
        return new Titulo(id, prazo, isbn, edicao, ano, area);
    }
}
