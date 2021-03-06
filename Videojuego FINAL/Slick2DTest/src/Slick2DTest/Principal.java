package Slick2DTest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Principal extends StateBasedGame{
    MinijuegoLlave minijuego = new MinijuegoLlave();
    MinijuegoCuchillo minijuego2 = new MinijuegoCuchillo();
    public static boolean llave = false;
    public static boolean tuberia = false;
    public static boolean de32a8 = false;
    public static boolean viejo = false;
    public static boolean nina  = false; 
    public static boolean chino  = false; 
    public static boolean botones  = false;
    public static boolean cuchillo  = false;
    public static boolean creditos  = false;
    public static boolean agujero  = false;
    public static BasicGameState prevState  = null;
    public static BasicGameState prevState2  = null;
    public static int puntuacionMinijuegoLlave = 0;
    public static int vidasMinijuegoLlave = 3;
    public static int vidasMinijuegoCuchillo = 1;
    public static float characterPositionX8; 

    public static boolean isLlave() {
        return llave;
    }

    public static boolean isCuchillo() {
        return cuchillo;
    }

    public static void setVidasMinijuegoCuchillo(int vidasMinijuegoCuchillo) {
        Principal.vidasMinijuegoCuchillo = vidasMinijuegoCuchillo;
    }

    public static void setPuntuacionMinijuegoLlave(int puntuacionMinijuegoLlave) {
        Principal.puntuacionMinijuegoLlave = puntuacionMinijuegoLlave;
    }

    public static void setVidasMinijuegoLlave(int vidasMinijuegoLlave) {
        Principal.vidasMinijuegoLlave = vidasMinijuegoLlave;
    }
    
    
    
    public static void main(String[] args) {
        
        try{
        AppGameContainer contenedor = new AppGameContainer(new Principal());
        contenedor.setDisplayMode(1366,768, false);
        contenedor.setShowFPS(false);
        contenedor.start();
       }catch(SlickException slick){
           slick.printStackTrace();
           System.exit(1);
       }       
    }
  
    public Principal() throws SlickException {
        super("Hellingly");
       
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       this.addState(new PantallaInicio());
       this.addState(new Pasillo());
       this.addState(new EscapeMenu());
       this.addState(new Habitacion1(this));
       this.addState(new Habitacion2(minijuego));
       this.addState(new Habitacion3());
       this.addState(new Recepcion());
       this.addState(new Hall1());
       this.addState(new MinijuegoLlave());
       this.addState(new GameOverMinijuegoLlave(minijuego));
       this.addState(new GameWinMinijuegoLlave(minijuego));
       this.addState(new EscenaNiña1());
       this.addState(new EscenaNiña2());
       this.addState(new EscenaNiña3());
       this.addState(new EscenaNiña4());
       this.addState(new EscenaNiña5());
       this.addState(new EscenaNiña6());
       this.addState(new EscenaNiña7());
       this.addState(new EscenaNiña8());
       this.addState(new EscenaNiña9());
       this.addState(new EscenaNiña10());
       this.addState(new EscenaViejo1());
       this.addState(new EscenaViejo2());
       this.addState(new EscenaViejo3());
       this.addState(new EscenaViejo4());
       this.addState(new EscenaViejo5());
       this.addState(new EscenaViejo6());
       this.addState(new EscenaViejo7());
       this.addState(new EscenaViejo8());
       this.addState(new EscenaViejo9());
       this.addState(new EscenaViejo10());
       this.addState(new Hallviejo_tuberia());
       this.addState(new Video_inicial());
       this.addState(new PasilloSecreto());
       this.addState(new HabitacionAgujero());
       this.addState(new Pasillo2());
       this.addState(new Habitacion2_1());
       this.addState(new Habitacion2_2());
       this.addState(new Hall2());
       this.addState(new Pasillo3());
       this.addState(new Cocina());
       this.addState(new BotonesCocina1());
       this.addState(new BotonesCocina2());
       this.addState(new BotonesCocina3());
       this.addState(new BotonesCocina4());
       this.addState(new BotonesCocina5());
       this.addState(new Pasillo4());
       this.addState(new HabitacionAgujero3());
       this.addState(new PasilloFinal());
       this.addState(new Habitacion3_1());
       this.addState(new EscenaChinoNegro1());
       this.addState(new EscenaChinoNegro2());
       this.addState(new EscenaChinoNegro3());
       this.addState(new EscenaChinoNegro4());
       this.addState(new EscenaChinoNegro5());
       this.addState(new EscenaChinoNegro6());
       this.addState(new EscenaChinoNegro7());
       this.addState(new EscenaChinoNegro8());
       this.addState(new EscenaChinoNegro9());
       this.addState(new EscenaChinoNegro10());
       this.addState(new EscenaChinoNegro11());
       this.addState(new EscenaChinoNegro12());
       this.addState(new EscenaChinoNegro13());
       this.addState(new Posit2_2());
       this.addState(new Posit2_1());
       this.addState(new MinijuegoCuchillo());
       this.addState(new GameOverMinijuegoCuchillo(minijuego2));
       this.addState(new GameWinMinijuegoCuchillo(minijuego2));
       this.addState(new Habitacion3_2());
       this.addState(new HabitacionFinal());
       this.addState(new Controls());
       this.addState(new Anillo());
       this.addState(new Creditos());
       this.addState(new PreMinijuegoLlave());
       this.addState(new PreMinijuegoCuchillo());
    }    

}
