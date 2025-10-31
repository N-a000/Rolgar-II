package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que aumenta la vida del jugador que la usa.
 */
public class AumentoDeVida implements CartaPoder {

    private final int cantidad = 30;

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        usuario.aumentarVida(cantidad);
    }

    @Override
    public String obtenerNombre() {
        return "Aumento de vida";
    }
}
