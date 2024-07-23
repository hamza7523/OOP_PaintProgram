import java.awt.*;
import java.awt.image.ImageObserver;

public class ColorButton extends Button {

    private Color c;

    int red;
    int green;
    int blue;
    private boolean checker;
    public void setColors(int red,int green,int blue){
        this.red =red;
        this.green=green;
        this.blue=blue;
    }
    public void setnewColor(Color c){
        this.c = c;
    }
    public String getColors(int red,int green,int blue){
        return "Red: "+red+",  Blue: "+blue+"Green: "+green;
    }
    public void PaintString(Graphics g,ColorButton b,int red,int green,int blue){
        g.setColor(Color.black);
        Font f = new Font(b.getColors(red,green,blue),2,30);
        g.setFont(f);
        g.drawString(b.getColors(red, green, blue),600,600);
    }


    public ColorButton(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        this.c=color;
    }
    public Boolean IsPressed()
    {
        return super.getPressed();
    }
    public void setC(int r,int g, int b){
        this.c= new Color(r,g,b);

    }
    public void setRGB(int red,int green,int blue){

    }


    @Override
    public boolean IsClicked(int x, int y) {
        if (x >= this.x && x < this.x + super.getWidth() && y >= this.y && y < this.y + super.getHeight()) {
           // super.setDisable(false);


            super.setPressed(true);

            Image i = super.getPressedImage();
            super.setImage(i);

            //super.setState(true);

            return true;
        }
        return false;
    }

    @Override
    public boolean ISinside(int x, int y) {
        if (x > this.x && x < this.x + super.getWidth() && y > this.y && y < this.y + super.getHeight()) {
            super.setHovering(true);
            return true;
        }
        return false;
    }

    public Color getC(){
    return this.c;

}

    

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(this.c);
        g.fillRect(this.x,this.y,this.width,this.height);
        g.setColor(Color.black);
        g.drawRect(this.x+1,this.y+1,this.width+1,this.height+1);

//        g.fillRect(this.x+1,this.y+1,this.width-(3),this.height-(3));

    }

}


