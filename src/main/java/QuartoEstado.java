public abstract class QuartoEstado {

    public abstract String getEstado();

    public boolean reservar(Quarto quarto) {
        return false;
    }

    public boolean fazerCheckIn(Quarto quarto) {
        return false;
    }

    public boolean fazerCheckOut(Quarto quarto) {
        return false;
    }

    public boolean cancelarReserva(Quarto quarto) {
        return false;
    }

    public boolean bloquear(Quarto quarto) {
        return false;
    }

    public boolean concluirLimpeza(Quarto quarto) {
        return false;
    }

    public boolean concluirManutencao(Quarto quarto) {
        return false;
    }

    public boolean desativar(Quarto quarto) {
        return false;
    }
}
