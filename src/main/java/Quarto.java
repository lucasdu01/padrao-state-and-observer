import java.util.Observable;

public class Quarto extends Observable {

    private final Integer numero;
    private final Integer andar;
    private final String tipo;
    private QuartoEstado estado;

    public Quarto(Integer numero, Integer andar, String tipo) {
        this.numero = numero;
        this.andar = andar;
        this.tipo = tipo;
        this.estado = QuartoEstadoLiberado.getInstance();
    }

    public QuartoEstado getEstado() {
        return estado;
    }

    public void setEstado(QuartoEstado estado) {
        setChanged();
        notifyObservers(estado);
        this.estado = estado;
    }

    public boolean reservar(){
        return estado.reservar(this);
    }

    public boolean fazerCheckIn(){
        return estado.fazerCheckIn(this);
    }

    public boolean fazerCheckOut(){
        return estado.fazerCheckOut(this);
    }

    public boolean cancelarReserva(){
        return estado.cancelarReserva(this);
    }

    public boolean bloquear(){
        return estado.bloquear(this);
    }

    public boolean concluirLimpeza(){
        return estado.concluirLimpeza(this);
    }

    public boolean concluirManutencao(){
        return estado.concluirManutencao(this);
    }

    public boolean desativar() {
        return estado.desativar(this);
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", andar=" + andar +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
