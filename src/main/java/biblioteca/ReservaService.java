package biblioteca;

public class ReservaService {
    private ReservaDAO reservaDAO;

    // Construtor
    public ReservaService(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    // Métodos
    public void salvarReserva(Reserva reserva) {
        // Implementação futura
    }

    public void cancelarReserva(Reserva reserva) {
        // Implementação futura
    }

    public boolean verificarReserva(Livro livro) {
        // Implementação futura
        return false;
    }
}
