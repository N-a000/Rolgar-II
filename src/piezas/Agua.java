package piezas;

import coordenada.Coordenada;
import enums.TipoPieza;

/**
 * Clase que representa agua en el tablero de Rolgar II.
 * Hereda de la clase Pieza y se utiliza para representar sectores
 * con agua que pueden ser atravesados por personajes.
 */
public class Agua extends Pieza {
    private static final String NOMBRE = "~";
    private static final int VIDA = 1;
    private static final boolean TRANSITABLE = true;

    /**
     * Construye un sector de Agua en las coordenadas dadas.
     * El agua es transitable y permite el paso de personajes.
     * 
     * @param coordenadas Coordenadas del agua (no pueden ser nulas)
     */
    public Agua(Coordenada coordenadas) {
        super(TipoPieza.AGUA, null, coordenadas, NOMBRE, VIDA, TRANSITABLE);
    }
}
