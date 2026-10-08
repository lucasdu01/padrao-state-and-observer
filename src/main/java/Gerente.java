import java.util.Observable;
import java.util.Observer;

public class Gerente implements Observer {

    private final String nome;
    private String ultimaNotificacao;

    public Gerente(String nome) {
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
        QuartoEstado estado = (QuartoEstado) arg;
        this.ultimaNotificacao = this.nome + ", " + quarto.toString() + " mudou para " + estado.getEstado();
    }
}