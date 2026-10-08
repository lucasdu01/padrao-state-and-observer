public class QuartoEstadoEmLimpeza extends QuartoEstado {

    private QuartoEstadoEmLimpeza() {}
    private static final QuartoEstadoEmLimpeza instance = new QuartoEstadoEmLimpeza();
    public static QuartoEstadoEmLimpeza getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em limpeza";
    }

    @Override
    public boolean concluirLimpeza(Quarto quarto) {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
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
