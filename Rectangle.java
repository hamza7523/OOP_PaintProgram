import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {
    private int height;
    private int width;
    private int strokeSize;


//    public Rectangle(String text, Point coordinate1, Point coordinate2, Color c) {
//        super(coordinate1, coordinate2, c, text,3);
//        height = coordinate2.x - coordinate1.x;
//        width = coordinate2.y - coordinate1.y;
//
//
//    }


    public String getDetail(){
        return "Rectangle"+":"+super.coordinate1.x+":"+super.coordinate1.y+":"+super.coordinate2.x+":"+super.coordinate2.y+":"+shape_color.getRed()+":"+shape_color.getBlue()+":"+shape_color.getGreen()+":"+this.getSize();
    }

    public Rectangle(int side, Point location, Point location2, Color C,int strokesize,Color strokeColor) {
        super(location,location2,C,strokesize,strokeColor);
        this.height = side;
        this.width = location2.y - location.y;
        this.strokeSize=strokesize;



    }


    public int remove1(){
        DrawingPanel p = new DrawingPanel();
        int x= p.DEFAULT_HEIGHT;
        return x;

    }
    public int remove2(){
        DrawingPanel p = new DrawingPanel();
        int y = p.DEFAULT_WIDTH;
        return y;
    }




    @Override
    public void show(Graphics g, boolean clear) {


        if (clear == true) {
            g.fillRect(0, 0,remove1(),remove2());
        } else {
            g.setColor(this.getColor());
            Font f = new Font(text, 1, 3);
            g.setFont(f);
            g.fillRect(super.coordinate1.x - super.getSize() / 2, super.coordinate1.y - super.getSize() / 2, height, width);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(super.getStrokeColor());
            g2.setStroke(new BasicStroke(strokeSize));

            g2.draw(new Rectangle2D.Double(super.coordinate1.x - super.getSize() / 2, super.coordinate1.y - super.getSize() / 2, height, width));
            g2.setStroke(new BasicStroke(0));



            //g.fillRect(super.coordinate1.x - super.getSize() / 2, super.coordinate1.y - super.getSize() / 2, height, width);

        }


    }
}
