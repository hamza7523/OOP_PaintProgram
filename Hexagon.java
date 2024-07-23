import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Hexagon extends Shape{
    private int height;
    private int width;
    public Hexagon(int side, Point location, Point location2, Color C,int strokesize,Color strokeColor) {
        super(location,location2,C,strokesize,strokeColor);
        this.height = side;
        this.width = location2.y - location.y;



    }
    @Override
    public String getDetail() {
        return null;
    }

    @Override
    public void show(Graphics g, boolean clear) {
            int[] xPoints = new int[6];
            int[] yPoints = new int[6];

            for (int i = 0; i < 6; i++) {
                double angle_deg = 60 * i - 30;
                double angle_rad = Math.PI / 180 * angle_deg;
                xPoints[i] = (int) (super.coordinate1.x + height * Math.cos(angle_rad));
                yPoints[i] = (int) (super.coordinate2.y + width * Math.sin(angle_rad));
            }


        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(super.getStrokeColor());
        g2.setStroke(new BasicStroke(7));
        g2.draw(new Polygon(xPoints,yPoints,6));
        g2.setStroke(new BasicStroke(0));
        g.setColor(super.getColor());
        g.drawPolygon(xPoints, yPoints, 6);
        g.fillPolygon(xPoints,yPoints,6);
        }

    }

