package src.juego;

import java.util.List;
import src.jugador.Jugador;
import src.alianzas.Alianza;
import src.cartas_de_poder.CartaPoder;


public class CondicionesDeVictoria {

    public static Jugador verificarVictoriaIndividual(List<Jugador> jugadores) {
        Jugador ganador = null;
        int vivos = 0;

        for (Jugador jugador : jugadores) {
            if (jugador.getPersonaje() != null && jugador.getPersonaje().estaVivo()) {
                vivos++;
                ganador = jugador;
            }
        }

        return (vivos == 1) ? ganador : null;
    }

    public static Alianza verificarVictoriaPorAlianza(List<Jugador> jugadores, List<Alianza> alianzas) {
        for (Alianza alianza : alianzas) {
            if (esAlianzaGanadora(alianza, jugadores)) {
                return alianza;
            }
        }
        return null;
    }

    public static void eliminarJugador(Jugador derrotado, Jugador ganador) {
        if (derrotado == null || ganador == null) {
            return;
        }

        if (derrotado.getPersonaje() == null || ganador.getPersonaje() == null) {
            return;
        }

        for (CartaPoder carta : derrotado.getPersonaje().getPoderes()) {
            if (ganador.getPersonaje().getPoderes().size() < 10) {
                ganador.getPersonaje().agregarPoder(carta);
            }
        }

        // deja al jugador derrotado sin vida
        derrotado.getPersonaje().recibirDanio(derrotado.getPersonaje().getVida());
    }

    public static boolean juegoTerminado(List<Jugador> jugadores, List<Alianza> alianzas) {
        Jugador ganador = verificarVictoriaIndividual(jugadores);
        Alianza alianzaGanadora = verificarVictoriaPorAlianza(jugadores, alianzas);
        return (ganador != null || alianzaGanadora != null);
    }


    /** 
     * Verifica si una alianza cumple las condiciones para ganar.
     */
    private static boolean esAlianzaGanadora(Alianza alianza, List<Jugador> jugadores) {
        if (!alianza.tieneMiembrosVivos()) {
            return false;
        }

        if (!todosLosMiembrosVivos(alianza)) {
            return false;
        }

        int vivosTotales = contarJugadoresVivos(jugadores);
        int miembrosAlianza = alianza.obtenerMiembros().longitud();

        // si los únicos vivos son los de la alianza
        return vivosTotales == miembrosAlianza;
    }

    /**
     * Verifica si todos los miembros de la alianza están vivos.
     */
    private static boolean todosLosMiembrosVivos(Alianza alianza) {
        var iter = alianza.obtenerMiembros().iterador();

        while (iter.haySiguiente()) {
            Jugador jugador = iter.verActual();
            if (!jugador.estaVivo()) {
                return false;
            }
            iter.siguiente();
        }
        return true;
    }

    /**
     * Cuenta cuántos jugadores siguen con vida.
     */
    private static int contarJugadoresVivos(List<Jugador> jugadores) {
        int vivos = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getPersonaje() != null && jugador.getPersonaje().estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }
}
