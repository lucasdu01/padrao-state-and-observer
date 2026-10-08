public class QuartoEstadoReservado extends QuartoEstado {

    private QuartoEstadoReservado() {}
    private static final QuartoEstadoReservado instance = new QuartoEstadoReservado();
    public static QuartoEstadoReservado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Reservado";
    }

    @Override
    public boolean fazerCheckIn(Quarto quarto) {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        return true;
    }

    @Override
    public boolean cancelarReserva(Quarto quarto) {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        return true;
    }
}
