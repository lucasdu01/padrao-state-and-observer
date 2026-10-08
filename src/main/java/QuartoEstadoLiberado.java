public class QuartoEstadoLiberado extends QuartoEstado {

    private QuartoEstadoLiberado() {}
    private static final QuartoEstadoLiberado instance = new QuartoEstadoLiberado();
    public static QuartoEstadoLiberado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Liberado";
    }

    @Override
    public boolean reservar(Quarto quarto) {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        return true;
    }

    @Override
    public boolean fazerCheckIn(Quarto quarto) {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        return true;
    }

    @Override
    public boolean bloquear(Quarto quarto) {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        return true;
    }

    @Override
    public boolean desativar(Quarto quarto) {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        return true;
    }
}
