package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que vuelve invisible al jugador durante un turno.
 */
public class Invisibilidad implements CartaPoder {

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        usuario.activarInvisibilidad(1);
    }

    @Override
    public String obtenerNombre() {
        return "Invisibilidad por 1 turno";
    }
}
