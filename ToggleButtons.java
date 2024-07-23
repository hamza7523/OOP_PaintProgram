import java.awt.*;
import java.awt.image.ImageObserver;

public class ToggleButtons extends Button {

    private boolean pressedFinal = false;
    private String toolTipString;

    public ToggleButtons(int x, int y, String text, int width, int height, Image i_depressed, Image i_pressed,String toolTipString) {
        super(x, y, text, width, height, i_depressed, i_pressed);
        super.setDisable(false);
        this.toolTipString=toolTipString;
        super.setToolTipString(toolTipString);


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


    public boolean IsClicked(int x, int y) {
        if (x > this.x && x < this.x + super.getWidth() && y > this.y && y < this.y + super.getHeight()) {

//          super.setTextColor(Color.RED);
            this.setPressed(true);

            super.setPressed(true);
            Image i = super.getPressedImage();
            super.setImage(i);



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
        super.setHovering(false);
        return false;

    }


    public void colorSelection() {
        for (int r = 0; r < 256; r++) {
            for (int g = 0; g < 256; g++) {
                for (int b = 0; b < 256; b++) {
                    Button buttons = new ColorButton(r,g,1,1,new Color(r,g,b));
                }
            }
        }
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        super.paint(g, observer);
        if(this.isHovering()) {
            if (this.toolTipString.startsWith("R")) {
                g.setColor(Color.black);
                g.fillRect(x + 50, y + 50, 70, 30);
                String statement = toolTipString;

                Font f = new Font("Ariel", 2, 10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() - m.getDescent();


                g.setColor(Color.red);
                g.drawString(statement, (x + 50) + 70 / 2 - width / 2, (y + 50) + 30 / 2 + height / 2);
            } else {
                g.setColor(Color.black);
                g.fillRect(x + 30, y + 30, 70, 30);
                String statement = toolTipString;

                Font f = new Font("Ariel", 2, 10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() - m.getDescent();


                g.setColor(Color.red);
                g.drawString(statement, (x + 30) + 70 / 2 - width / 2, (y + 30) + 30 / 2 + height / 2);

            }
        }


    }


}


