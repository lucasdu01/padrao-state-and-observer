public class QuartoEstadoDesativado extends QuartoEstado {

    private QuartoEstadoDesativado() {}
    private static final QuartoEstadoDesativado instance = new QuartoEstadoDesativado();
    public static QuartoEstadoDesativado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Desativado";
    }
}
