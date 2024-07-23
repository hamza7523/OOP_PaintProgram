import java.awt.*;

public class Triangle extends Shape{

    private double sideLength;
    private double centerX;
    private double centerY;

    public Triangle(int side, Point location, Point location2, Color C,int strokesize,Color strokeColor) {
        super(location,location2,C,strokesize,strokeColor);
        this.sideLength=side;
        centerX = (location.x + location2.x)/2 + Math.sqrt(3) * (location2.y - location.y)/2;
        centerY = (location.y + location2.y)/2 + Math.sqrt(3) * (location2.x - location.x)/2;






    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }


    @Override
    public String getDetail() {
        return null;
    }

    @Override
    public void show(Graphics g, boolean clear) {
        double[] xPoints = new double[3];
        double[] yPoints = new double[3];

        double angle = Math.toRadians(60); // angle of 60 degrees in radians
        double x1 = centerX ;
        double y1 = centerY + (sideLength / 2.0) * Math.tan(angle / 2.0);
        double x2 = centerX + sideLength / 2.0;
        double y2 = y1;
        double x3 = centerX;
        double y3 = centerY - (sideLength / 2.0) / Math.cos(angle / 2.0);

        xPoints[0] = x1;
        xPoints[1] = x2;
        xPoints[2] = x3;

        yPoints[0] = y1;
        yPoints[1] = y2;
        yPoints[2] = y3;

        int[] xIntPoints = new int[3];
        int[] yIntPoints = new int[3];

        for (int i = 0; i < 3; i++) {
            xIntPoints[i] = (int) Math.round(xPoints[i]);
            yIntPoints[i] = (int) Math.round(yPoints[i]);
        }

        Polygon polygon = new Polygon(xIntPoints, yIntPoints, 3);
        g.setColor(super.shape_color);
        g.fillPolygon(polygon);


        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(super.getStrokeSize()));
        g2.setColor(Color.black);
        g2.draw(new Polygon(xIntPoints,yIntPoints,3));

        g2.setStroke(new BasicStroke(0));

    }
}
