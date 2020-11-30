package Game;

/**
 *  Clase Setting
 *  Configuraciones de los niveles (npcs y cavernas).
 */
public class Setting {
    //Atributos
    
    //Cantidad de oxígeno o vida del jugador
    private int oxygenOfPlayer = 0;
    
    //Cantidad de cavernas
    private int cavern = 0;
    
    //Cantidad de cavernas con agua
    private int waterCavern = 0;
    
    //Cantidad de tanques de oxígeno
    private int tankOxygen = 0;
    
    //Cantidad de pozos sin fondo
    private int hole = 0;
    
    //Cantidad de murciélagos
    private int bat = 0;
    
    //Cantidad de minas explosivas
    private int mine = 0;
    
    //Cantidad de huevo de pascua
    private int easterEgg = 0;
    
    //Nivel del juego
    private int level = 0;
    
    /**
     * Según el nivel, estos son los números para cada npc y cavernas
     * //////////////////////////Orden////////////////////////////
     * 1. Oxígeno del jugador
     * 2. Cavernas
     * 3. Cavernas con agua
     * 4. Tanques de oxígeno
     * 5. Pozos
     * 6. Murciélagos
     * 7. Minas explosivas
     * 8. Huevo de pascua
     */
    private int [][] levels = {
        //Primer nivel = 0
        {50,20,1,3,1,2,3,1},
        //Segundo nivel = 1
        {45,30,2,2,2,6,4,1},
        //Tercer nivel = 2
        {40,40,4,1,3,8,4,1},
        //Cuarto nivel = 3
        {30,50,8,1,4,10,5,1},
    };

    /*Starts POJO*/
    
    public int getOxygenOfPlayer() {
        return oxygenOfPlayer;
    }

    public void setOxygenOfPlayer(int oxygenOfPlayer) {
        this.oxygenOfPlayer = oxygenOfPlayer;
    }

    public int getCavern() {
        return cavern;
    }

    public void setCavern(int cavern) {
        this.cavern = cavern;
    }

    public int getWaterCavern() {
        return waterCavern;
    }

    public void setWaterCavern(int waterCavern) {
        this.waterCavern = waterCavern;
    }

    public int getTankOxygen() {
        return tankOxygen;
    }

    public void setTankOxygen(int tankOxygen) {
        this.tankOxygen = tankOxygen;
    }

    public int getHole() {
        return hole;
    }

    public void setHole(int hole) {
        this.hole = hole;
    }

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public int getMine() {
        return mine;
    }

    public void setMine(int mine) {
        this.mine = mine;
    }

    public int getEasterEgg() {
        return easterEgg;
    }

    public void setEasterEgg(int easterEgg) {
        this.easterEgg = easterEgg;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        this.oxygenOfPlayer = this.levels[level][0];
        this.cavern = this.levels[level][1];
        this.waterCavern = this.levels[level][2];
        this.tankOxygen = this.levels[level][3];
        this.hole = this.levels[level][4];
        this.bat = this.levels[level][5];
        this.mine = this.levels[level][6];
        this.easterEgg = this.levels[level][7];
        
    }
    
    /*Ends POJO*/
    
    //Instancia del número de npcs y cavernas
    private static Setting uniqueInstance;

    public Setting() {
    }
    
    
    /**
     * Configuración de los niveles
     * @return la instancia del número de npcs y cavernas
     */
    public static Setting getSetting(){
        if(uniqueInstance == null){
            uniqueInstance = new Setting();
            uniqueInstance.setLevel(0);
        }
        return uniqueInstance;
    }
    
    /**
     * Subir de nivel
     */
    public void levelUp(){
        this.level++;
        setLevel(this.level);
    }

    @Override
    public String toString() {
        return "Setting{" + "oxygenOfPlayer=" + oxygenOfPlayer +
                ", cavern=" + cavern + 
                ", waterCavern=" + waterCavern + 
                ", tankOxygen=" + tankOxygen +
                ", hole=" + hole + 
                ", bat=" + bat + 
                ", mine=" + mine + 
                ", easterEgg=" + easterEgg + 
                ", level=" + level + '}';
    }
    
    
}
