package piezas;

import coordenada.Coordenada;
import enums.TipoPieza;
import utils.ValidacionesUtils;

/**
 * Clase que representa un enemigo en el juego Rolgar II.
 * Hereda de la clase Pieza y representa entidades
 * que pueden atacar a los personajes del jugador.
 */
public class Enemigo extends Pieza {
    private int danio;

    /**
     * Constructor de la clase Enemigo.
     * 
     * @param coordenadas Coordenadas del enemigo en el tablero (no pueden ser nulas)
     * @param nombre Nombre del enemigo (no puede ser nulo)
     * @param vida Vida inicial del enemigo (debe ser mayor a cero)
     * @param danio Daño que inflige el enemigo (debe ser mayor a cero)
     */
    public Enemigo(Coordenada coordenadas, String nombre, int vida, int danio) {
        super(TipoPieza.ENEMIGO, null, coordenadas, nombre, vida, false);
        ValidacionesUtils.validarMayorACero(danio, "Daño");
        this.danio = danio;
    }

    /**
     * Obtiene el daño que inflige el enemigo.
     * 
     * @return Cantidad de daño que causa el enemigo
     */
    public int obtenerDanio() {
        return this.danio;
    }

    /**
     * Asigna un nuevo valor de daño al enemigo.
     * 
     * @param danio Nuevo valor de daño (debe ser mayor a cero)
     */
    public void asignarDanio(int danio) {
        ValidacionesUtils.validarMayorACero(danio, "Daño");
        this.danio = danio;
    }
}