package Game;

/**
 *  Clase EasterEgg
 *  Es el huevo de pascua del juego.
 *  Si el jugador encuentra el huevo de pascua, el juego muestra el mensaje
 *  de que lo encontro y pasa al siguiente nivel.
 *  Hereda de Npc.
 */
public class EasterEgg extends Npc {
    
    private boolean foundEgg;

    public boolean isFoundEgg() {
        return foundEgg;
    }

    public void setFoundEgg(boolean foundEgg) {
        this.foundEgg = foundEgg;
    }
    
    
    public EasterEgg() {
    }

    public EasterEgg(Cavern position) {
        super(position);
        foundEgg = false;
    }
    
}
