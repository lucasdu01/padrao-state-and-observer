public class QuartoEstadoOcupado extends QuartoEstado {

    private QuartoEstadoOcupado() {}
    private static final QuartoEstadoOcupado instance = new QuartoEstadoOcupado();
    public static QuartoEstadoOcupado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Ocupado";
    }

    @Override
    public boolean fazerCheckOut(Quarto quarto) {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        return true;
    }
}
