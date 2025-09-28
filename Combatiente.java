// Combatiente.java
public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Combatiente(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    // Mostrar estado actual
    public void mostrarEstado() {
        System.out.println(nombre + " | Vida: " + vida + " | Ataque: " + ataque);
    }

    // Atacar a otro combatiente
    public void atacar(Combatiente objetivo) {
        System.out.println(nombre + " ataca a " + objetivo.nombre + " causando " + ataque + " de daño.");
        objetivo.recibirDaño(ataque);
    }

    // Reducir vida al recibir daño
    public void recibirDaño(int daño) {
        vida -= daño;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nombre + " ha sido derrotado.");
            mensajeDerrota();
        }
    }

    // Métodos abstractos para personalizar
    public abstract void mensajeInicio();
    public abstract void mensajeDerrota();
    public abstract void tomarTurno(Combatiente[] enemigos, Combatiente[] aliados);
}
