package Game;

/**
 *  Clase TankOxygen
 *  Es un tanque de oxígeno para el jugador.
 *  Este npc le aumenta 15 puntos de vida al jugador.
 *  Hereda de Npc.
 */
public class TankOxygen extends Npc{

    public TankOxygen() {
    }

    public TankOxygen(Cavern position) {
        super(position);
    }
    
}
