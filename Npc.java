package Game;

/**
 *  Clase Npc
 *  Personajes no jugables del juego, elementos del mapa y el jugador.
 */
public abstract class Npc {
    
    //Atributos
    
    //Posición del npc
    private Cavern position;

    /*Starts POJO*/
    
    public Npc() {
    }

    public Npc(Cavern position) {
        this.position = position;
    }

    public Cavern getPosition() {
        return position;
    }

    public void setPosition(Cavern position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Npc{"+this.getClass() + "position=" + position + '}';
    }
    
    /*Ends POJO*/
}
