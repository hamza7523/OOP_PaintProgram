import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ColorBar extends newRect implements popUpwindListener{
    ToolBar toolBar;
    private Filetoolbar filetoolbar;
    private DrawingPanel drawingPanel;
    public ArrayList<Button> buttonArrayList = new ArrayList<>();

//    public void colorUpdating(ColorButton b){
//        if(fillColorselected==true) {
//            toolBar.c1.setnewColor(b.getC());
//            drawingPanel.setColor(toolBar.getC1color());
//            System.out.println("Colorupdated");
//        }else {
//            toolBar.c2.setnewColor(b.getC());
//            drawingPanel.setStrokeColor(toolBar.getC2color());
//        }
//    }
    public ColorBar(int x, int y, int width, int height,DrawingPanel panel,ToolBar toolBar,Filetoolbar filetoolbar) {
        super(x, y, width, height);
        this.drawingPanel =panel;
        this.toolBar=toolBar;
        this.filetoolbar =filetoolbar;

        ColorButton b2 = new ColorButton(450,0,30,30,Color.red);
        ColorButton b3 = new ColorButton(500,0,30,30,Color.black);
        ColorButton b4 = new ColorButton(550,0,30,30,Color.blue);
        b4.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);


                if(toolBar.fillColorselected==true) {
                    toolBar.c1.setnewColor(b4.getC());
                    System.out.println("C1 pressed");

                }else{
                    toolBar.c2.setnewColor(b4.getC());
                    System.out.println("C2 pressed");

                }


                b4.ToggleRelease();
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
        buttonArrayList.add(b4);


        ColorButton b5= new ColorButton(450,50,30,30,Color.orange);
        b5.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                System.out.println("orange is pressed");


                if(toolBar.fillColorselected==true) {
                    toolBar.c1.setnewColor(b5.getC());
                    System.out.println("C1 pressed");

                }else{
                    toolBar.c2.setnewColor(b5.getC());
                    System.out.println("C2 pressed");

                }

                b5.ToggleRelease();
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
        buttonArrayList.add(b5);
        ColorButton b6= new ColorButton(500,50,30,30,Color.yellow);
        b6.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                if(toolBar.fillColorselected==true) {

                    toolBar.c1.setnewColor(b6.getC());
                    System.out.println("C1 pressed");

                }else{
                    toolBar.c2.setnewColor(b6.getC());
                    System.out.println("C2 pressed");

                }



                b6.ToggleRelease();
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
        buttonArrayList.add(b6);

        ColorButton b7= new ColorButton(550,50,30,30,Color.DARK_GRAY);
        b7.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                if(toolBar.fillColorselected==true) {
                    System.out.println(toolBar.fillColorselected);
                    toolBar.c1.setnewColor(b7.getC());
                    System.out.println("C1 pressed");

                }else{
                    toolBar.c2.setnewColor(b7.getC());
                    System.out.println("C2 pressed");

                }

                b7.ToggleRelease();
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
        buttonArrayList.add(b7);
        b2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                System.out.println("Red is pressed");


                if(toolBar.fillColorselected==true) {
                    toolBar.c1.setnewColor(b2.getC());
                    System.out.println("C1 pressed");

                }else{
                    toolBar.c2.setnewColor(b2.getC());
                    System.out.println("C2 pressed");

                }




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

            }
        });
        b3.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                System.out.println("The Color Black is selected here");


                if(toolBar.fillColorselected==true) {
                    toolBar.c1.setnewColor(b3.getC());
                    System.out.println("C1 pressed");

                }else{
                    toolBar.c2.setnewColor(b3.getC());
                    System.out.println("C2 pressed");

                }


                b3.ToggleRelease();
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
      buttonArrayList.add(b2);
      buttonArrayList.add(b3);



    }
    public void Paint(Graphics g, ImageObserver observer){
        for (Button b : buttonArrayList) {
            b.paint(g, observer);
        }
        toolBar.c1.paint(g,observer);
        toolBar.c2.paint(g,observer);

    }

    @Override
    public void clicked(int x, int y) {
        for (Button b : buttonArrayList) {
            if (b.IsClicked(x, y)) {
                b.getReactor().click(x, y);
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

    }

}
