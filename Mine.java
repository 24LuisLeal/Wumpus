package Game;

/**
 *  Clase Mine
 *  Es una mina explosiva que se encuentra en el mapa.
 *  Si el jugador está en una caverna con una mina, este muere y pierde.
 *  Hereda de Npc.
 */
public class Mine extends Npc{

    public Mine() {
    }

    public Mine(Cavern position) {
        super(position);
    }
    
}
