package Game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *  Clase Game
 *  Ambiente donde se ejecuta el juego.  
 */
public class Game {
    
    //Npcs
    //Tanque de oxígeno
    public static TankOxygen[] myTank;
    
    //Cavernas con agua
    public static WaterCavern[] myWaterCaverns;
    
    //Pozos sin fondo
    public static Hole[] myHole;
    
    //Minas explosivas
    public static Mine[] myMine;
    
    //Murciélagos
    public static Bat[] myBat;
    
    //Wumpus
    public static Wumpus myWumpus;
    
    //Diamante
    public static Diamond myDiamond;
    
    //Huevo de pascua
    public static EasterEgg myEasterEgg;
    
    //Cavernas
    public static Cavern[] myMaze;
    
    //Array de npcs
    
    public static ArrayList<Npc> myNpcs = new ArrayList<>();
    //Jugador
    public static Player myPlayer;
    //Métodos
    
    
    //Check
    /**
     * Crea el laberinto de cavernas y el campamento.
     */
    public static void createMaze(){
        myMaze = new Cavern[Setting.getSetting().getCavern()];
        System.out.println(Setting.getSetting().getCavern());
        //La caverna 0 siempre será el campamento
        myMaze[0] = new Camp();
        
        for (int i = 1; i < Setting.getSetting().getCavern(); i++) {
            myMaze[i] = new Cavern("Caverna: "+i);
        }
    }
    
    //Check
    /**
     * Muestra el laberinto.
     */
    public static void showMaze(){
        
        for (int i = 0; i < Setting.getSetting().getCavern(); i++) {
            System.out.println(myMaze[i]);
        }
    }
    
    //Check
    /**
     * Crea las conexiones entre cavernas.
     */
    public static void createConnection(){
        //Para todas mis cavernas
        for (int i = 0; i < Setting.getSetting().getCavern(); i++) {
            //Cantidad de conexiones
            for (int j = 0; j < 3; j++) {
                Random r = new Random();
                int randomCavern = r.nextInt(Setting.getSetting().getCavern());
                if(!myMaze[i].checkConnectedCaverns(randomCavern) 
                    && (i != randomCavern)){
                    
                    myMaze[i].connectCaverns(myMaze[randomCavern]);
                    myMaze[randomCavern].connectCaverns(myMaze[i]);
                }
            }
        }
    }
    
