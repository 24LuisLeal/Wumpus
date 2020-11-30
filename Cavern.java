package Game;

import java.util.ArrayList;

/**
 * Clase Cavern
 * Las cavernas o cuevas del juego, en ellas están los npcs. 
 */
public class Cavern {
    
    //Atributos
    
    //Identificador de la caverna
    private int id;
    
    //Indentificador de la caverna que aumenta
    public static int idCavern = 0;
 
    //Nombre de la caverna
    private String name;
    
    //ArrayList para conectar cavernas
    private ArrayList<Cavern> connectCaverns = new ArrayList<Cavern>();
    
    /*Starts POJO*/

    public Cavern() {
        /**
         * El identificador de la caverna irá en aumento cada vez
         * que se crea una nueva.
         */
        id = idCavern;
        idCavern++;
    }

    public Cavern(String name) {
        this();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdCavern() {
        return idCavern;
    }

    public static void setIdCavern(int idCavern) {
        Cavern.idCavern = idCavern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cavern> getConnectCaverns() {
        return connectCaverns;
    }

    public void setConnectCaverns(ArrayList<Cavern> connectCaverns) {
        this.connectCaverns = connectCaverns;
    }

    @Override
    public String toString() {
        return "Cavern" + " id=" + id +
               ", name=" + name +
               ", connectCaverns=" + connectCaverns;
    }
    
    /*Ends POJO*/
    
    
    /**
     * Añadimos las cavernas al arraylist
     */
    public void connectCaverns(Cavern myCavern){
        this.connectCaverns.add(myCavern);
    }

    /**
     * Cavernas disponibles a donde puede ir el jugador
     * 
     * @return Lista de cavernas conectadas a donde puede ir el jugador
     */
    public String listOfCavernsConnected(){
        String cavernsConnected = "Puedes ir a: ";
        for (int i = 0; i < connectCaverns.size() ; i++) {
            Cavern get = connectCaverns.get(i);
            cavernsConnected += " \n"+get.getName();
        }
        return cavernsConnected;
    }

    
    /**
     * Checa si las cavernas están conectadas entre si.
     * @param check
     * @return Si están o no conectadas.
     */
    public boolean checkConnectedCaverns(int check){
        //Esta conectada?
        boolean isConnected = false;
        //Para todas mis cavernas
        for (int i = 0; i < this.connectCaverns.size(); i++) {
            //Checar si están conectadas
            if(this.connectCaverns.get(i).getId() == check){
                isConnected = true;
                //Termina el for
                break;
            }
        }
        return isConnected;
    }
    
}
