package src.piezas;

import jugador.Jugador;
import src.coordenada.Coordenada;
import src.enums.TipoPieza;
import utils.ValidacionesUtils;

/**
 * Clase que representa una pieza en el juego Rolgar II.
 * 
 */
public class Pieza {
    private TipoPieza tipo;
    private String nombre;
    private Jugador duenio;
    private Coordenada coordenadas;
    private int vida;
    private boolean transitable;

    /**
     * Constructor de la clase Pieza
     * 
     * @param tipo: Tipo de la pieza
     * @param duenio: Jugador dueño de la pieza
     * @param coordenadas: Coordenadas de la pieza en el tablero no pueden ser nulas
     * @param nombre: Nombre de la pieza no puede ser nulo
     * @param vida: Vida inicial de la pieza debe ser mayor a cero.
     * @param transitable Si se puede atravesar
     */
    public Pieza(TipoPieza tipo, Jugador duenio, Coordenada coordenadas, String nombre, int vida, boolean transitable) {
        ValidacionesUtils.noNulo(tipo, "Tipo de pieza");
        ValidacionesUtils.noNulo(coordenadas, "Coordenadas");
        ValidacionesUtils.noNulo(nombre, "Nombre");
        ValidacionesUtils.validarMayorACero(vida, "Vida");
        ValidacionesUtils.validarMinimoDeCaracteres(nombre, 1, "Nombre");

        this.tipo = tipo;
        this.duenio = duenio;
        this.coordenadas = coordenadas;
        this.nombre = nombre;
        this.vida = vida;
        this.transitable = transitable;
      

    }

    /**
     * Devuelve el dueño de la pieza
     * @return
     */
    public Jugador obtenerDuenio() {
        return this.duenio;
    }
    
    /**
     * Devuelve el tipo de pieza de la pieza
     * @return
     */
    public TipoPieza obtenerTipo() {
        return this.tipo;
    }
    
    /**
     * Devuelve el nombre de la pieza
     * @return
     */
    public String obtenerNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el valor de vida de la pieza
     * @return
     */
    public int obtenerVida() {
        return this.vida;
    }
    /**
     * Devuelve si es si la pieza es transitable (se puede pasar por encima)
     */
    public boolean esTransitable() {
        return this.transitable;
    }

    /**
     * Devuelve las coordenadas de la pieza
     * @return 
     */
    public Coordenada obtenerCoordenadas() {
        return this.coordenadas;
    }
    /** 
     * Incremmenta el valor de la vida de la pieza.
     * 
     * @param vida: cantidad de la vida a aumentar (debe ser mayor a cero)
     */
    public void aumentarVida(int vida) {
        ValidacionesUtils.validarMayorACero(vida, "Vida");
        this.vida += vida;
    }

    /**
     * Reduce la vida de la pieza.
     * 
     * @param danioInfligido: cantidad de daño infligido (debe ser mayor a cero)
     */
    public void reducirVida(int danioInfligido) {
        ValidacionesUtils.validarMayorACero(danioInfligido, "Danio infligido");
        this.vida -= danioInfligido;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }
    
    /**
     * Verifica si la pieza está viva 
     * @return
     */
    public boolean estaViva() {
        return this.vida > 0;
    }
    
    /**
     * Cambia las coordenadas de la pieza, no pueden ser nulas 
     */
    public void cambiarCoordenadas(Coordenada coordenadas) {
        ValidacionesUtils.noNulo(coordenadas, "Coordenadas");
        this.coordenadas = coordenadas;
    }


}  
