
package Slick2DTest;

import org.newdawn.slick.geom.*;
import org.lwjgl.input.Mouse;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PantallaInicio extends BasicGameState{

    private Rectangle rect1 , rect2;
    private Image fondo;
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       fondo = new Image("res/Inicio.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        fondo.drawCentered(683,384);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);
        
        //play button
        if ((posX > 523 && posX < 870) && (posY > 348 && posY < 400)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(7);
            }
        }
        //exit button
        if ((posX > 523 && posX < 870) && (posY >273 && posY < 322)){
            if(Mouse.isButtonDown(0)){
            System.exit(0);
            }
        }
    }
}
