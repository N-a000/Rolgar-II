package src.enums;

/**
 * Enumeración que representa las diferentes tipos de piezas que pueden existir en el juego Rolgar II.
 * Cada tipo de pieza tiene un proposito y caracteristicas específicas dentro del tablero.
 * 
 * Los posibles valores de esta enumeración son:
 * -PERSONAJE: Representa un personaje jugador que puede moverse y atacar.
 * -ENEMIGO: Representa un enemigo que el jugador debe derrotar.
 * -ROCA: Representa una roca no transitable (obstáculo).
 * -AGUA: Representa agua transitable.
 * -RAMPA: Representa una rampa que permite cambiar de nivel.
 * -VACIO: Representa un espacio vacío transitable.
 */

public enum TipoPieza {
    PERSONAJE,
    ENEMIGO,
    ROCA,
    RAMPA,
    AGUA,
    VACIO

}
