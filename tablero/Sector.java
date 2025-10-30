package tablero;

//Importaciones necesarias
import coordenada.Coordenada;
import piezas.Pieza;
import utils.ValidacionesUtils;

/**
 * Clase Sector representa un sector del tablero de juego Rolgar II.
 * Cada sector tiene coordenadas y un valor que puede ser una pieza
 * como un Personaje, Enemigo, Roca, Rampa, Agua o Vacío.
 */
public class Sector {
    private final Coordenada coordenadas;
    private Pieza valor;

    /**
     * Constructor de la clase Sector.
     * Inicializa un sector con coordenadas y un valor.
     * 
     * @param coordenadas Coordenadas del sector (no pueden ser nulas)
     * @param valor Valor del sector (puede ser Personaje, Enemigo, Roca, etc.; no puede ser nulo )
     * 
     * @throws RuntimeException si las coordenadas o el valor del sector son nulos
     */
    public Sector(Coordenada coordenadas, Pieza valor) {
        ValidacionesUtils.noNulo(coordenadas, "Coordenadas del sector");
        ValidacionesUtils.noNulo(valor, "Valor del sector");
        this.coordenadas = coordenadas;
        this.valor = valor;
    }

    /**
     * Obtiene el valor del sector.
     * 
     * @return Valor del sector (puede ser Personaje, Enemigo, Roca, etc.)
     */
    public Pieza obtenerValor() {
        return valor;
    }

    /**
     * Asigna un nuevo valor al sector.
     * 
     * @param valor Nuevo valor (no puede ser nulo)
     * @throws RuntimeException si el valor es nulo
     */
    public void asignarValor(Pieza valor) {
        ValidacionesUtils.noNulo(valor, "Valor del sector");
        this.valor = valor;
    }
    
    /**
     * Obtiene las coordenadas del sector.
     * 
     * @return Cooredenada del sector
     */
    public Coordenada obtenerCoordenadas() {
        return coordenadas;
    }


    /**
     * Verificar si el sector es transitable.
     * Un sector es transitable si su valor (pieza) lo es.
     * 
     * @return true si es transitable, false en caso contrario 
     */
    public boolean esTransitable() {
        return valor.esTransitable();
    }
}