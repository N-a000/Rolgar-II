package src.cartas_de_poder;

import jugador.Jugador;
import src.coordenada.Coordenada;
import utils.ValidacionesUtils;

/**
 * Carta que mueve al jugador a una nueva celda del tablero.
 */
public class Teletransportacion implements CartaPoder {

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        Coordenada nueva = usuario.generarCoordenadaAleatoria();
        usuario.cambiarCoordenadas(nueva);
    }

    @Override
    public String obtenerNombre() {
        return "Teletransportación";
    }
}
