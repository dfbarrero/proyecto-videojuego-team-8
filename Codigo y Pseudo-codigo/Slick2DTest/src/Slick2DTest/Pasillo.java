package Slick2DTest;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Pasillo extends BasicGameState{
    
    Animation character, moveLeft, moveRight,nomoveright,nomoveleft;
    boolean sideright=true;    
    private Image pasillo;
    int[] duration = {200,200,200,200,200,200,200};
    private Input entrada;
    float characterPositionX = 24,  characterPositionY = 376;
    BasicGameState prevState = Principal.prevState;
    private Principal principal;


    @Override
    public int getID() {
       return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.pasillo = new Image("res/pasillo.jpg");
       
       principal = new Principal();
       
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
        
        this.pasillo.drawCentered(683,384);//fondo.drawCentered(683,384);//683 y 384
        this.character.draw(characterPositionX,characterPositionY);
        
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 683, 384);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        entrada = gc.getInput();
        
        if ((characterPositionX > 1195)&& (principal.isLlave())){
                Principal.prevState = this;
                sbg.enterState(8);
            }
        
        if ((characterPositionX < -32)){
                Principal.prevState = this;
                sbg.enterState(1);
            }
        
       
        
        if ((characterPositionX > 154 && characterPositionX < 256) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(4);
            }
        
        if ((characterPositionX > 575 && characterPositionX < 680) && 
           (entrada.isKeyDown(Input.KEY_J))&&(principal.isLlave())){
                Principal.prevState = this;
                sbg.enterState(5);
            }
        
        if ((characterPositionX > 575 && characterPositionX < 680) && 
           (entrada.isKeyDown(Input.KEY_J))&&(!principal.isLlave())&& Principal.nina){
                Principal.prevState = this;
                System.out.println(principal.isLlave());
                sbg.enterState(9);
            }
        
        
        
        if ((characterPositionX > 983 && characterPositionX < 1091) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(6);
            }

        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)&& sideright){ 
            character = nomoveright;
            }
        
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)&& !sideright){
                character = nomoveleft;
            }
        
        if(entrada.isKeyDown(Input.KEY_D)){
            sideright = true;
            character = moveRight;
            characterPositionX += i * .10f;
            if ((characterPositionX > 1195)&& (!principal.isLlave())){
                characterPositionX -= i * .10f;
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_A)){
            sideright = false;
            character = moveLeft;
            characterPositionX -= i * .10f;
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
               
}
        
    }
    

