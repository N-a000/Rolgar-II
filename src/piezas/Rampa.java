package piezas;

import coordenada.Coordenada;
import enums.TipoPieza;

/**
 * Clase que representa una rampa en el tablero de Rolgar II.
 * Hereda de la clase Pieza y se utiliza para representar estructuras
 * que permiten cambiar de nivel (eje Z) en el tablero tridimensional.
 * Las rampas son transitables y modifican automáticamente la coordenada Z
 * del personaje que las atraviesa.
 */
public class Rampa extends Pieza {
    private static final String NOMBRE = "↗";
    private static final int VIDA = 1;
    private static final boolean TRANSITABLE = true;
    
    private int direccionZ; // +1 para subir, -1 para bajar

    /**
     * Construye una Rampa en las coordenadas dadas con una dirección específica.
     * 
     * @param coordenadas Coordenadas de la rampa (no pueden ser nulas)
     * @param direccionZ Dirección del cambio de nivel (+1 sube, -1 baja)
     * @throws RuntimeException si direccionZ no es +1 o -1
     */
    public Rampa(Coordenada coordenadas, int direccionZ) {
        super(TipoPieza.RAMPA, null, coordenadas, NOMBRE, VIDA, TRANSITABLE);
        if (direccionZ != 1 && direccionZ != -1) {
            throw new RuntimeException("La dirección Z debe ser +1 (subir) o -1 (bajar)");
        }
        this.direccionZ = direccionZ;
    }

    /**
     * Obtiene la dirección del cambio de nivel que produce esta rampa.
     * 
     * @return +1 si la rampa sube un nivel, -1 si baja un nivel
     */
    public int obtenerDireccionZ() {
        return direccionZ;
    }

    /**
     * Verifica si la rampa sube de nivel.
     * 
     * @return true si la rampa sube, false si baja
     */
    public boolean sube() {
        return direccionZ > 0;
    }

    /**
     * Calcula la nueva coordenada Z después de usar esta rampa.
     * 
     * @param zActual Coordenada Z actual del personaje
     * @return Nueva coordenada Z después de subir/bajar la rampa
     */
    public int calcularNuevoZ(int zActual) {
        return zActual + direccionZ;
    }
}