    //Check
    /**
     * Coloca un npc a cada caverna disponible.
     */
    public static void colocateNpcInRandomPosition(){
        //Cavernas disponibles
        ArrayList<Integer> available = new ArrayList<>();
        
        for (int i = 0; i < Setting.getSetting().getCavern(); i++) {
            available.add(i);
        }
        
        //Creamos el personaje
        myPlayer = new Player(Setting.getSetting().
                getOxygenOfPlayer(),myMaze[0]);
        available.remove(0);
        //System.out.println("++++++++");
        //System.out.println("Jugador: "+myPlayer.getPosition());
        
        //Creamos a Wumpus
        int colocateWumpus = (int) (Math.random() * available.size());
        myWumpus = new Wumpus(myMaze[available.get(colocateWumpus)]);
        available.remove(colocateWumpus);
        myNpcs.add(myWumpus);
        //System.out.println("*********");
        //System.out.println("Wumpus"+myWumpus.getPosition());
        
        //Creamos el diamante 
        int colocateDiamond = (int) (Math.random() * available.size());
        myDiamond = new Diamond(myMaze[available.get(colocateDiamond)]);
        available.remove(colocateDiamond);
        myNpcs.add(myDiamond);
        //System.out.println("/////////////");
        //System.out.println("Diamante"+myDiamond.getPosition());
        
        //Creamos el huevo de pascua
        int colocateEasterEgg = (int) (Math.random() * available.size());
        myEasterEgg = new EasterEgg(myMaze[available.get(colocateEasterEgg)]);
        available.remove(myEasterEgg);
        myNpcs.add(myEasterEgg);
       
        
        //Hoyos
        myHole = new Hole[Setting.getSetting().getHole()];
        for (int i = 0; i < Setting.getSetting().getHole(); i++) {
            int r = (int)(Math.random() * available.size());
            myHole[i] = new Hole(myMaze[available.get(r)]);
            available.remove(r);
            myNpcs.add(myHole[i]);
            //System.out.println("---------");
            //System.out.println("Pozo: "+myHole[i].getPosition());
        }
        
        //Murciélagos
        myBat = new Bat[Setting.getSetting().getBat()];
        for (int i = 0; i < Setting.getSetting().getBat(); i++) {
            int r = (int)(Math.random() * available.size());
            myBat[i] = new Bat(myMaze[available.get(r)]);
            available.remove(r);
            myNpcs.add(myBat[i]);
            //System.out.println("--------");
            //System.out.println("Bat "+myBat[i].getPosition());
        }
        
        //Minas explosivas
        myMine = new Mine[Setting.getSetting().getMine()];
        for (int i = 0; i < Setting.getSetting().getMine(); i++) {
            int r = (int)(Math.random() * available.size());
            myMine[i] = new Mine(myMaze[available.get(r)]);
            available.remove(r);
            myNpcs.add(myMine[i]);
            //System.out.println("-------");
            //System.out.println("Minas: "+myMine[i].getPosition());
        }
        
        //Cavernas con agua
        myWaterCaverns = new WaterCavern[Setting.getSetting().getWaterCavern()];
        for (int i = 0; i < Setting.getSetting().getWaterCavern(); i++) {
            int r = (int) (Math.random() * available.size());
            myWaterCaverns[i] = new WaterCavern(myMaze[available.get(r)]);
            available.remove(r);
            myNpcs.add(myWaterCaverns[i]);
            //System.out.println("-------");
            //System.out.println("Cavernas de agua"+
            //myWaterCaverns[i].getPosition());
        }
        
        //Tanques de oxígeno
        myTank = new TankOxygen[Setting.getSetting().getTankOxygen()];
        for (int i = 0; i < Setting.getSetting().getTankOxygen(); i++) {
            int r = (int) (Math.random() * available.size());
            myTank[i] = new TankOxygen(myMaze[available.get(r)]);
            available.remove(r);
            myNpcs.add(myTank[i]);
            //System.out.println("---------");
            //System.out.println("Tank oxygen"+myTank[i].getPosition());
        }
    }
    
