package src.cartas_de_poder;

import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Carta que permite realizar dos ataques consecutivos sobre el mismo objetivo.
 */
public class AtaqueDoble implements CartaPoder {

    @Override
    public void aplicar(Jugador usuario, Jugador objetivo) {
        ValidacionesUtils.noNulo(usuario, "Usuario");
        ValidacionesUtils.noNulo(objetivo, "Objetivo");
        usuario.atacar(objetivo);
        usuario.atacar(objetivo);
    }

    @Override
    public String obtenerNombre() {
        return "Ataque doble";
    }
}
