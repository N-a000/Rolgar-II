package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que roba una carta al jugador objetivo.
 */
public class RoboDeCarta implements CartaPoder {

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        ValidacionesUtils.noNulo(objetivo, "Objetivo");
        var carta = objetivo.entregarCartaAleatoria();
        usuario.recibirCarta(carta);
    }

    @Override
    public String obtenerNombre() {
        return "Robo de carta";
    }
}