    //Check
    /**
     * Las acciones que hacen los personajes cuando el jugador está en la 
     * misma caverna.
     */
    public static void interactWithPlayer(){
        
        //El jugador gana si está en el campamento y capturo a wumpus
        if(myPlayer.getPosition().getId() == 0 && myWumpus.isIsCamptured()){
            System.out.println("Ganaste.");
            System.out.println("Gracias por jugar.");
            myPlayer.setOxygenOfPlayer(0);
            System.exit(0);
        }
        
        
        //Caer en un pozo y morir
        //Para cada pozo que tengo
        for (int i = 0; i < Setting.getSetting().getHole(); i++) {
            //Checar la posición del pozo y del jugador
            if(myHole[i].getPosition().getId() 
                    == myPlayer.getPosition().getId()){
                //Si es la misma posición, entonces...mata al jugador
                System.out.println("Te caiste y moriste");
                myPlayer.setOxygenOfPlayer(0);
                System.out.println("Vida "+ myPlayer.getOxygenOfPlayer());
            }
        }
        
        //Explotar
        //Para cada mina que tengo
        for (int i = 0; i < Setting.getSetting().getMine(); i++) {
            //Checar la posición de la mina y del jugador
            if(myMine[i].getPosition().getId() 
                    == myPlayer.getPosition().getId()){
                //Si es la misma posición, entonces...mata al jugador
                System.out.println("Explotaste");
                myPlayer.setOxygenOfPlayer(0);
                System.out.println("Vida "+ myPlayer.getOxygenOfPlayer());
            }
        }
        
        //Tanques de oxígeno
        //Para cada tanque de oxígeno
        for(int i = 0; i < Setting.getSetting().getTankOxygen(); i++){
            //Checar la posición del tanque de oxígeno y del jugador
            if(myTank[i].getPosition().getId() 
                    == myPlayer.getPosition().getId()){
                //Si es la misma posición, entonces...subele el oxígeno
                System.out.println("Encontraste un tanque de oxígeno.");
                myPlayer.setOxygenOfPlayer(myPlayer.getOxygenOfPlayer()+15);
                System.out.println("Oxígeno"+myPlayer.getOxygenOfPlayer());
                
            }
        }
        
        
        //Caer en una caverna de agua
        //Para cada caverna de agua que tengo
        for (int i = 0; i < Setting.getSetting().getWaterCavern(); i++) {
            if(myWaterCaverns[i].getPosition().getId() 
                    == myPlayer.getPosition().getId()){
                //Si la posición de la caverna con agua es la misma que la 
                //del jugador entonces le restará 3 de oxígeno
                myPlayer.setOxygenOfPlayer(myPlayer.getOxygenOfPlayer()-3);
                System.out.println("Oxígeno"+myPlayer.getOxygenOfPlayer());
            }
        }
        
        
        //Encontrar a Wumpus
        //Si la posición de Wumpus es la misma que la del jugador
        if(myWumpus.getPosition().getId() == myPlayer.getPosition().getId()){
            //Wumpus ha sido capturado será verdadero
            myWumpus.setIsCamptured(true);
            System.out.println("Encontraste a Wumpus");
            System.out.print("¿Quieres perdonarlo? S/N");
            char optionToKill = ' ';
            Scanner sc = new Scanner(System.in);
            optionToKill = sc.next().charAt(0);
            switch  (optionToKill){
                case 'n':
                case 'N': System.out.println("Mataste a Wumpus, regresa al"
                        + "campamento.");
                        break;
                case 's':
                case 'S': System.out.println("Eres una buena persona, vuelve "
                        + "al campamento.");
                        break;
                default : System.out.println("Eso no existe, vuelve al "
                        + "campamento.");
            }
        }
        
        
        //Encontrar huevo de pascua
        //Si la posición del huevo de pascua es la misma que la del jugador
        if(myEasterEgg.getPosition().getId() 
                == myPlayer.getPosition().getId()){
            //El jugador encontro el huevo de pascua
            myEasterEgg.setFoundEgg(true);
            System.out.println("Encontraste un huevo de pascua");
            System.out.println("Puedes ir a Estructura de Datos");
            System.out.println("Ganaste.");
            System.out.println("Gracias por jugar.");
            myPlayer.setOxygenOfPlayer(0);
            System.exit(0);
        }
        
        
        //Encontrar diamante mágico
        //Si la posición del diamante es la misma que la del jugador
        if(myDiamond.getPosition().getId() 
                == myPlayer.getPosition().getId()){
            //El jugador encontro el diamante
            myDiamond.setFoundDiamond(true);
            System.out.println("Encontraste el diamante perdido.");
            System.out.println("Con el puede ver donde está Wumpus.");
            System.out.println("Wumpus está en la caverna "
                    +myWumpus.getPosition().getId());
        }
        
        //Murciélago
        //Te manda a otra caverna
        //Para cada murciélago que tengo
        for (int i = 0; i < Setting.getSetting().getBat(); i++) {
            //Checar la posición del murciélago y del jugador
            if(myBat[i].getPosition().getId() == 
                    myPlayer.getPosition().getId()){
                //Entonces la posición del jugador cambia
                int sendToFly = (int)(Math.random() 
                        * Setting.getSetting().getCavern());
                myPlayer.setPosition(myMaze[sendToFly]);
                System.out.println("Un murciélago te dejo aquí.");
            }
        }
        
    }
    
    
    /**
     * Introducción a Hunt Wumpus.
     */
    public static void showStoryGame(){
        JOptionPane.showMessageDialog(null, "Hunt Wumpus");
        JOptionPane.showMessageDialog(null,
        "Este es el laberinto de Wumpus."
        + "Wumpus destruyo tu planeta, y ahora estás en el planeta de los "
        + "laberintos. Tu misión es encontrarlo y vengar a tu planeta");
        JOptionPane.showMessageDialog(null,
        "Estás en el campamento al inciar el juego");
        JOptionPane.showMessageDialog(null, 
        "Puedes moverte entre el laberinto de cavernas para encontrar a Wumpus"
        + "pero no estás solo, en las cavernas podrás encontrar: murciélagos+"
        + " pozos sin fin que te matan, minas explosivas, cavernas llenas de"
        + "agua y si tienes suerte un diamante mágico para encontrar a+"
        + " Wumpus");
        JOptionPane.showMessageDialog(null,
        "Encuentra a Wumpus y cuando lo tengas regresa al campamento.");
        JOptionPane.showMessageDialog(null, "Buena suerte y no mueras :)");
    }
    
