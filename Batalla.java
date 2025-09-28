// Batalla.java
import java.util.Random;

public class Batalla {
    private Jugador jugador;
    private Combatiente[] enemigos;

    public Batalla(Jugador jugador) {
        this.jugador = jugador;
        Random r = new Random();

        // Entre 1 y 3 enemigos al azar
        int n = 1 + r.nextInt(3);
        enemigos = new Combatiente[n];
        for (int i = 0; i < n; i++) {
            if (r.nextBoolean()) {
                enemigos[i] = new Orco("Orco " + (i + 1), r.nextBoolean());
            } else {
                enemigos[i] = new Orco("Dragón " + (i + 1), r.nextBoolean());
            }
        }
    }

    public void iniciar() {
        System.out.println("\n¡Comienza la batalla!");
        jugador.mensajeInicio();
        for (Combatiente e : enemigos) e.mensajeInicio();

        while (jugador.vida > 0 && quedanEnemigos()) {
            jugador.mostrarEstado();
            for (Combatiente e : enemigos) e.mostrarEstado();

            jugador.tomarTurno(enemigos, new Combatiente[]{jugador});
            for (Combatiente e : enemigos) {
                if (e.vida > 0) e.tomarTurno(new Combatiente[]{jugador}, enemigos);
            }
        }

        if (jugador.vida > 0) {
            System.out.println("¡Has ganado la batalla!");
        } else {
            System.out.println("Los enemigos han vencido...");
        }
    }

    private boolean quedanEnemigos() {
        for (Combatiente e : enemigos) {
            if (e.vida > 0) return true;
        }
        return false;
    }
}
