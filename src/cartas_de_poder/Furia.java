package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que aumenta temporalmente la fuerza del jugador.
 */
public class Furia implements CartaPoder {

    private final int aumentoFuerza = 10;

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        usuario.aumentarFuerzaTemporal(aumentoFuerza);
    }

    @Override
    public String obtenerNombre() {
        return "Furia";
    }
}
