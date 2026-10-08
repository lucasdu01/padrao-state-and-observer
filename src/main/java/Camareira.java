import java.util.Observable;
import java.util.Observer;

public class Camareira implements Observer {

    private final String nome;
    private String ultimaNotificacao;

    public Camareira(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void monitorar(Quarto quarto) {
        quarto.addObserver(this);
    }

    public void deixarDeMonitorar(Quarto quarto) {
        quarto.deleteObserver(this);
    }

    @Override
    public void update(Observable quarto, Object arg) {
        if (arg == QuartoEstadoEmLimpeza.getInstance()) {
            this.ultimaNotificacao = this.nome + ", limpeza solicitada no " + quarto.toString();
        }
    }
}