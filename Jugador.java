// Jugador.java
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Combatiente {
    private ArrayList<Item> inventario;
    private String rol;

    public Jugador(String nombre, String rol) {
        super(nombre, (rol.equals("Guerrero") ? 120 : 100), (rol.equals("Guerrero") ? 25 : 18));
        this.rol = rol;
        this.inventario = new ArrayList<>();

        // El guerrero tiene menos ítems, el explorador más
        if (rol.equals("Guerrero")) {
            inventario.add(new Item("Poción pequeña", "cura", 20));
        } else {
            inventario.add(new Item("Poción pequeña", "cura", 20));
            inventario.add(new Item("Poción grande", "cura", 40));
            inventario.add(new Item("Elixir de poder", "ataque", 10));
        }
    }

    @Override
    public void mensajeInicio() {
        System.out.println("¡" + nombre + " entra en batalla como " + rol + "!");
    }

    @Override
    public void mensajeDerrota() {
        System.out.println("El jugador " + nombre + " ha caído en combate...");
    }

    @Override
    public void tomarTurno(Combatiente[] enemigos, Combatiente[] aliados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTurno de " + nombre + ". Elige acción:");
        System.out.println("1. Atacar");
        System.out.println("2. Usar ítem");
        System.out.println("3. Pasar turno");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                // Atacar a un enemigo elegido
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i].vida > 0) {
                        System.out.println((i + 1) + ". " + enemigos[i].nombre + " (Vida: " + enemigos[i].vida + ")");
                    }
                }
                int objetivo = sc.nextInt() - 1;
                atacar(enemigos[objetivo]);
            }
            case 2 -> {
                if (inventario.isEmpty()) {
                    System.out.println("No tienes ítems.");
                    return;
                }
                // Mostrar ítems
                for (int i = 0; i < inventario.size(); i++) {
                    System.out.println((i + 1) + ". " + inventario.get(i).getNombre());
                }
                int eleccion = sc.nextInt() - 1;
                Item item = inventario.remove(eleccion);
                item.usar(this, aliados, enemigos);
            }
            case 3 -> System.out.println(nombre + " pasa su turno.");
        }
    }
}
