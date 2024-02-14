package entity.dinamicEntity.enemy;

import entity.dinamicEntity.Camera;
import entity.dinamicEntity.MovingEntity;

public class Enemy extends MovingEntity {

    Camera camera;

    public Enemy(int x, int y, int width, int height) {

        super(x, y, width, height);
        
        getHitBox().translate(width/4, height/4);
        getHitBox().setSize(width/2, height/2);

        //setting animations
        String[] movingLeft = {"icons/hero/movingLeft/movingLeft1.png",
                                "icons/hero/movingLeft/movingLeft2.png"};
        String[] movingRight = {"icons/hero/movingRight/movingRight2.png",
                                "icons/hero/movingRight/movingRight1.png"};
        String[] standingStill = {"icons/hero/standStill/standingStill1.png",
                                "icons/hero/standStill/standingStill2.png"};
        
        setStillSprites(standingStill);
        setLeftSprites(movingLeft);
        setRightSprites(movingRight);

        setCamera(new Camera(x, y, width, height));

    }


































    @Override
    public void run() {
        while(getHp() > 0) {
            try {
                move();
                Thread.sleep(15);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }

    @Override
    public void move() {
        

    }

    @Override
    public void update_position() {
        
    }

    @Override
    public int calcXdirection() {
       return 0;
    }

    @Override
    public int calcYdirection() {
       return 0;
    }

    
    
}
