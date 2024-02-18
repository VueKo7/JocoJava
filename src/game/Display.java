package game;
<<<<<<< HEAD
import input.KeyboardInput;
=======
<<<<<<< HEAD
import input.KeyboardInput;
=======
import input.MovesetInput;
import input.GUI_Input;
>>>>>>> 9602fc39f3ad420789f15827962d3aa85957904b
>>>>>>> b458b0f4cdde5bba34b1f4f0952524746caceecd
import input.MouseInput;
import entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    public final static int BOARD_WIDTH = 1280;
    public final static int BOARD_HEIGHT = 720;

    private Canvas canvas;

<<<<<<< HEAD
    public Display(KeyboardInput keyboardInput, MouseInput mouseInput) {
=======
<<<<<<< HEAD
    public Display(KeyboardInput keyboardInput, MouseInput mouseInput) {
=======
    public Display(MovesetInput movesetInput, MouseInput mouseInput, GUI_Input GUI_input) {
>>>>>>> 9602fc39f3ad420789f15827962d3aa85957904b
>>>>>>> b458b0f4cdde5bba34b1f4f0952524746caceecd
        setTitle("My Awesome 2D game.Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        canvas.setFocusable(false);
        add(canvas);

        canvas.addMouseListener(mouseInput);
<<<<<<< HEAD
        this.addKeyListener(keyboardInput);
=======
<<<<<<< HEAD
        this.addKeyListener(keyboardInput);
=======
        this.addKeyListener(movesetInput);
        this.addKeyListener(GUI_input);
>>>>>>> 9602fc39f3ad420789f15827962d3aa85957904b
>>>>>>> b458b0f4cdde5bba34b1f4f0952524746caceecd
        
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();


        //visualizzazione Canvas
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, BOARD_WIDTH-1, BOARD_HEIGHT-1);


        //visualizzazione Camera
        graphics.setColor(Color.RED);
        graphics.drawRect(game.player.getCamera().getX(), game.player.getCamera().getY(), game.player.getCamera().getWidth(), game.player.getCamera().getHeight());


        //visualizzazione personaggio
        graphics.drawImage(game.player.getFrame(), game.player.getX(), game.player.getY(), null);
        
        graphics.setColor(Color.BLUE);
        graphics.drawRect(game.player.getX(), game.player.getY(), game.player.getWidth(), game.player.getHeight());
        
        graphics.setColor(Color.RED);
        graphics.drawRect(game.player.getXHitbox(), game.player.getYHitbox(), game.player.getHitBoxWidth(), game.player.getHitBoxHeight());


        //visualizzazione entità a schermo
        Entity.getEntities().forEach((Entity e) -> {

        //ottengo tutti gli angoli dell'enità
            Point topLeft = new Point(e.getX(), e.getY());
            Point topRight = new Point(e.getX()+e.getWidth(), e.getY());
            Point bottomLeft = new Point(e.getX(), e.getY()+e.getHeight());
            Point bottomRight = new Point(e.getX()+e.getWidth(), e.getY()+e.getHeight());
            Point leftFuoco = new Point(e.getX()+e.getWidth()/3, e.getY()+e.getHeight()/2);
            Point rightFuoco = new Point(e.getX()+(e.getWidth()-e.getWidth()/3), e.getY()+e.getHeight()/2);
            
        //se almeno un angolo dell'entità compare a schermo allora disegno l'entità
            if(contains(topLeft, topRight, bottomLeft, bottomRight, leftFuoco, rightFuoco)) {
                graphics.drawImage(e.getFrame(), e.getX(), e.getY(), null);
            }
        });

        graphics.dispose();
        bufferStrategy.show();
    }

//controlla che almeno uno dei quattro angoli sia presente a schermo
    public boolean contains(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight, Point leftFuoco, Point rightFuoco) {
        
        return (canvas.contains(topLeft) 
        || canvas.contains(topRight)
        || canvas.contains(bottomLeft)
        || canvas.contains(bottomRight)
        || canvas.contains(leftFuoco)
        || canvas.contains(rightFuoco));
    }

   
}
