import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Layers extends newRect implements popUpwindListener, Serializable {
   private ArrayList<Button> buttons = new ArrayList<>();
   private ArrayList<Button> layerButtons = new ArrayList<>();
    private DrawingPanel panel;




    private ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    private ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");

    public Layers(int x, int y, int width, int height,DrawingPanel panel) {
        super(x, y, width, height);
        this.panel = panel;

        Button button = new ToggleButtons(700, 30, "Move up", 100, 50, button_dep.getImage(), button_pre.getImage(),"Move up");
        button.setReactor(new Reactor() {
            @Override
             public void click(int x, int y) {
             System.out.println("Move up clicked Closed");
             Button toggle = getToggle();
             for (int i = 0; i < layerButtons.size(); i++) {
                 if (layerButtons.get(i) == toggle && i>=1) {

                     Button temp = layerButtons.get(i);
                     Button temp2 = layerButtons.get(i - 1);
                     layerButtons.set(i-1,temp);
                     layerButtons.set(i,temp2);

                     int y1 = temp.y;
                     temp.y = temp2.y;
                     temp2.y = y1;
                     break;
                 }

             }

             toggle.setPressed(true);
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


        Button delete = new ToggleButtons(800, 30, "Delete", 100, 50, button_dep.getImage(), button_pre.getImage(),"Delete layer");
        delete.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Delete");

                Button toggle = getToggle();
                System.out.println(toggle.getText());
                  for (int i = 0; i < layerButtons.size(); i++) {
                     if(layerButtons.get(i).equals(toggle)&&layerButtons.size()>0) {
                         if (layerButtons.get(i).equals(layerButtons.get(layerButtons.size()-2)) ||layerButtons.get(i).equals(layerButtons.get(layerButtons.size()-1))){
                             System.out.println(toggle.getText() + " deleted");
                             int tempy = layerButtons.get(layerButtons.size()-2).y;
                             if(toggle.getText().contains("Layer1")){
                                 panel.layer1Stack.clear();
                             }
                              if(toggle.getText().contains("Layer2")){
                                 panel.layer2Stack.clear();
                             }
                              if(toggle.getText().contains("Layer3")){
                                 panel.layer3Stack.clear();
                             }

                             layerButtons.get(i).ToggleRelease();
                              layerButtons.get(i).getImage_depressed();
                             layerButtons.remove(i);

                             layerButtons.get(layerButtons.size()-1).y = tempy;

                         } else {

                             System.out.println(toggle.getText() + "deleted");
                             layerButtons.get(i).ToggleRelease();
                             layerButtons.get(i).getImage_depressed();
                             layerButtons.remove(i);
                             System.out.println(layerButtons.size());
                             for (Button b : layerButtons) {
                                 System.out.println(b.getText());

                             }

                         }
                     }

                    }




                delete.ToggleRelease();
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
        buttons.add(delete);

        Button b3 = new ToggleButtons(800, 80, "MoveDown", 100, 50, button_dep.getImage(), button_pre.getImage(),"move it down");
        b3.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Moved Down");

                try{
                    Button toggle = getToggle();
                    System.out.println(toggle.getText()+"kkkkkkkk");

                    for (int i = 0; i < layerButtons.size() - 1; i++) {
                        if (layerButtons.get(i) == toggle) {
                            Button temp = layerButtons.get(i);
                            Button temp2 = layerButtons.get(i + 1);
                            layerButtons.set(i, temp2);
                            layerButtons.set(i + 1, temp);

                            int y1 = temp.y;
                            temp.y = temp2.y;
                            temp2.y = y1;
                            break; // Exit the loop after swapping the buttons
                        }
                    }
                    toggle.setPressed(true);
                }catch (Exception e){
                    System.out.println("toggle not selected");
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
        buttons.add(b3);
        Button b4 = new ToggleButtons(750,200,"Layer1",80,40,button_dep.getImage(),button_pre.getImage(),"Select layer1");
        Button b6 = new ToggleButtons(750,300,"Layer3",80,40,button_dep.getImage(),button_pre.getImage(),"Select layer3");
        Button b5 = new ToggleButtons(750,250,"Layer2",80,40,button_dep.getImage(),button_pre.getImage(),"Select layer2");
        b4.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
              //  b=null;

                System.out.println("Layer1 is Selected");
                b4.setPressed(true);
                b4.setImage(b4.getPressedImage());
                panel.setLayerPressed(1);


                System.out.println(b4.IsPressed());

                b5.setPressed(false);
                b5.setImage(b5.getImage_depressed());
                b6.setPressed(false);
                b6.setImage(b6.getImage_depressed());




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
        add(b4);
        b4.setPressed(true);
        b4.setImage(b4.getPressedImage());
        panel.setLayerPressed(1);

        b5.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {

                System.out.println("Layer2 selected");
                panel.setLayerPressed(2);
                b5.setPressed(true);
                b4.setPressed(false);
                b4.setImage(b4.getImage_depressed());
                b6.setPressed(false);
                b6.setImage(b6.getImage_depressed());


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
        b6.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Layer3 selected");
                panel.setLayerPressed(3);
                b6.setPressed(true);
                b5.setPressed(false);
                b5.setImage(b5.getImage_depressed());
                b4.setPressed(false);
                b4.setImage(b4.getImage_depressed());

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
        Button b2 = new ToggleButtons(700, 80, "Add", 100, 50, button_dep.getImage(), button_pre.getImage(),"Add layers");
        b2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Add Clicked");
                if(!layerButtons.contains(b4)){
                    add(b4);
                }
                else if (!layerButtons.contains(b5)) {
                    if(layerButtons.size()==2){
                        b5.y=300;
                    }
                    add(b5);

                }else if(!layerButtons.contains(b6)){
                    b6.y=300;
                    add(b6);
                }else{
                    System.out.println("Max 3 layers achieved");
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

        buttons.add(b2);






    }

    public boolean IsClicked(int x, int y) {
        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
            return true;
        }

        return false;
    }

    public void add(Button b){
        layerButtons.add(b);
    }
    public Button getToggle() {
        if (layerButtons.size() != 0) {
            for (int i = 0; i < layerButtons.size(); i++) {
                Button b = layerButtons.get(i);
                System.out.println(b.getText());
                if (b.IsPressed() == true) {
                    System.out.println("Found "+b.getText());
                    b.setPressed(false);
                    return b;

                }

            }

        } else {
            System.out.println("Nothing to remove");
        }
        return null;
    }

    public void delete(Button b){
        layerButtons.remove(b);
    }



    public void Paint(Graphics g, ImageObserver observer) {

        g.setColor(Color.darkGray);
        g.fillRect(700, 0, 200, 500);
        g.setColor(new Color(240, 30, 30));
        Font f = new Font("Layering", 2, 19);
        g.setFont(f);
        g.drawString("Layering", 720, 25);


        for (Button b : layerButtons) {
            b.paint(g, observer);
        }

        for (Button b : buttons) {
            b.paint(g, observer);
        }



    }


    @Override
    public void clicked(int x, int y) {
        if (this.IsClicked(x, y) == true) {
            for (Button b : layerButtons) {
                b.IsClicked(x, y);
                if (b.IsPressed()) {
                    b.getReactor().click(x, y);

                }
            }

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
        for (Button b : buttons) {

            b.ISinside(x,y);
            if(b.isHovering()){
                b.getReactor().hover(x,y,g);
            }
        }
        for (Button b : layerButtons) {
            b.ISinside(x,y);
            if(b.isHovering()){
                b.getReactor().hover(x,y,g);
            }

        }

    }

}

