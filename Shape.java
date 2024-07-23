import java.awt.*;
import java.awt.Point;
import java.io.Serializable;


public abstract class Shape implements Serializable {
    protected Point coordinate1;

    protected Point coordinate2;
    protected Color shape_color;
    protected String text;
    private int size;
    private int strokeSize;
    private Color strokeColor;
    public void setStrokeSize(int size){
        this.strokeSize=size;
    }


    public Shape() {
    }

    public Shape(int side, Point location, Point location2, Color c,Color strokeColor) {
        this.size=side;
        this.coordinate1=location;
        this.coordinate2=location2;
        this.shape_color=c;
        this.strokeColor=strokeColor;
    }


    void setSize(int iSize) {
        if (iSize > 1) {
            size = iSize;
        } else {
            size = 1;
        }
    }

    void setLocation(Point Pcenter) {
        coordinate1 = Pcenter;
    }

    void setColor(Color Ccolor) {
        shape_color = Ccolor;
    }
    /**
     *
     * @return returns the size of the circle
     */
    int getSize()
    {
        return size;
    }

    public Point getCoordinate1() {
        return coordinate1;
    }

    public void setCoordinate1(Point coordinate1) {
        this.coordinate1 = coordinate1;
    }

    public Point getCoordinate2() {
        return coordinate2;
    }

    public void setCoordinate2(Point coordinate2) {
        this.coordinate2 = coordinate2;
    }

    public Color getShape_color() {
        return shape_color;
    }

    public void setShape_color(Color shape_color) {
        this.shape_color = shape_color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    Point getCenter()
    {
        return coordinate1;
    }

    Color getColor()
    {
        return shape_color;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public Shape(Point a, Point b, Color buttonColor, String text,int strokeSize,Color strokeColor) {//rectangle
        coordinate1 = new Point(a.x,a.y);
        coordinate2 = new Point(b.x,b.y);
        size= (int) Math.sqrt(Math.pow(coordinate1.x-coordinate2.x, 2)+(coordinate1.y-coordinate2.y));
        this.text = text;
        this.shape_color = buttonColor;
        this.strokeSize =strokeSize;
        this.strokeColor=strokeColor;
    }
    public Shape(Point a,Point b,Color c,int strokeSize,Color strokeColor){//triangle
        coordinate1 = new Point(a.x,a.y);
        coordinate2 = new Point(b.x,b.y);
        this.shape_color =c;
        this.strokeSize =strokeSize;
        this.strokeColor=strokeColor;

    }
    public Shape(int iSize, Point location, Color C,int strokeSize,Color strokeColor)//circle
    {
        setSize(iSize);
        setLocation(location);
        setColor(C);
        setStrokeSize(strokeSize);
        this.strokeColor=strokeColor;

    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public abstract String getDetail();
    public abstract void show(Graphics g,boolean clear);


}

