import java.awt.*;

public class Lobster {
    String name;
    Image aliveimage;
    Image deadimage;
    int xpos;
    int ypos;
    int speed;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;
    boolean isalive = true;

    public Lobster () {
        hitbox = new Rectangle(xpos, ypos, width, height);
        //convention for making a rectangle
    }

    public Lobster(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput) {
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        hitbox = new Rectangle(xpos, ypos, width, height);
        //overloaded constructor... we have two constructors for Lobster. one does the same thing.
        //the second takes in a bunch of stuff. when you have a constructor and give it no input, it does
        //the first one. if you give context it bypasses the first and goes straight to the second one.
        //this is overloaded constructor
    }

    public void move(){
        xpos = xpos + (int)dx;
        ypos = ypos + (int) dy;

        if (xpos >= 1000){
           xpos=0;
        }
        else if (xpos <= 0) {
            xpos = 1000;
        }
        if (ypos >= 700){
            ypos=0;
        }
        else if (ypos <= 0){

            ypos=700;
        }
        System.out.println(xpos);
        hitbox = new Rectangle(xpos, ypos, width, height);
    }


    public static void main(String[] args) {

    }

}

