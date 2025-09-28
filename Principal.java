// Principal.java
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al Juego de Batalla");
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Elige rol: 1. Guerrero  2. Explorador");
        int opcion = sc.nextInt();
        String rol = (opcion == 1) ? "Guerrero" : "Explorador";

        Jugador jugador = new Jugador(nombre, rol);
        Batalla batalla = new Batalla(jugador);
        batalla.iniciar();
    }
}
