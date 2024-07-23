import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape{


    private boolean pen;

    /**
         * This is the Circle constructor
         * @param iSize	defines the size
         * @param location defines the location
         * @param C	defines the color
         */
        Circle(int iSize, Point location, Color C,int strokeSize,Color strokeColor)
        {
            super(iSize,location,C,strokeSize,strokeColor);
        }
        public int remove1(){
            DrawingPanel p = new DrawingPanel();
            int x= p.DEFAULT_HEIGHT;
            return x;

        }
        Circle(int iSize, Point location, Color C,int strokeSize,boolean pen,Color strokeColor){
            super(iSize,location,C,strokeSize,strokeColor);
            this.pen = pen;

        }
        public String getDetail(){
            return "Circle"+":"+super.coordinate1.x+":"+super.coordinate1.y+":"+shape_color.getRed()+":"+shape_color.getBlue()+":"+shape_color.getGreen()+":"+super.getSize();
        }
        public int remove2(){
            DrawingPanel p = new DrawingPanel();
            int y = p.DEFAULT_WIDTH;
            return y;
        }



        public void show(Graphics g,boolean clear)
        {



            if(clear == true){
                g.setColor(Color.white);
                g.fillRect(0, 0, remove1(), remove2());
            }
            if(pen==true){
                g.setColor(getStrokeColor());
            }else{
                g.setColor(getColor());
            }


                g.fillOval(super.getCenter().x - super.getSize() / 2, super.getCenter().y - super.getSize() / 2, super.getSize(), super.getSize());

            Graphics2D g2 = (Graphics2D) g;
            if(pen==true){
                g2.setColor(getStrokeColor());
            }else {
                g2.setColor(getStrokeColor());
            }
            g2.setStroke(new BasicStroke(super.getStrokeSize()));
            g2.draw(new Ellipse2D.Double(super.getCenter().x - super.getSize()/2 ,super.getCenter().y - super.getSize()/2,super.getSize(),super.getSize()));
            g2.setStroke(new BasicStroke(0));


        }
}

