import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ShapesToolbar extends newRect implements popUpwindListener{
    private Filetoolbar filetoolbar;
    private DrawingPanel panel;
    Tooltip tooltip;
    ImageIcon[] shapes = new ImageIcon[13];
    public ArrayList<Button> buttons = new ArrayList<>();
    public ArrayList<Button> strokeButtons = new ArrayList<>();
    ImageIcon pendepressed = new ImageIcon("newPen1.png");
    ImageIcon penPressed = new ImageIcon("newPen2.png");
    ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");

    ToolBar toolBar;
    public boolean colorSelect;
    public void pressingCheck(){
        boolean checker=false;
        for (Button button:buttons) {
            if(button.IsPressed()){
                checker=true;
            }else{
                checker=false;
            }

        }

        System.out.println(checker);
        if(checker==true){
            rel_allToggles(null);
        }
    }
    public void rel_allToggles(Button b) {
        if (b == null) {
            for (Button button : buttons) {
                button.ToggleRelease();
                panel.keyPressed=0;

            }
        } else {
            for (Button button : buttons) {
                if (button.equals(b)) {
                    System.out.println("Not released");
                } else {
                    button.ToggleRelease();
                }
            }
        }
    }
    public void rel_allStrokes(Button b) {
        if (b == null) {
            for (Button button : strokeButtons) {
                button.ToggleRelease();
                panel.strokeWidth=1;

            }
        } else {
            for (Button button : strokeButtons) {
                if (button.equals(b)) {
                    System.out.println("Not released");
                } else {
                    button.ToggleRelease();
                }
            }
        }
    }





    public ShapesToolbar(int x, int y, int height, int width, boolean check, ToolBar toolBar, Filetoolbar filetoolbar, DrawingPanel drawingPanel) {
        super(x, y, width, height);
        loadImages();
        this.toolBar=toolBar;
        this.filetoolbar =filetoolbar;
        this.panel = drawingPanel;
        Button stroke1 = new ToggleButtons(70,90,"1",30,30, button_dep.getImage(), button_pre.getImage(),"Size: 1");
        stroke1.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                panel.strokeWidth=3;
                System.out.println("size 1 selected");
                rel_allStrokes(stroke1);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                if(stroke1.isHovering()==true){
                    stroke1.tooltip.paint(g,"stroke size 1");
                }
//                g.drawRect(x+10,y+10,20,10);
//                String statement = "Select size 1";
//                Font f = new Font(statement,2,10);
//                g.setFont(f);
//                g.setColor(Color.black);
//                g.drawString(statement,x+10,y+10);
            }
        });
        strokeButtons.add(stroke1);
        Button stroke2 = new ToggleButtons(100,90,"5",30,30, button_dep.getImage(), button_pre.getImage(),"Size: 5");
        stroke2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                panel.strokeWidth=6;
                rel_allStrokes(stroke2);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {


            }

            @Override
            public void hover(int x, int y, Graphics g) {
//                g.drawRect(x+10,y+10,20,10);
//                String statement = "Select size 5";
//                Font f = new Font(statement,2,10);
//                g.setFont(f);
//                g.setColor(Color.black);
//                g.drawString(statement,x+10,y+10);
            }
        });
        strokeButtons.add(stroke2);
        Button stroke3 = new ToggleButtons(130,90,"7",30,30, button_dep.getImage(), button_pre.getImage(),"Size: 7");
        stroke3.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                panel.strokeWidth=(10);
                rel_allStrokes(stroke3);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {

//                    g.drawRect(x+10,y+10,70,30);
//                    String statement = "stroke size 7";
//
//                    Font f = new Font("Ariel",1,10);
//                    g.setFont(f);
//                    FontMetrics m = g.getFontMetrics();
//                    int width = m.stringWidth(statement);
//                    int height = m.getAscent() -m.getDescent();
//
//
//
//                    g.setColor(Color.black);
//                    g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });
        strokeButtons.add(stroke3);
        Button stroke4 = new ToggleButtons(160,90,"9",30,30, button_dep.getImage(), button_pre.getImage(),"Size: 9");
        stroke4.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                panel.strokeWidth=(15);
                System.out.println("Size 9 clicked");
                rel_allStrokes(stroke4);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,70,30);
                String statement = "stroke size 9";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });
        strokeButtons.add(stroke4);
        Button beizer = new ToggleButtons(200,90,"Beizer",50,50,button_dep.getImage(), button_pre.getImage(),"Beizer Curve");
        beizer.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Beizer is Clicked");
                panel.keyPressed=11;
                rel_allToggles(beizer);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
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
        buttons.add(beizer);

        Button pen = new ToggleButtons(10,90,"",50,50,pendepressed.getImage(),penPressed.getImage(),"Select pen");
        pen.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("PEn is Clicked");
                panel.keyPressed=7;
                rel_allToggles(pen);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);

            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,70,30);
                String statement = "Start Drawing";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });


        Button b4 = new ToggleButtons(180,0,"",50,40,shapes[2].getImage(),shapes[8].getImage(),"Equilateral T");

        b4.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                rel_allToggles(b4);
                System.out.println("Drawing Equilateral Triangle");
                panel.keyPressed=5;

                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {



            }

            @Override
            public void hover(int x, int y, Graphics g) {
                if (b4.isHovering() == true) {

                    g.drawRect(x + 10, y + 10, 70, 30);
                    String statement = "Equilateral";

                    Font f = new Font("Ariel", 1, 10);
                    g.setFont(f);
                    FontMetrics m = g.getFontMetrics();
                    int width = m.stringWidth(statement);
                    int height = m.getAscent() - m.getDescent();


                    g.setColor(Color.black);
                    g.drawString(statement, (x + 10) + 70 / 2 - width / 2, (y + 10) + 30 / 2 + height / 2);
                }
            }
        });
        Button b5 = new ToggleButtons(230,0,"",50,40,shapes[3].getImage(),shapes[9].getImage(),"Hexagon");
        b5.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                rel_allToggles(b5);
                panel.keyPressed=4;

              //  toolBar.setDropDown(false);
             //   toolBar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
                System.out.println("Drawing hexagon");

            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {
            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,70,30);
                String statement = "Hexagon";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });
        Button b6 = new ToggleButtons(130,41,"",50,40,shapes[4].getImage(), shapes[10].getImage(),"Rectangle" );
        b6.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                rel_allToggles(b6);

                System.out.println("Drawing Rect");
                panel.keyPressed=2;

               // toolBar.setDropDown(false);
               // toolBar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,70,30);
                String statement = "Rectangle";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });
        Button b7 = new ToggleButtons(180,41,"",50,40,shapes[5].getImage(), shapes[11].getImage(),"Right Triangle");
        b7.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                rel_allToggles(b7);
                System.out.println("Drawing Right Triangle");
                panel.keyPressed=3;

               // toolBar.setDropDown(false);
              //  toolBar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);

            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {


            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,70,30);
                String statement = "Right Triangle";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });
        Button b8 = new ToggleButtons(230,41,"",50,40,shapes[6].getImage(), shapes[12].getImage(),"Pentagram");
        b8.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                rel_allToggles(b8);
                panel.keyPressed=6;
                System.out.println("Drawing pentagram");
              //  toolBar.setDropDown(false);
              //  toolBar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,70,30);
                String statement = "Pentagram";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,(x+10)+ 70/2-width/2,(y+10)+ 30/2+height/2);
            }
        });




        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(pen);
        Button b3 = new ToggleButtons(130,0,"",50,40,shapes[1].getImage(),shapes[7].getImage(),"Circle");
        b3.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                rel_allToggles(b3);
                System.out.println("Circle can be drawn");
                panel.setKeyPressed(1);

              //  toolBar.setDropDown(false);
             //   toolBar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
            }

            @Override
            public void pressed(int x, int y) {

            }

            @Override
            public void released(int x, int y) {
            }

            @Override
            public void hover(int x, int y, Graphics g) {
                b3.setHovering(true);

            }
        });
        buttons.add(b3);





    }


    public void loadImages(){

        for (int i = 1; i <= 6; i++) {
            shapes[i] = new ImageIcon("Images/"+i + ".png");
            int x = i+6;
            shapes[x] = new ImageIcon("Images/"+i+""+i+".png");
        }
    }

    public void Paint(Graphics g, ImageObserver observer) {

        for (Button b : buttons) {
            b.paint(g, observer);
        }
        for (Button b:strokeButtons) {
            b.paint(g,observer);

        }
    }

    @Override
    public void clicked(int x, int y) {
        for (Button b : buttons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().click(x, y);
            }

        }
        for (Button b : strokeButtons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().click(x, y);
            }

        }







    }

    @Override
    public void pressed(int x, int y) {
        for (Button b : buttons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().pressed(x, y);
            }

        }
        for (Button b : strokeButtons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().pressed(x, y);
            }

        }


    }

    @Override
    public void released(int x, int y) {
        for (Button b : buttons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().released(x, y);
            }

        }
        for (Button b : strokeButtons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().released(x, y);
            }

        }


    }

    @Override
    public void hover(int x, int y, Graphics g) {
        for (Button b : buttons) {

           b.ISinside(x,y);
           if(b.isHovering()){
               b.getReactor().hover(x,y,g);
           }
        }
        for (Button b : strokeButtons) {
            b.ISinside(x,y);
            if(b.isHovering()){
                b.getReactor().hover(x,y,g);
            }

        }

    }


    public void mouseEntered(int x, int y,Graphics g) {
        for (Button b : buttons) {

            if (b.ISinside(x, y)) {
                b.setHovering(true);
                b.getReactor().hover(x,y,g);
            }
        }
        for (Button b : strokeButtons) {
            if (b.ISinside(x, y)) {
                b.setHovering(true);
                b.getReactor().hover(x,y,g);
            }

        }
    }


    public void mouseExited(int x, int y) {
        for (Button b : buttons) {
            if (b.ISinside(x, y)) {
                b.setHovering(false);
            }
        }
        for (Button b : strokeButtons) {
            if (b.ISinside(x, y)) {
                b.setHovering(false);
            }

        }

    }
}
