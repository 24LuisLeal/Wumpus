package Game;

/**
 *  Clase WaterCavern.
 *  Es una caverna de agua.
 *  Si el jugador cae en una, este pierde 3 puntos de vida.
 *  Hereda de Npc.
 */
public class WaterCavern extends Npc{

    public WaterCavern() {
    }

    public WaterCavern(Cavern position) {
        super(position);
    }
    
}
