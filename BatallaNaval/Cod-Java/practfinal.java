package practicaClaseFinal;

import java.io.*;
import java.util.Random;

public class practfinal {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Random rand = new Random();

    static int[] barcosJugador = new int[20];
    static int[] barcosComputadora = new int[20];
    static int intentos = 20; // Cambio aquí para tener 20 intentos del jugador

    public static void inicializarBarcosComputadora() {
        int barcosColocados = 0;
        while (barcosColocados < 5) {
            int posicionAleatoria = rand.nextInt(20);
            if (barcosComputadora[posicionAleatoria] == 0) {
                barcosComputadora[posicionAleatoria] = rand.nextInt(5) + 1;
                barcosColocados++;
            }
        }
    }

    public static void inicializarBarcosJugador() throws IOException {
        out.println("Ingrese las posiciones (0-19) para colocar sus 5 barcos:");
        for (int i = 0; i < 5; i++) {
            int posicion = Integer.parseInt(in.readLine());
            barcosJugador[posicion] = i + 1;
        }
    }

    public static void imprimirBarcos(int[] barcos) {
        for (int i = 0; i < barcos.length; i++) {
            out.print(barcos[i] + "-");
        }
        out.println();
    }

    public static int hacerDisparo(int[] barcos, int posicion) {
        if (barcos[posicion] != 0) {
            int barcoDerribado = barcos[posicion];
            barcos[posicion] = 0;
            return barcoDerribado;
        }
        return -1;
    }

    public static void imprimirGanador(int jugadorBarcos, int computadoraBarcos, int jugadorSuma, int computadoraSuma) {
        if (jugadorBarcos > computadoraBarcos) {
            out.println("¡Felicidades! ¡Ganaste!");
        } else if (jugadorBarcos < computadoraBarcos) {
            out.println("La computadora gana. ¡Inténtalo nuevamente!");
        } else {
            if (jugadorSuma > computadoraSuma) {
                out.println("¡Felicidades! ¡Ganaste!");
            } else if (jugadorSuma < computadoraSuma) {
                out.println("La computadora gana. ¡Inténtalo nuevamente!");
            } else {
                out.println("Es un empate.");
            }
        }
    }

    public static void imprimirMenu() {
        out.println("Menú de opciones:");
        out.println("1. Inicializar el Juego");
        out.println("2. Imprimir dónde están los barcos");
        out.println("3. Jugar");
        out.println("4. Salir del juego");
    }

    public static void main(String[] args) throws IOException {
        int jugadorBarcos = 0;
        int computadoraBarcos = 0;
        int jugadorSuma = 0;
        int computadoraSuma = 0;

        while (true) {
            imprimirMenu();
            int opcion = Integer.parseInt(in.readLine());

            if (opcion == 1) {
                inicializarBarcosComputadora();
                inicializarBarcosJugador();
            } else if (opcion == 2) {
                out.println("Barcos del Jugador:");
                imprimirBarcos(barcosJugador);
                out.println("Barcos de la Computadora:");
                imprimirBarcos(barcosComputadora);
            } else if (opcion == 3) {
                for (int i = 0; i < intentos; i++) {
                    out.println("Intento " + (i + 1) + " - Turno del Jugador:");
                    int posicionJugador = Integer.parseInt(in.readLine());
                    int barcoDerribadoJugador = hacerDisparo(barcosComputadora, posicionJugador);
                    if (barcoDerribadoJugador != -1) {
                        jugadorBarcos++;
                        jugadorSuma += barcoDerribadoJugador;
                        out.println("¡Has derribado un barco en la posición " + posicionJugador + "!");
                    } else {
                        out.println("Intento fallido. No hay un barco en la posición " + posicionJugador + ".");
                    }

                    if (computadoraBarcos == 5 || jugadorBarcos == 5) {
                        break; // Termina el juego si un jugador ha derribado todos los barcos
                    }

                    out.println("Intento " + (i + 1) + " - Turno de la Computadora:");
                    int posicionComputadora = rand.nextInt(20);
                    int barcoDerribadoComputadora = hacerDisparo(barcosJugador, posicionComputadora);
                    if (barcoDerribadoComputadora != -1) {
                        computadoraBarcos++;
                        computadoraSuma += barcoDerribadoComputadora;
                        out.println("La computadora ha derribado un barco en la posición " + posicionComputadora + "!");
                    } else {
                        out.println("La computadora ha fallado. No hay un barco en la posición " + posicionComputadora
                                + ".");
                    }

                    if (computadoraBarcos == 5 || jugadorBarcos == 5) {
                        break; // Termina el juego si un jugador ha derribado todos los barcos
                    }
                }
                imprimirGanador(jugadorBarcos, computadoraBarcos, jugadorSuma, computadoraSuma);
            } else if (opcion == 4) {
                out.println("Cantidad de barcos derribados por el jugador: " + jugadorBarcos);
                out.println("Cantidad de barcos derribados por la computadora: " + computadoraBarcos);
                break;
            } else {
                out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}