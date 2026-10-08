import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamareiraTest {

    @Test
    void deveNotificarUmaCamareira() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Camareira camareira = new Camareira("Camareira 1");
        camareira.monitorar(quarto);
        quarto.fazerCheckIn();
        quarto.fazerCheckOut();
        assertEquals("Camareira 1, limpeza solicitada no Quarto{numero=101, andar=1, tipo='Casal'}", camareira.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCamareiras() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Camareira camareira1 = new Camareira("Camareira 1");
        Camareira camareira2 = new Camareira("Camareira 2");
        camareira1.monitorar(quarto);
        camareira2.monitorar(quarto);
        quarto.fazerCheckIn();
        quarto.fazerCheckOut();
        assertEquals("Camareira 1, limpeza solicitada no Quarto{numero=101, andar=1, tipo='Casal'}", camareira1.getUltimaNotificacao());
        assertEquals("Camareira 2, limpeza solicitada no Quarto{numero=101, andar=1, tipo='Casal'}", camareira2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCamareira() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Camareira camareira = new Camareira("Camareira 1");
        quarto.fazerCheckIn();
        quarto.fazerCheckOut();
        assertEquals(null, camareira.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCamareiraQuarto101() {
        Quarto quarto101 = new Quarto(101, 1, "Casal");
        Quarto quarto202 = new Quarto(202, 2, "Solteiro");
        Camareira camareira1 = new Camareira("Camareira 1");
        Camareira camareira2 = new Camareira("Camareira 2");
        camareira1.monitorar(quarto101);
        camareira2.monitorar(quarto202);
        quarto101.fazerCheckIn();
        quarto101.fazerCheckOut();
        assertEquals("Camareira 1, limpeza solicitada no Quarto{numero=101, andar=1, tipo='Casal'}", camareira1.getUltimaNotificacao());
        assertEquals(null, camareira2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCamareiraQueDeixouDeMonitorar() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Camareira camareira = new Camareira("Camareira 1");
        camareira.monitorar(quarto);
        camareira.deixarDeMonitorar(quarto);
        quarto.fazerCheckIn();
        quarto.fazerCheckOut();
        assertEquals(null, camareira.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCamareiraSemLimpeza() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Camareira camareira = new Camareira("Camareira 1");
        camareira.monitorar(quarto);
        quarto.reservar();
        quarto.fazerCheckIn();
        assertEquals(null, camareira.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCamareiraAposManutencao() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Camareira camareira = new Camareira("Camareira 1");
        camareira.monitorar(quarto);
        quarto.bloquear();
        quarto.concluirManutencao();
        assertEquals("Camareira 1, limpeza solicitada no Quarto{numero=101, andar=1, tipo='Casal'}", camareira.getUltimaNotificacao());
    }

    @Test
    void deveNotificarGerenteECamareiraNoCheckOut() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        Camareira camareira = new Camareira("Camareira 1");
        gerente.monitorar(quarto);
        camareira.monitorar(quarto);
        quarto.fazerCheckIn();
        quarto.fazerCheckOut();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Em limpeza", gerente.getUltimaNotificacao());
        assertEquals("Camareira 1, limpeza solicitada no Quarto{numero=101, andar=1, tipo='Casal'}", camareira.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasGerenteNoCheckIn() {
        Quarto quarto = new Quarto(101, 1, "Casal");
        Gerente gerente = new Gerente("Gerente 1");
        Camareira camareira = new Camareira("Camareira 1");
        gerente.monitorar(quarto);
        camareira.monitorar(quarto);
        quarto.fazerCheckIn();
        assertEquals("Gerente 1, Quarto{numero=101, andar=1, tipo='Casal'} mudou para Ocupado", gerente.getUltimaNotificacao());
        assertEquals(null, camareira.getUltimaNotificacao());
    }
}