    /**
     * Método para jugar
     */
    public static void play(){
        //Nivel en donde está el jugador
        System.out.println(Setting.getSetting().getLevel());
        //Cuando inicia el juego el jugador está en el campamento
        System.out.println("Estás en "+myPlayer.getPosition().getName());
        //Le avisa al jugador que Npcs se encuentran cerca en caso de que haya
        compass();
        //Lista de cavernas disponibles a las que puede moverse
        System.out.println(myPlayer.getPosition().listOfCavernsConnected());
        System.out.println("");
    }
    
    /**
     * Le pregunta al jugador a donde quiere ir.
     */ 
    public static int optionToMove(){
        //Casilla a donde quiere ir el jugador
        int option = 0; 
        //Variable para validar el try-catch
        boolean access;
        Scanner sc = new Scanner(System.in);
        do{
            //Le pedimos la caverna a donde quiere ir
            do{
                access = true;
                try {
                    System.out.println("¿A dondé quieres ir?");
                    option = 0;
                    option = sc.nextInt();
                    /**
                     * En caso de digitar un caracter no valido, atrapamos la
                     * excepción y volvemos a preguntar.
                     */
                } catch (Exception e) {
                    System.out.println("Ingrese una opción correcta.");
                    access = false;
                }
            //Este ciclo termina si recibimos un número
            }while(access==false);
            /**
             * Si de la lista que le mostramos de caverna disponibles
             * NO se encuentra la opción digitada, entonces mostrará
             * el mensaje.
             */
            if(!myPlayer.getPosition().checkConnectedCaverns(option)){
                System.out.println("Está caverna no está a tu alcance.");
            }
        /**
         * Si la caverna en donde estoy, no está conectada a la que quiero ir
         * entonces volveré a preguntar.
         */
        }while(!myPlayer.getPosition().checkConnectedCaverns(option));
        return option;
    }
    
    /**
     * Mueve al jugador a la caverna que te digito
     * Cada vez que se mueve el oxígeno del jugador reducirá en 1
     * @param optionToMove Es la opción a donde quiere moverse
     */
    public static void movePlayer(int optionToMove){
        myPlayer.setPosition(myMaze[optionToMove]);
        int myOxygen = myPlayer.getOxygenOfPlayer();
        myPlayer.setOxygenOfPlayer(myOxygen-1);
        System.out.println("Oxígeno: "+myPlayer.getOxygenOfPlayer());
    }
    
