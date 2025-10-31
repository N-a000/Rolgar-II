package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que cura a un jugador aliado.
 */
public class CuracionAliado implements CartaPoder {

    private final int cantidadCuracion = 25;

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        ValidacionesUtils.noNulo(objetivo, "Objetivo");
        objetivo.aumentarVida(cantidadCuracion);
    }

    @Override
    public String obtenerNombre() {
        return "Curación de un aliado";
    }
}
