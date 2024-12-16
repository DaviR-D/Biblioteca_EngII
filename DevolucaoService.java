package biblioteca;

import java.util.List;

public class DevolucaoService {
    private DevolucaoDAO devolucaoDAO;

    // Construtor
    public DevolucaoService(DevolucaoDAO devolucaoDAO) {
        this.devolucaoDAO = devolucaoDAO;
    }

    // Métodos
    public void registrarDevolucao(Emprestimo emp, List<ItemDevolucao> itens) {
        // Implementação futura
    }

    public Devolucao verificarAtraso(Emprestimo emp) {
        // Implementação futura
        return null;
    }

    public float calcularMultaPorAtraso(Emprestimo emp) {
        // Implementação futura
        return 0;
    }

    public void salvarDevolucao(Devolucao devolucao) {
        // Implementação futura
    }
}
