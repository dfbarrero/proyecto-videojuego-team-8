package Slick2DTest;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Habitacion3_1 extends BasicGameState {

    Animation character, moveLeft, moveRight,nomoveright,nomoveleft;
    boolean sideright=true;
    private Image habitacion;
    int[] duration = {200,200,200,200,200,200,200};
    private Input entrada;
    float characterPositionX = 250,  characterPositionY = 376;
    BasicGameState prevState = Principal.prevState;
    boolean playpasos = false;
    Music pasos;
    Music fantasmachino;
    
    @Override
    public int getID() {
        return 49;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.habitacion = new Image("res/habitacion3fantasma.jpg");
       this.pasos = new Music("res/Pasos2.ogg");
       this.fantasmachino = new Music("res/fantasma_hombre.ogg");
       Principal.prevState = this;
       Image[] walkRight = {new Image("res/B.ANIM_1.png"),new Image("res/B.ANIM_2.png"),new Image("res/B.ANIM_3.png"),new Image("res/B.ANIM_4.png"),new Image("res/B.ANIM_5.png"),new Image("res/B.ANIM_6.png"),new Image("res/B.ANIM_7.png")}; 
       Image[] walkLeft = {new Image("res/B.ANIM_1_OPUESTO.png"),new Image("res/B.ANIM_2_OPUESTO.png"),new Image("res/B.ANIM_3_OPUESTO.png"),new Image("res/B.ANIM_4_OPUESTO.png"),new Image("res/B.ANIM_5_OPUESTO.png"),new Image("res/B.ANIM_6_OPUESTO.png"),new Image("res/B.ANIM_7_OPUESTO.png")};
       Image[] nowalkright = {new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png")};
       Image[] nowalkleft = {new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png")};
        
       moveRight = new Animation(walkRight, duration, true);
       moveLeft = new Animation(walkLeft,duration,true);
       nomoveright = new Animation(nowalkright,duration,true);
       nomoveleft = new Animation(nowalkleft,duration,true);
       
       character = nomoveright;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.habitacion.drawCentered(683,384);
        this.character.draw(characterPositionX,characterPositionY);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
         entrada = gc.getInput();
       
        if (characterPositionX < 234){
           {
                sbg.enterState(48);
                pasos.stop();
                sideright = true;
                characterPositionX = 250;
            }
        }
        
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)&& sideright){ 
            character = nomoveright;
                            pasos.stop();
                playpasos = false;
            }
        
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)&& !sideright){
                character = nomoveleft;
                                pasos.stop();
                playpasos = false;
            }
        
        if (characterPositionX > 719 && !Principal.chino){
           {
               Principal.chino = true;
                sbg.enterState(50);
                fantasmachino.play();
                pasos.stop();
                sideright = true;
                characterPositionX = 250;
                
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_D)){
            sideright = true;
            character = moveRight;
            characterPositionX += i * .1f;
                       if (!playpasos){
                pasos.play();
                playpasos = true;
            }
            if (characterPositionX > 939){
                    characterPositionX -= i *.10f;
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_A)){
            sideright = false;
            character = moveLeft;
            characterPositionX -= i * .1f;
                       if (!playpasos){
                pasos.play();
                playpasos = true;
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
            pasos.stop();
        }
    }
    
}
