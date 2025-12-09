//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// Graphics Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public class Fishbowl implements Runnable {

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;


    //Variable Definition Section
    //You can set their initial values too
    // Like Shark shark = new shark(); //

    Shark shark = new Shark();
    Fish Fish = new Fish();
    Lobster lobster = new Lobster();
    Image background;


    // Initialize your variables and construct your program objects here.
    public Fishbowl() { // BasicGameApp constructor
        setUpGraphics();
        shark = new  Shark(600,100,5,5,100,100);
        shark.name = "Shark Shark";
        shark.aliveimage = Toolkit.getDefaultToolkit().getImage("Shark.png");


        //variable and objects
        //create (construct) the objects needed for the game
        Fish = new Fish (500,350,8,12,100,100);
        Fish.name = "Fish Fish";
        Fish.aliveimage = Toolkit.getDefaultToolkit().getImage("fish.png");

        lobster = new Lobster (400,30,9,9,100,100);
        lobster.name = "Lobster lobster";
        lobster.aliveimage = Toolkit.getDefaultToolkit().getImage("lobster.png");

       background=Toolkit.getDefaultToolkit().getImage("ocean background.jpg");


    }
    // end Fishbowl constructor

    public void checkCollision(){

        if (Fish.hitbox.intersects(shark.hitbox)){
            Fish.isalive=false;
        }

        if (lobster.hitbox.intersects(shark.hitbox)){
            lobster.isalive=false;
        }
    }

    public void moveThings() {
        //call the move() code for each object  -
        Fish.move();
        shark.move();
        lobster.move();
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        // Signature: drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
        g.drawImage(background,0,0,1000,700,null);
        g.drawImage(Fish.aliveimage,Fish.xpos,Fish.ypos, Fish.width, Fish.height, null);
        if (Fish.isalive == false){
            Fish.aliveimage = Toolkit.getDefaultToolkit().getImage("gravestone.png");;
        }

        g.drawImage(shark.aliveimage,shark.xpos,shark.ypos, shark.width, shark.height, null);
        System.out.println("LOBSTER)");
        g.drawImage(lobster.aliveimage,lobster.xpos,lobster.ypos,lobster.width,lobster.height,null);
        //if (lobster.isalive==false){
        //    lobster.aliveimage =  Toolkit.getDefaultToolkit().getImage("cookedlobster.png");
       //\ }



        // Keep the code below at the end of render()
        g.dispose();
        bufferStrategy.show();
    }














    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    // PSVM: This is the code that runs first and automatically
    public static void main(String[] args) {
        Fishbowl ex = new Fishbowl();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            checkCollision();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename){
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}



