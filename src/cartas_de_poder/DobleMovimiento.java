package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que permite al jugador moverse dos veces en un mismo turno.
 */
public class DobleMovimiento implements CartaPoder {

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        usuario.activarDobleMovimiento();
    }

    @Override
    public String obtenerNombre() {
        return "Doble movimiento";
    }
}
