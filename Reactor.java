import java.awt.*;

public interface Reactor {
    public void click(int x, int y);
    public void pressed(int x,int y);
    public void released(int x,int y);
    public void hover(int x, int y, Graphics g);
}
