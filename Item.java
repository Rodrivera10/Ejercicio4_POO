// Item.java
public class Item {
    private String nombre;
    private String tipo; // cura o ataque
    private int valor;

    public Item(String nombre, String tipo, int valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void usar(Jugador jugador, Combatiente[] aliados, Combatiente[] enemigos) {
        switch (tipo) {
            case "cura" -> {
                jugador.vida += valor;
                System.out.println(jugador.nombre + " usa " + nombre + " y recupera " + valor + " de vida.");
            }
            case "ataque" -> {
                jugador.ataque += valor;
                System.out.println(jugador.nombre + " usa " + nombre + " y aumenta su ataque en +" + valor + " por un turno.");
            }
        }
    }
}
