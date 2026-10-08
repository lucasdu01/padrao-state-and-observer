import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenteTest {

    @Test
    void deveNotificarUmGerente() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        gerente.monitorar(quarto);
        quarto.reservar();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Reservado", gerente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarGerentes() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente1 = new Gerente("Gerente 1");
        Gerente gerente2 = new Gerente("Gerente 2");
        gerente1.monitorar(quarto);
        gerente2.monitorar(quarto);
        quarto.fazerCheckIn();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Ocupado", gerente1.getUltimaNotificacao());
        assertEquals("Gerente 2, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Ocupado", gerente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarGerente() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        quarto.reservar();
        assertEquals(null, gerente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarGerenteQuarto101() {
        Quarto quarto101 = new Quarto(101, 1, "Casal");
        Quarto quarto202 = new Quarto(202, 2, "Solteiro");
        Gerente gerente1 = new Gerente("Gerente 1");
        Gerente gerente2 = new Gerente("Gerente 2");
        gerente1.monitorar(quarto101);
        gerente2.monitorar(quarto202);
        quarto101.reservar();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Reservado", gerente1.getUltimaNotificacao());
        assertEquals(null, gerente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarGerenteQueDeixouDeMonitorar() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        gerente.monitorar(quarto);
        gerente.deixarDeMonitorar(quarto);
        quarto.reservar();
        assertEquals(null, gerente.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarGerenteEmTransicaoInvalida() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        gerente.monitorar(quarto);
        quarto.fazerCheckOut();
        assertEquals(null, gerente.getUltimaNotificacao());
    }

    @Test
    void deveManterUltimaNotificacaoAposTransicaoInvalida() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        gerente.monitorar(quarto);
        quarto.fazerCheckIn();
        quarto.reservar();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Ocupado", gerente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUltimoEstadoDoFluxo() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        gerente.monitorar(quarto);
        quarto.reservar();
        quarto.fazerCheckIn();
        quarto.fazerCheckOut();
        quarto.concluirLimpeza();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Liberado", gerente.getUltimaNotificacao());
    }
}