import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ToolBar extends newRect implements Toolbarlistner {
    public ArrayList<Button> buttonArrayList = new ArrayList<>();
    private boolean entered=false;


    private Layers l;
    private DrawingPanel drawingPanel = new DrawingPanel();

    private Filetoolbar filetoolbar;
    private ShapesToolbar shapesToolbar= new ShapesToolbar(10,10,400,500,true,this,filetoolbar,drawingPanel); ;
    private ColorBar colorBar = new ColorBar(400,10,100,100,drawingPanel,this,filetoolbar);
    ColorGradient colorGradient = ColorGradient.getInstance(this);



    private boolean showColors=false;
    private int gridSize=10;
    private GridButton gridButton= GridButton.getInstance(5);

     ColorButton c1= new ColorButton(610,35,29,48,Color.black);
     ColorButton c2 = new ColorButton(660,35,29,48,Color.black);

    ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");
    ImageIcon colorpre = new ImageIcon("Color1.png");
    ImageIcon colordep = new ImageIcon("Color2.png");

    boolean fillColorselected=false;

    public int getGridSize() {
        return gridSize;
    }

    public void setC1color(ColorButton Button){
        Color c = Button.getC();
        this.c1.setnewColor(c);
    }
    public void setC2color(ColorButton Button){
        Color c = Button.getC();
        this.c2.setnewColor(c);
    }

//    public void setColor1(boolean color1) {
//        this.color1 = color1;
//    }

//    public void setColor2(boolean color2) {
//        this.color2 = color2;
//    }

    public Color getC1color(){
        if(c1==null){
            return Color.orange;
        }
        return this.c1.getC();
    }
    public Color getC2color(){
        if(c2==null){
            return Color.magenta;
        }
        return this.c2.getC();
    }
    public void colorUpdating(ColorButton b){
        if(fillColorselected==true) {
            c1.setnewColor(b.getC());
            drawingPanel.setColor(this.getC1color());
            System.out.println("Colorupdated");
        }else {
            c2.setnewColor(b.getC());
            drawingPanel.setStrokeColor(this.getC2color());
        }
        }




    public ToolBar(int x,int y,int height,int width,boolean check,DrawingPanel dp){
        super(x, y, width, height);
        this.drawingPanel=dp;
        filetoolbar= new Filetoolbar(0,0,200,200,this,drawingPanel);

        shapesToolbar= new ShapesToolbar(10,10,400,500,true,this,filetoolbar,drawingPanel);
        l = new Layers(600,0,500,600,drawingPanel);
        colorBar = new ColorBar(400,10,100,100,drawingPanel,this,filetoolbar);

        Button b1 = new ToggleButtons(300,0,"Color",100,40,button_dep.getImage(), button_pre.getImage(),"New Color");
        colorGradient.setShow(false);
        gridSize=gridButton.getGridSize();

        b1.setReactor(new Reactor() {

            @Override
            public void click(int x, int y) {
                shapesToolbar.rel_allToggles(null);
                filetoolbar.setEditDropdown(false);
                filetoolbar.setDropdown(false);
                System.out.println("The Toolbar is pressed");

                colorGradient.setShow(true);
                showColors=true;

//                    if(showColors==false){
//                        gradient=null;
//                    }

                    b1.ToggleRelease();
                }




            @Override
            public void pressed(int x, int y) {
                b1.changeIcon();

            }

            @Override
            public void released(int x, int y) {
                b1.setImage(b1.getImage_depressed());

            }

            @Override
            public void hover(int x, int y,Graphics g){

                b1.setHovering(true);
            }

        });



        Button Color1 = new ToggleButtons(600, 30, "", 50, 70, colordep.getImage(), colorpre.getImage(),"R:"+getC1color().getRed()+"G:"+getC1color().getGreen()+"B"+getC1color().getBlue());
        Button Color2 = new ToggleButtons(650, 30, "", 50, 70, colordep.getImage(), colorpre.getImage(),"R:"+getC2color().getRed()+"G:"+getC2color().getGreen()+"B"+getC2color().getBlue());
        Color2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                filetoolbar.setEditDropdown(false);


                fillColorselected=true;
                c1.ToggleRelease();
                Color1.ToggleRelease();

                System.out.println("Color 2 selected");
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
        buttonArrayList.add(Color2);
        c1 =new ColorButton(610,35,29,48,Color.black);
        c2=new ColorButton(660,35,29,48,Color.black);
        //c1.setC(colorUpdate.getRed(),colorUpdate.getGreen(),colorUpdate.getBlue());
        c2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("ssssss");
                fillColorselected=false;
                drawingPanel.setStrokeColor(c2.getC());
                c1.ToggleRelease();
                Color1.ToggleRelease();
                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);




                System.out.println("The stroke Color is selected");

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

        c1.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {

                filetoolbar.setDropdown(false);
                filetoolbar.setEditDropdown(false);
                drawingPanel.setColor(c1.getC());
                c2.ToggleRelease();
                Color2.ToggleRelease();


                System.out.println("The fill Color is selected");

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
                Font f = new Font("Fill Color",2,10);
                g.setFont(f);
                g.setColor(Color.black);
                g.drawString("Fill Color",x+10,y+10);

            }
        });

        Color1.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {

                filetoolbar.setEditDropdown(false);
                Color2.ToggleRelease();



                fillColorselected=true;
                c2.ToggleRelease();

                System.out.println("Color 1 hello selected");

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

        buttonArrayList.add(Color1);
        buttonArrayList.add(c1);
        buttonArrayList.add(c2);
        buttonArrayList.add(b1);




    }





    public void Paint(Graphics g, ImageObserver observer) {
        for (int i = 0; i < 1000; i=i+gridButton.getGridSize()) {
            for (int j = 0; j < 1000; j=j+gridButton.getGridSize()) {
                g.setColor(Color.darkGray);
                g.drawRect(i, j, gridButton.getGridSize(), gridButton.getGridSize());
            }
        }



        g.setColor(new Color(210, 20, 87));
        g.fillRect(0,0,600,160);

        g.setColor(new Color(90, 100, 100));
         g.fillRect(5,5,590,145);
        g.setColor(new Color(231, 216, 226));
        g.fillRect(430,0,170,180);





        g.setColor(Color.black);
        g.drawRect(550,110,30,30);
        g.drawRect(450,110,30,30);
        g.drawRect(500,110,30,30);
        g.setColor(new Color(225, 176, 176));
        Font f = new Font("Stroke Width",2,15);
        g.setFont(f);
        g.drawString("Stroke Width",77,140);
        g.setColor(Color.gray);
        l.Paint(g,observer);
        shapesToolbar.Paint(g,observer);
        filetoolbar.Paint(g,observer);
        colorBar.Paint(g,observer);








        for (Button b : buttonArrayList) {
            b.paint(g, observer);
        }



        if(showColors){
            g.setColor(Color.gray);
            colorGradient.Paint(g,observer);
        }
        gridButton.paint(g,observer);
        c1.paint(g,observer);
        c2.paint(g,observer);





    }


    @Override
    public void clicked(int x, int y) {

        l.clicked(x,y);
        l.pressed(x,y);
        l.released(x,y);
        shapesToolbar.clicked(x,y);
        shapesToolbar.pressed(x,y);
        shapesToolbar.released(x,y);


        filetoolbar.clicked(x,y);
        gridButton.click(x,y);
        colorBar.clicked(x,y);



        for (Button b : buttonArrayList) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().click(x, y);
            }

        }


        if(showColors==true){
            colorGradient.clicked(x,y);
            colorGradient.pressed(x,y);
            colorGradient.released(x,y);

        }




    }
    public void pressed(int x,int y) {
        for (Button b : buttonArrayList) {
            b.IsClicked(x, y);
            if(b.IsPressed()) {
                b.getReactor().pressed(x, y);

            }
        }

    }

    @Override
    public void released(int x, int y) {
        for (Button b : buttonArrayList) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().released(x, y);
            }


        }
        }

    @Override
    public void hover(int x, int y, Graphics g) {

        for (Button b : buttonArrayList) {
            b.ISinside(x,y);
            if (b.isHovering()) {
                b.getReactor().hover(x,y,g);
            }


        }
        shapesToolbar.hover(x, y, g);
        filetoolbar.hover(x, y, g);
        l.hover(x,y,g);
    }


    @Override
    public void mouseEntered(int x, int y,Graphics g) {
        shapesToolbar.mouseEntered(x, y,g);
        for (Button b : buttonArrayList) {
            if(b.ISinside(x,y)){
                System.out.println("inside");
                b.setHovering(true);
                b.getReactor().hover(x, y, g);

            }
            else{
                b.setHovering(false);
            }

        }


    }



public boolean getEntered(){
        return entered;
}
    @Override
    public void mouseExited(int x, int y) {
        shapesToolbar.mouseExited(x, y);
        for (Button b : buttonArrayList) {
            b.ISinside(x,y);
            if(b.isHovering())
                b.setHovering(false);

            }
        }

    }

