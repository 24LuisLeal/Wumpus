package Game;

/**
 *  Clase Wumpus.
 *  Es el objetivo del jugador.
 *  Hereda de Npc.
 */
public class Wumpus extends Npc{
    private boolean isCamptured;

    public boolean isIsCamptured() {
        return isCamptured;
    }

    public void setIsCamptured(boolean isCamptured) {
        this.isCamptured = isCamptured;
    }

    
    
    public Wumpus() {
        
    }

    public Wumpus(Cavern position) {
        super(position);
        this.isCamptured = false;
    }

}
