package src.juego;

import java.util.ArrayList;
import java.util.List;

import src.tablero.Tablero;
import src.coordenada.Coordenada;
import src.jugador.Jugador;
import src.enuns.TipoPieza;
import src.piezas.AdministradorDePersonaje;
import src.piezas.Pieza;
import src.juego.CondicionesDeVictoria;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== ROLGAR II ===");

        // Crear tablero cúbico tamaño 10
        Tablero tablero = new Tablero(10);
        tablero.inicializarTablero();
        System.out.println("Tablero inicializado correctamente");

        // Crear jugadores
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        // Lista de jugadores (para condiciones de victoria)
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        // Coordenadas iniciales
        Coordenada inicio1 = new Coordenada(0, 0, 0);
        Coordenada inicio2 = new Coordenada(9, 9, 9);

        // Crear personajes administrados
        AdministradorDePersonaje personaje1 =
                new AdministradorDePersonaje("Rolgar", 100, inicio1, 3, 20, 0.25);

        AdministradorDePersonaje personaje2 =
                new AdministradorDePersonaje("Eldra", 100, inicio2, 3, 18, 0.30);

        // Asignar personajes al jugador
        jugador1.setPersonaje(personaje1);
        jugador2.setPersonaje(personaje2);

        // Crear piezas que envuelven personajes
        Pieza p1 = new Pieza(TipoPieza.PERSONAJE, jugador1, inicio1, personaje1.getNombre(), personaje1.getVida(), false);
        Pieza p2 = new Pieza(TipoPieza.PERSONAJE, jugador2, inicio2, personaje2.getNombre(), personaje2.getVida(), false);

        // Asignar piezas al tablero
        tablero.asignarValor(inicio1, p1);
        tablero.asignarValor(inicio2, p2);

        System.out.println("Piezas colocadas en el tablero:");
        System.out.println("- " + personaje1.getNombre() + " en " + inicio1);
        System.out.println("- " + personaje2.getNombre() + " en " + inicio2);

        System.out.println("=== COMIENZA EL JUEGO ===");

        // Simulación de combate
        System.out.println(personaje2.getNombre() + " recibe ataque mortal...");
        personaje2.recibirDanio(150); // deja con vida <= 0
        System.out.println("Vida de " + personaje2.getNombre() + ": " + personaje2.getVida());

        // Evaluar victoria
        Jugador ganador = CondicionesDeVictoria.verificarVictoriaIndividual(jugadores);

        if (ganador != null) {
            System.out.println("\n¡" + ganador.getNombre() + " ha ganado la partida!");
        } else {
            System.out.println("\nLa partida continua...");
        }
    }
}