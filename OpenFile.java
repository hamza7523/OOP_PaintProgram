import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;

public class OpenFile extends newRect implements popUpwindListener{
    ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");
    ArrayList<Button> buttons = new ArrayList<>();
    private boolean showOpen=true;

    public OpenFile(int x, int y, int width, int height) {
        super(x, y, width, height);
        showOpen=true;
        Button button = new ToggleButtons(545, 195, "X", 20, 20,button_dep.getImage(),button_pre.getImage(),"close");
        button.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Open file Closed");
                showOpen=false;
                button.ToggleRelease();
            }

            @Override
            public void pressed(int x, int y) {
                button.changeIcon();


            }

            @Override
            public void released(int x, int y) {
                button.setImage(button.getImage_depressed());

            }

            @Override
            public void hover(int x, int y, Graphics g) {

            }
        });
        buttons.add(button);


        Button b1 = new ToggleButtons(150,220,"File Number 1",350,50,button_dep.getImage(),button_pre.getImage(),"Select first file");
        b1.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("File 1 Clicked");

                b1.ToggleRelease();
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,20,10);
                Font f = new Font(b1.getText(),2,10);
                g.setFont(f);
                g.setColor(Color.black);
                g.drawString(b1.getText(),x+10,y+10);
            }
        });
        Button b2 = new ToggleButtons(150,271,"File Number 2",350,50,button_dep.getImage(),button_pre.getImage(),"Select File 2");
        b2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("File 2 Clicked");
                b2.ToggleRelease();
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,20,10);
                Font f = new Font(b2.getText(),2,10);
                g.setFont(f);
                g.setColor(Color.black);
                g.drawString(b2.getText(),x+10,y+10);
            }
        });
        buttons.add(b1);
        buttons.add(b2);
    }
    public boolean IsClicked(int x, int y) {
        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
            return true;
        }

        return false;
    }
    public boolean IsHover(int x,int y){
        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
            return true;
        }

        return false;
    }

    public boolean isShowOpen() {
        return showOpen;
    }

    public void Paint(Graphics g, ImageObserver observer) {
        if (showOpen == true) {
            g.setColor(Color.darkGray);
            g.fillRect(140,190,430,300);
            g.setColor(new Color(240, 30, 30));
            Font f = new Font("Files to select from",2,15);
            g.setFont(f);
            g.drawString("Files to select from",150,210);

            for (Button b : buttons) {
                b.paint(g, observer);
            }
        }
    }


    @Override
    public void clicked(int x, int y) {
        if (this.IsClicked(x, y) == true) {
            for (Button b : buttons) {
                b.IsClicked(x, y);
                if (b.IsPressed()) {
                    b.getReactor().click(x, y);
                    b.setPressed(false);
                }
            }
        }
    }

    @Override
    public void pressed(int x, int y) {

    }

    @Override
    public void released(int x, int y) {

    }

    @Override
    public void hover(int x, int y, Graphics g) {
        if (this.IsHover(x, y) == true) {
            for (Button b : buttons) {
                b.IsClicked(x, y);
                if (b.ISinside(x,y)) {
                    b.getReactor().hover(x, y,g);

                }
            }
        }
    }
    public File[] loadFile(){
        File file = new File("src/fileLoader/");
        File[] listFiles =  file.listFiles();
        int y1 =271;
        int filenum =3;
        for (File f:listFiles) {
            Button newButton = new ToggleButtons(150,271,"File Number: "+ filenum,350,50,button_dep.getImage(),button_pre.getImage(),"Select File: "+filenum);
            newButton.setReactor(new Reactor() {
                @Override
                public void click(int x, int y) {
                    System.out.println("File Clicked");

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
            y1=y1+51;
            filenum++;
            buttons.add(newButton);
        }
        return listFiles;

    }


}