public class QuartoEstadoEmManutencao extends QuartoEstado {

    private QuartoEstadoEmManutencao() {}
    private static final QuartoEstadoEmManutencao instance = new QuartoEstadoEmManutencao();
    public static QuartoEstadoEmManutencao getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em manutencao";
    }

    @Override
    public boolean concluirManutencao(Quarto quarto) {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        return true;
    }

    @Override
    public boolean desativar(Quarto quarto) {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        return true;
    }
}
