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

public class PasilloSecreto extends BasicGameState {

    Animation character, moveLeft, moveRight,nomoveright,nomoveleft;
    private Image pasilloSecreto;
    boolean sideright=true;
    int[] duration = {200,200,200,200,200,200,200};
    private Input entrada;
    float characterPositionX = 24,  characterPositionY = 376;
    BasicGameState prevState = Principal.prevState;
    Music pasos;
    boolean playpasos = false;
    
    @Override
    public int getID() {
       return 33;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.pasilloSecreto = new Image("res/pasillosecreto.jpg");
       Principal.prevState = this;
       this.pasos = new Music ("res/Pasos.ogg");
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
        
        this.pasilloSecreto.drawCentered(683,384);
        this.character.draw(characterPositionX,characterPositionY);
        
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 683, 384);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        entrada = gc.getInput();

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
        
        if(entrada.isKeyDown(Input.KEY_D)){
            sideright = true;
            character = moveRight;
            characterPositionX += i * .1f;
            if (!playpasos){
                pasos.play();
                playpasos = true;
            }
            if (characterPositionX >1199){
                sbg.enterState(34);
                sideright = false;
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
            if (characterPositionX < -32){
                    sbg.enterState(47);
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
               
}
        
    }
