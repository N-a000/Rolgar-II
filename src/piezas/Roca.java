package piezas;

import coordenada.Coordenada;
import enums.TipoPieza;

/**
 * Clase que representa una roca (obstáculo en el tablero)
 * Hereda de la clase Pieza y se utiliza para representar obstáculos
 * que no pueden ser atravesados por los personajes.
 */
public class Roca extends Pieza {
    private static final String NOMBRE = "#";
    private static final int VIDA = 1;
    private static final boolean TRANSITABLE = false;

    /**
     * Construye una Roca en las coordenadas dadas.
     * Las rocas on obstáculos permanentes que bloquean el paso.
     * 
     * @param coordenadas Coordenadas de la roca (no pueden ser nulas.)
     */
    public Roca(Coordenada coordenadas) {
        super(TipoPieza.Roca, null, coordenadas, NOMBRE, VIDA, TRANSITABLE);
        
    }
}
