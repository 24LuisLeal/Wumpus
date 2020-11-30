package Game;

/**
 *  Clase Player.
 *  Es nuestro jugador principal.
 *  Hereda de la clase NPC.
 */
public class Player extends Npc {
    
    private int oxygenOfPlayer;

    public int getOxygenOfPlayer() {
        return oxygenOfPlayer;
    }

    public void setOxygenOfPlayer(int oxygenOfPlayer) {
        this.oxygenOfPlayer = oxygenOfPlayer;
    }
    
    

    public Player(int oxygenOfPlayer) {
        this.oxygenOfPlayer = oxygenOfPlayer;
    }

    public Player(int oxygenOfPlayer, Cavern position) {
        super(position);
        this.oxygenOfPlayer = oxygenOfPlayer;
    }
    
}
