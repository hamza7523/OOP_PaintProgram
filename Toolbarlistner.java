import java.awt.*;

public interface Toolbarlistner {
    public void clicked(int x,int y);
    public void released(int x,int y);

    public void hover(int x, int y, Graphics g);//remove graphics
    public void mouseEntered(int x, int y,Graphics g);
    public void mouseExited(int x, int y);
}
