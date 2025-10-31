package src.juego;

import java.util.List;
import src.alianzas.Alianza;

public class CondicionesDeVictoria {

    public enum EstadoDeJuego {
        EN_CURSO,
        VICTORIA_JUGADOR,
        DERROTA_JUGADOR,
        EMPATE,
        VICTORIA_ALIANZA
    }

    /**
     * Verifica si queda solo un jugador vivo en la partida.
     * 
     * @param jugadores 
     * @return devuelve verdadero si solo un jugador sigue vivo.
     */
    public boolean quedaSoloEnPie(List<Jugador> jugadores) {
        int resultado = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.estaVivo()) {
                resultado++;
            }
        }
        return resultado == 1;
    }

    /**
     * Verifica si todos los jugadores han sido derrotados.
     * 
     * @param jugadores
     * @return devuelve verdadero si ningun jugador sigue vivo.
     */
    public boolean derrotaGlobal(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.estaVivo()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si existe una alianza ganadora (caso opcional).
     * 
     * @param alianzas
     * @return devuelve verdadero si una alianza es la nica que conserva miembros vivos.
     */
    public boolean victoriaPorAlianza(List<Alianza> alianzas) {
        int resultado = 0;
        for (Alianza alianza : alianzas) {
            if (alianza.tieneMiembrosVivos()) {
            	resultado++;
            }
        }
        return resultado == 1;
    }

    /**
     * Evalua el estado global del juego.
     * 
     * @param jugadores
     * @param alianzas 
     * @return devuelve el estado del juego.
     */
    public EstadoDeJuego evaluarEstado(List<Jugador> jugadores, List<Alianza> alianzas) {
        if (derrotaGlobal(jugadores)) {
            return EstadoDeJuego.DERROTA_JUGADOR;
        }
        if (quedaSoloEnPie(jugadores)) {
            return EstadoDeJuego.VICTORIA_JUGADOR;
        }
        if (alianzas != null && victoriaPorAlianza(alianzas)) {
            return EstadoDeJuego.VICTORIA_ALIANZA;
        }
        return EstadoDeJuego.EN_CURSO;
    }

}
