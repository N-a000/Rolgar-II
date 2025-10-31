package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que congela al jugador objetivo, impidiendo su movimiento por un turno.
 */
public class Congelacion implements CartaPoder {

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        ValidacionesUtils.noNulo(objetivo, "Objetivo");
        objetivo.congelar(1);
    }

    @Override
    public String obtenerNombre() {
        return "Congelación";
    }
}
