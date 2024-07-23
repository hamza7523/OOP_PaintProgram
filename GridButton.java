import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GridButton extends Button implements Reactor{
    private int gridSize;
    private int number;
    private int count=1;
    private boolean isPressed=false;

    private Image current_image;
    private static GridButton gridButton;


    ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");
    private Image image_depressed=button_dep.getImage();
    private Image image_pressed=button_pre.getImage();

    public int getGridSize() {
        return gridSize;
    }
    public static GridButton getInstance(int gridSize){
        if(gridButton==null){
            gridButton=new GridButton(370,100,40,40,gridSize,0);
        }
        return gridButton;
    }

    private GridButton(int x, int y, int width, int height, int size, int number) {
        super(x,y,width,height,Color.black);
        image_depressed = image_depressed.getScaledInstance(width,height,Image.SCALE_FAST);
        image_pressed = image_pressed.getScaledInstance(width,height,Image.SCALE_FAST);
        current_image = image_depressed;


        this.gridSize = size;
        this.number=number;

    }
    public void setSize(){
         switch (count){
             case 1:
                 gridSize =1000;

                 break;
             case 2:
                 gridSize = 2;
                 number=2;
                 break;
             case 3:
                 gridSize = 4;
                 number=4;
                 break;
             case 4:
                 gridSize =8;
                 number=8;
                 break;
             case 5:
                 gridSize =16;
                 number=16;
                 break;
             case 6:
                 gridSize = 32;
                 number =32;
                 break;
             case 7:
                 gridSize=64;
                 number=64;
                 break;
         }
    }


    public boolean IsClicked(int x, int y) {

        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
count++;


            System.out.println("Grid pressed");
            if(count%8==0){
                count=1;
            }


            setSize();
            isPressed = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean ISinside(int x, int y) {
        return false;
    }

    public void paint(Graphics g, ImageObserver observer){


        g.drawImage(current_image,x,y,observer);
        Font f = new Font("Ariel",1,12);
        g.setFont(f);
        FontMetrics m = g.getFontMetrics();
        String text ="";
        if(count==1){
            text = "OFF";
        }else{
            text = number+"";
        }
        int width = m.stringWidth(text);
        int height = m.getAscent() -m.getDescent();



        g.setColor(Color.darkGray);
        g.drawString(text,x+this.width/2-width/2,y+this.height/2+height/2);
        g.setColor(Color.lightGray);
        g.drawString("Grid Button",363,90);




    }

    @Override
    public void click(int x, int y) {
        this.IsClicked(x,y);



    }

    @Override
    public void pressed(int x, int y) {

    }

    @Override
    public void released(int x, int y) {

    }

    @Override
    public void hover(int x, int y, Graphics g) {

    }
}
