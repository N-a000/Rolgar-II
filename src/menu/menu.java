package src.menu;

import jugador.Jugador;
import src.utils.ValidacionesUtils;
import tablero.Tablero;
import cartas_de_poder.*;

import java.util.Scanner;

/**
 * Clase principal del juego Rolgar II.
 * Permite probar las funcionalidades básicas del TP2.
 */
public class menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bienvenido a Rolgar II ===");
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2: ");
        String nombre2 = sc.nextLine();

        Jugador j1 = new Jugador(nombre1, 100, 20);
        Jugador j2 = new Jugador(nombre2, 100, 20);

        Tablero tablero = new Tablero(3);
        tablero.inicializarTablero();

        System.out.println("Tablero inicializado correctamente.");
        System.out.println("Jugadores creados: " + j1.obtenerNombre() + " vs " + j2.obtenerNombre());

        // Prueba simple con cartas
        CartaPoder carta = new AtaqueDoble();
        j1.recibirCarta(carta);

        System.out.println("\n" + j1.obtenerNombre() + " usa " + carta.obtenerNombre() + " contra " + j2.obtenerNombre());
        j1.usarCarta(0, j2);

        System.out.println("Vida de " + j2.obtenerNombre() + ": " + j2.obtenerVida());

        System.out.println("\nFin de la demostración.");
        sc.close();
    }
}
