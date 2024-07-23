import java.awt.*;
import java.awt.image.ImageObserver;

public class ActiveButtons extends Button {

    public ActiveButtons(int x, int y, String text, int width, int height, Image i_depressed, Image i_pressed) {
        super(x, y, text, width, height, i_depressed, i_pressed);
        super.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {

            }

            @Override
            public void pressed(int x, int y) {


            }

            @Override
            public void released(int x, int y) {


            }

            @Override
            public void hover(int x, int y, Graphics g) {

            }


        });
    }

    @Override
    public boolean IsClicked(int x, int y) {
        if(x > this.x && x < this.x + super.getWidth() && y > this.y && y < this.y + super.getHeight())
        {
            super.setPressed(true);
            super.setImage(super.getImage_depressed());


            return true;
        }
        return false;
    }

    @Override
    public boolean ISinside(int x, int y) {
        if (x > this.x && x < this.x + super.getWidth() && y > this.y && y < this.y + super.getHeight()) {
            super.setHovering(true);
            return true;
        }
        return false;
    }

    public void paint(Graphics g, ImageObserver observer) {
        super.paint(g, observer);


    }
}
