import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Window extends newRect {
    DrawingPanel drawingPanel;
    ArrayList<ToolBar> toolBars = new ArrayList<>();
    private int gridSize;
    private static Window window;
    public static Window getInstance(DrawingPanel drawingPanel){
        if(window==null){
            window = new Window(0,0,400,400,drawingPanel);
        }

        return window;
    }

    private Window(int x, int y, int width, int height,DrawingPanel drawingPanel) {
        super(x, y, width, height);





        ToolBar t2 = new ToolBar(300, 0, height, width, true,drawingPanel);
        gridSize =t2.getGridSize();


        toolBars.add(t2);
    }


    public void Paint(Graphics g, ImageObserver observer) {

        for (ToolBar toolBar : toolBars) {
            toolBar.Paint(g, observer);
        }


    }


}


