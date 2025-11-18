package src.jugador;

import cartas_de_poder.CartaPoder;
import estructuras.lista.ListaSimplementeEnlazada;
import piezas.Pieza;
import utils.ValidacionesUtils;

/**
 * Cada jugador posee un nombre, puntos de vida, una lista de cartas de poder y sus piezas en el tablero.
 */
public class Jugador {

    private final String nombre;
    private int vida;
    private int fuerza;
    private boolean invisible;
    private boolean dobleMovimiento;
    private int turnosCongelado;

    private final ListaSimplementeEnlazada<CartaPoder> cartas;
    private final ListaSimplementeEnlazada<Pieza> piezas;

    /**
     * Constructor del jugador.
     * 
     * @param nombre nombre del jugador (no puede ser nulo ni vacío)
     * @param vida vida inicial (debe ser mayor a cero)
     * @param fuerza fuerza inicial (debe ser mayor a cero)
     */
    public Jugador(String nombre, int vida, int fuerza) {
        ValidacionesUtils.noNulo(nombre, "Nombre del jugador");
        ValidacionesUtils.validarMinimoDeCaracteres(nombre, 1, "Nombre del jugador");
        ValidacionesUtils.validarMayorACero(vida, "Vida inicial");
        ValidacionesUtils.validarMayorACero(fuerza, "Fuerza inicial");

        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.invisible = false;
        this.dobleMovimiento = false;
        this.turnosCongelado = 0;
        this.cartas = new ListaSimplementeEnlazada<>();
        this.piezas = new ListaSimplementeEnlazada<>();
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerVida() {
        return vida;
    }

    public int obtenerFuerza() {
        return fuerza;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void aumentarVida(int cantidad) {
        ValidacionesUtils.validarMayorACero(cantidad, "Aumento de vida");
        this.vida += cantidad;
    }

    public void reducirVida(int danio) {
        ValidacionesUtils.validarMayorACero(danio, "Daño");
        this.vida -= danio;
        if (vida < 0) vida = 0;
    }

    public void atacar(Jugador enemigo) {
        ValidacionesUtils.noNulo(enemigo, "Enemigo");
        if (invisible) return; // No puede atacar estando invisible
        if (turnosCongelado > 0) return; // No puede atacar si está congelado
        enemigo.reducirVida(fuerza);
    }

    public void recibirCarta(CartaPoder carta) {
        ValidacionesUtils.noNulo(carta, "Carta");
        cartas.insertarUltimo(carta);
    }

    public void eliminarCarta(int indice) {
        cartas.eliminarEnPosicion(indice);
    }

    public CartaPoder obtenerCarta(int indice) {
        return cartas.obtenerEnPosicion(indice);
    }

    public void usarCarta(int indice, Jugador objetivo) {
        CartaPoder carta = obtenerCarta(indice);
        carta.aplicar(this, objetivo);
        eliminarCarta(indice);
    }

    public void activarEscudo(int reduccionDanio) {
        // Podrías almacenar esta reducción para el siguiente ataque
    }

    public void activarInvisibilidad(int turnos) {
        this.invisible = true;
        // Podrías tener un contador de turnos invisibles
    }

    public void activarDobleMovimiento() {
        this.dobleMovimiento = true;
    }

    public void aumentarFuerzaTemporal(int cantidad) {
        this.fuerza += cantidad;
    }

    public void congelar(int turnos) {
        this.turnosCongelado = turnos;
    }

    public void colocarTrampa() {
        // En una versión avanzada, podrías registrar la trampa en el tablero
    }

    public ListaSimplementeEnlazada<CartaPoder> obtenerCartas() {
        return cartas;
    }

    public ListaSimplementeEnlazada<Pieza> obtenerPiezas() {
        return piezas;
    }
}
