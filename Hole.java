package Game;

/**
 *  Clase Hole.
 *  Es un pozo sin fondo que está en el mapa.
 *  Si el  jugador cae en uno, este muere y pierde el juego.
 *  Hereda de Npc.
 */
public class Hole extends Npc{

    public Hole() {
    }

    public Hole(Cavern position) {
        super(position);
    }
    
}
