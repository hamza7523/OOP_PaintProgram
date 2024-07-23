import java.awt.*;

public class Pentagram extends Shape {
    private int height;
    private int width;

    public Pentagram(int side, Point location, Point location2, Color C, int strokesize,Color strokeColor) {
        super(location, location2, C, strokesize,strokeColor);
        this.height = side;
        this.width = location2.y - location.y;


    }

    @Override
    public String getDetail() {
        return null;
    }

    @Override
    public void show(Graphics g, boolean clear) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        double angle_deg;
        double angle_rad;
        double innerRadius = height * Math.sin(Math.PI / 5) / Math.cos(2 * Math.PI / 5);

        for (int i = 0; i < 10; i++) {
            angle_deg = 36 * i;
            angle_rad = Math.PI / 180 * angle_deg;
            if (i % 2 == 0) {
                xPoints[i] = (int) (super.coordinate1.x + width * Math.cos(angle_rad));
                yPoints[i] = (int) (super.coordinate1.y + width * Math.sin(angle_rad));
            } else {
                xPoints[i] = (int) (super.coordinate1.x + innerRadius * Math.cos(angle_rad));
                yPoints[i] = (int) (super.coordinate1.y + innerRadius * Math.sin(angle_rad));
            }
        }





        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Polygon(xPoints, yPoints, 10));
        g2.setStroke(new BasicStroke(0));
        g.setColor(super.getColor());
        g.drawPolygon(xPoints, yPoints, 10);
        g.fillPolygon(xPoints, yPoints, 10);


    }
}

