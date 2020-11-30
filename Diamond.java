package Game;

/**
 *  Clase Diamond
 *  Es un objeto mágico que le dice al jugador en que caverna está Wumpus.
 *  Hereda de Npc.
 */
public class Diamond extends Npc{
    
    private boolean foundDiamond;

    public boolean isFoundDiamond() {
        return foundDiamond;
    }

    public void setFoundDiamond(boolean foundDiamond) {
        this.foundDiamond = foundDiamond;
    }
    
    
    public Diamond() {
    }

    public Diamond(Cavern position) {
        super(position);
        foundDiamond = false;
    }
    
}