    /**
     * Le avisa al jugador lo que hay cerca de él.
     * Los objetos myDiamond y myEasterEgg, el jugador no puede saber
     * que están cerca.
     */
    public static void compass(){
        //Murciélago
        //Para cada murciélago que tengo
        for (int i = 0; i < Setting.getSetting().getBat(); i++) {
            //Checa si las cavernas están conectadas entre sí.
            if(myBat[i].getPosition().checkConnectedCaverns
                            (myPlayer.getPosition().getId())){
                //Si están conectadas entre sí, entonces...
                System.out.println("¡Cuidado hay un Murciélago cerca.");
            }
        }
        //Hoyo
        //Para cada hoyo u pozo que tengo 
        for (int i = 0; i < Setting.getSetting().getHole(); i++) {
            //Checa si las cavernas están conectadas entre sí
            if(myHole[i].getPosition().checkConnectedCaverns
                           (myPlayer.getPosition().getId())){
                //Si están conectadas entre sí, entonces...
                System.out.println("No es bueno morir por una caída, "
                        + "ten cuidado. Hay un hoyo cerca.");
            }
        }
        //Mina explosiva
        //Para cada mina que tengo
        for (int i = 0; i < Setting.getSetting().getMine(); i++) {
            //Checar si las cavernas están conectadas entre sí
            if(myMine[i].getPosition().checkConnectedCaverns
                           (myPlayer.getPosition().getId())){
                //Si están conectadas entre sí, entonces...
                System.out.println("¿No quieres perder una pierna o sí?. "
                        + "Hay una mina cerca.");
            }
        }
        
        //Caverna con agua
        //Para cada caverna de agua que tengo
        for (int i = 0; i < Setting.getSetting().getWaterCavern(); i++) {
            //Checar si las cavernas están coenctadas entre sí
            if(myWaterCaverns[i].getPosition().checkConnectedCaverns
                                   (myPlayer.getPosition().getId())){
                //Si están conectadas entre sí, entonces...
                System.out.println("Se escucha que hay agua.");
            }
        }
        //Wumpus
        //Checar si las cavernas están conectadas entre sí
        if(myWumpus.getPosition().checkConnectedCaverns
                    (myPlayer.getPosition().getId())){
            System.out.println("Huele a Wumpus.");
        }
        
        //Tanques de oxígeno
        //Para cada tanque de oxígeno que tengo
        for (int i = 0; i < Setting.getSetting().getTankOxygen(); i++) {
            //Checar si las cavernas están conectadas entre sí
            if(myTank[i].getPosition().checkConnectedCaverns
                            (myPlayer.getPosition().getId())){
                //Si están conectadas entre sí, entonces...
                System.out.println("Hay un tanque de oxígeno cerca.");
            }
        }
    }
    
    /**
     * Muestra el menú de niveles y le pide al usuario.
     */ 
    public static void menu(){
        System.out.println("Hunt Wumpus");
        System.out.println("");
        System.out.println("Elige un nivel:");
        System.out.println("1. Principiante");
        System.out.println("2. Fácil");
        System.out.println("3. Intermedio");
        System.out.println("4. Difícil");
        System.out.print(">>>");
        int optionOfLevel;
        Scanner sc = new Scanner(System.in);
        optionOfLevel = sc.nextInt();
        Setting.getSetting().setLevel(optionOfLevel-1);
    }
    /**
     * Todo lo que debe pasar antes de empezar a jugar.
     */
    public static void setUp(){
        showStoryGame();
        menu();
        createMaze();
        colocateNpcInRandomPosition();
        createConnection();
    }
    
    
    /**
     * Mensaje de que perdio el jugador.
     */
    public static void losePlayer(){
        System.out.println("Perdiste");
        System.exit(0);
    }
    
    
    public static void main(String[] args) {
        setUp();
        boolean run = false;
        do{
            play();
            int option = optionToMove();
            movePlayer(option);
            interactWithPlayer();
            if(myPlayer.getOxygenOfPlayer() == 0){
                run = true;
                losePlayer();
            }  
        }while(run == false);
        
    }
    
    
}
