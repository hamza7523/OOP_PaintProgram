import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

public class BezierCurve extends Shape {

    private ArrayList<Point> controlPoints;
    private int strokeSize=4;
    private Color strokeColor;

    public BezierCurve(ArrayList<Point> controlPoints, int strokeSize, Color strokeColor) {
        this.controlPoints = controlPoints;
        this.strokeSize=strokeSize;
        this.strokeColor=strokeColor;
    }

    @Override
    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    @Override
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public BezierCurve(){}

    public void setControlPoints(ArrayList<Point> controlPoints) {

        this.controlPoints = controlPoints;
    }

    @Override
    public void show(Graphics g,boolean clear) {
        if (controlPoints.size() == 2) {
            // Only two points, draw a straight line
            Point p1 = controlPoints.get(0);
            Point p2 = controlPoints.get(1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        } else if (controlPoints.size() ==3) {
            // More than two points, draw a Bezier curve
            int n = controlPoints.size() - 1;
            int[] xPoints = new int[n + 1];
            int[] yPoints = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                xPoints[i] = controlPoints.get(i).x;
                yPoints[i] = controlPoints.get(i).y;
            }

            for (double t = 0.0; t < 1.0; t += 0.01) {
                int x = (int) getX(t, xPoints);
                int y = (int) getY(t, yPoints);
                int x1 = (int) getX(t + 0.01, xPoints);
                int y1 = (int) getY(t + 0.01, yPoints);
                Graphics2D g2 =(Graphics2D) g;
                g2.setStroke(new BasicStroke(strokeSize));
                g2.setColor(strokeColor);
                g.drawLine(x, y, x1, y1);
                g2.setStroke(new BasicStroke(1));
            }
        }

                if (controlPoints.size() == 4) {
                    Point p1 = controlPoints.get(0);
                    Point p2 = controlPoints.get(1);
                    Point c1 = controlPoints.get(2);
                    Point c2 = controlPoints.get(3);
                    for (double t = 0.0; t < 1.0; t += 0.01) {
                        int x = (int) Math.round(Math.pow(1 - t, 3) * p1.x + 3 * Math.pow(1 - t, 2) * t * c1.x + 3 * (1 - t) * Math.pow(t, 2) * c2.x + Math.pow(t, 3) * p2.x);
                        int y = (int) Math.round(Math.pow(1 - t, 3) * p1.y + 3 * Math.pow(1 - t, 2) * t * c1.y + 3 * (1 - t) * Math.pow(t, 2) * c2.y + Math.pow(t, 3) * p2.y);
                        int x1 = (int) Math.round(Math.pow(1 - t - 0.01, 3) * p1.x + 3 * Math.pow(1 - t - 0.01, 2) * (t + 0.01) * c1.x + 3 * (1 - t - 0.01) * Math.pow(t + 0.01, 2) * c2.x + Math.pow(t + 0.01, 3) * p2.x);
                        int y1 = (int) Math.round(Math.pow(1 - t - 0.01, 3) * p1.y + 3 * Math.pow(1 - t - 0.01, 2) * (t + 0.01) * c1.y + 3 * (1 - t - 0.01) * Math.pow(t + 0.01, 2) * c2.y + Math.pow(t + 0.01, 3) * p2.y);
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setStroke(new BasicStroke(4));
                        g2.setColor(strokeColor);
                        g.drawLine(x, y, x1, y1);
                        g2.setStroke(new BasicStroke(1));
                    }
                }
            }


    private double getX(double t, int[] xPoints) {
        int n = xPoints.length - 1;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += bernstein(n, i, t) * xPoints[i];
        }
        return result;
    }

    private double getY(double t, int[] yPoints) {
        int n = yPoints.length - 1;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += bernstein(n, i, t) * yPoints[i];
        }
        return result;
    }

    private double bernstein(int n, int i, double t) {
        return binomialCoefficient(n, i) * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }

    private int binomialCoefficient(int n, int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n - i + 1;
            result /= i;
        }
        return result;
    }


    @Override
    public String getDetail() {
        return null;
    }




}
