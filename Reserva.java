package biblioteca;

public class Reserva {
    private Date dataReserva;
    private Livro livro;
    
    public Reserva(Livro livro, Date dataReserva) {
        this.livro = livro;
        this.dataReserva = dataReserva;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Date getDataReserva() {
        return dataReserva;
    }
    
    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }
    
}