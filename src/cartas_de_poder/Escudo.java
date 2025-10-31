package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que reduce el daño recibido por el jugador durante el siguiente turno.
 */
public class Escudo implements CartaPoder {

    private final int reduccionDanio = 15;

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        usuario.activarEscudo(reduccionDanio);
    }

    @Override
    public String obtenerNombre() {
        return "Escudo";
    }
}
