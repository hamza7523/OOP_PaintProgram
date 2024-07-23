import java.awt.*;
import java.awt.image.ImageObserver;

public class Tooltip extends newRect{




    public Tooltip(Point location,int width,int height) {
        super(location.x, location.y,width,height);


    }
    public void paint(Graphics g,String text){

        g.drawRect(super.x,super.y,20,20);
        Font f = new Font("Ariel",1,10);
        g.setFont(f);
        FontMetrics m = g.getFontMetrics();
        int width = m.stringWidth(text);
        int height = m.getAscent() -m.getDescent();
        g.setColor(Color.black);
        g.drawString(text,super.x+ 20/2-width/2,super.y+15/2+height/2);



    }


}
