// Orco.java
import java.util.Random;

public class Orco extends Combatiente {
    private boolean jefe;

    public Orco(String nombre, boolean jefe) {
        super(nombre, jefe ? 100 : 60, jefe ? 20 : 12);
        this.jefe = jefe;
    }

    @Override
    public void mensajeInicio() {
        System.out.println(nombre + " (Orco" + (jefe ? " Jefe" : "") + ") gruñe ferozmente.");
    }

    @Override
    public void mensajeDerrota() {
        System.out.println(nombre + " ha sido derrotado, su rugido retumba...");
    }

    @Override
    public void tomarTurno(Combatiente[] enemigos, Combatiente[] aliados) {
        Random r = new Random();
        Combatiente objetivo = enemigos[r.nextInt(enemigos.length)];
        if (objetivo.vida > 0) {
            if (jefe && r.nextBoolean()) {
                // Habilidad especial de jefe: golpe crítico
                int daño = ataque + 10;
                System.out.println(nombre + " usa Golpe Crítico contra " + objetivo.nombre + " causando " + daño + " de daño.");
                objetivo.recibirDaño(daño);
            } else {
                atacar(objetivo);
            }
        }
    }
}
