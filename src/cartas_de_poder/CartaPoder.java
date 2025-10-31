package src.cartas_de_poder;

import jugador.Jugador;

/**
 * Interfaz que representa una carta de poder en el juego Rolgar II.
 * Cada carta puede aplicarse sobre un jugador o sobre otro jugador objetivo.
 */
public interface CartaPoder {

    /**
     * Aplica el efecto de la carta.
     * 
     * @param usuario Jugador que usa la carta (no puede ser nulo)
     * @param objetivo Jugador objetivo del efecto (puede ser nulo si la carta es de autoefecto)
     */
    void aplicar(Jugador usuario, Jugador objetivo);

    /**
     * Devuelve el nombre de la carta.
     * 
     * @return nombre de la carta
     */
    String obtenerNombre();
}
