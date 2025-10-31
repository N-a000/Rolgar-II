package src.alianzas;

import estructuras.lista.ListaSimplementeEnlazada;
import jugador.Jugador;
import utils.ValidacionesUtils;

/**
 * Clase que representa una alianza entre jugadores en el juego Rolgar II.
 * Una alianza permite que los jugadores cooperen entre sí.
 */
public class Alianza {

    private final ListaSimplementeEnlazada<Jugador> miembros;

    /**
     * Constructor que crea una alianza vacía.
     */
    public Alianza() {
        this.miembros = new ListaSimplementeEnlazada<>();
    }

    /**
     * Agrega un jugador a la alianza.
     * 
     * @param jugador jugador a agregar (no puede ser nulo)
     */
    public void agregarMiembro(Jugador jugador) {
        ValidacionesUtils.noNulo(jugador, "Jugador");
        if (!miembros.contains(jugador)) {
            miembros.insertarUltimo(jugador);
        }
    }

    /**
     * Elimina un jugador de la alianza.
     * 
     * @param jugador jugador a quitar (no puede ser nulo)
     */
    public void quitarMiembro(Jugador jugador) {
        ValidacionesUtils.noNulo(jugador, "Jugador");
        miembros.eliminar(jugador);
    }

    /**
     * Verifica si un jugador pertenece a la alianza.
     * 
     * @param jugador jugador a verificar
     * @return true si el jugador pertenece, false en caso contrario
     */
    public boolean pertenece(Jugador jugador) {
        ValidacionesUtils.noNulo(jugador, "Jugador");
        return miembros.contains(jugador);
    }

    /**
     * Devuelve la lista de miembros de la alianza.
     * 
     * @return lista de jugadores aliados
     */
    public ListaSimplementeEnlazada<Jugador> obtenerMiembros() {
        return miembros;
    }

    /**
     * Realiza un ataque conjunto de todos los miembros de la alianza contra un enemigo.
     * 
     * @param enemigo jugador enemigo
     */
    public void atacarEnConjunto(Jugador enemigo) {
        ValidacionesUtils.noNulo(enemigo, "Enemigo");
        var iter = miembros.iterador();
        while (iter.haySiguiente()) {
            Jugador actual = iter.verActual();
            if (actual.estaVivo()) {
                actual.atacar(enemigo);
            }
            iter.siguiente();
        }
    }

    /**
     * Intercambia una carta entre dos jugadores de la alianza.
     * 
     * @param origen jugador que entrega la carta
     * @param destino jugador que la recibe
     * @param indiceCarta índice de la carta en el inventario del jugador origen
     */
    public void intercambiarCarta(Jugador origen, Jugador destino, int indiceCarta) {
        ValidacionesUtils.noNulo(origen, "Jugador origen");
        ValidacionesUtils.noNulo(destino, "Jugador destino");

        if (!pertenece(origen) || !pertenece(destino)) {
            throw new RuntimeException("Ambos jugadores deben pertenecer a la misma alianza");
        }

        var carta = origen.obtenerCarta(indiceCarta);
        destino.recibirCarta(carta);
        origen.eliminarCarta(indiceCarta);
    }
}
