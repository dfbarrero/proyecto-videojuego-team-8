package Slick2DTest;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BotonesCocina5 extends BasicGameState{
    
    private Image cocinabotones;
    private Input entrada;
    BasicGameState prevState = Principal.prevState;
    Music luces;
    @Override
    public int getID() {
       return 45;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        luces = new Music("res/light_up.ogg");
       this.cocinabotones = new Image("res/cocina2bgRANV.jpg");
       Principal.prevState = this;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.cocinabotones.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        entrada = gc.getInput();
        
       int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);    
       
        if(entrada.isKeyDown(Input.KEY_SPACE)){
            Principal.botones = true;
            sbg.enterState(40);
            luces.play();
        }     
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
               
}
        
    }