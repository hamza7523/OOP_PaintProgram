import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Filetoolbar extends newRect implements popUpwindListener {

    private ArrayList<Button> buttonsDropDown = new ArrayList<>();
    private ArrayList<Button> EditDrop = new ArrayList<>();
    private ArrayList<Button> mainbuttons =new ArrayList<>();
    private boolean showOpen = false;
    private boolean dropdown= false;

    private boolean editDropdown = false;
    ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");

    ToolBar toolBar;
    DrawingPanel panel;
    OpenFile openFile = new OpenFile(140, 190, 430, 300);

    public void setDropdown(boolean dropdown) {
        this.dropdown = dropdown;
    }

    public void setEditDropdown(boolean editDropdown) {
        this.editDropdown = editDropdown;
    }
    public void getreleaseEdit(Button button){
        button.ToggleRelease();
    }

    public Filetoolbar(int x, int y, int width, int height, ToolBar toolBar,DrawingPanel panel) {
        super(x, y, width, height);
        this.toolBar = toolBar;
        this.panel =panel;

        Button b1 = new ToggleButtons(0, 0, "File", 64, 32, button_dep.getImage(), button_pre.getImage(),"Open"+"\n"+"Save"+"\n"+"New");
        b1.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                editDropdown=false;
                if (dropdown == true) {
                    dropdown=false;
                    b1.ToggleRelease();


                } else {
                    dropdown=true;
                    b1.setTextColor(Color.WHITE);
                    b1.setImage(b1.getPressedImage());
                    b1.setImage(b1.getPressedImage());


                }



                Button buttondrop1 = new ToggleButtons(0, 33, "Save", 64, 32, button_dep.getImage(), button_pre.getImage(),"Save");
                buttondrop1.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {
                        System.out.println("Save is Clicked");


                    }

                    @Override
                    public void pressed(int x, int y) {


                    }

                    @Override
                    public void released(int x, int y) {
                        buttondrop1.ToggleRelease();
                        buttondrop1.setImage(buttondrop1.getImage_depressed());

                    }

                    @Override
                    public void hover(int x, int y, Graphics g) {

                    }
                });
                Button buttondrop2 = new ToggleButtons(0, 66, "New", 64, 32, button_dep.getImage(), button_pre.getImage(),"New");
                buttondrop2.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {
                        System.out.println("New is Clicked so the Canvas is Cleared");
                        dropdown=false;
                        showOpen=false;
                        editDropdown=false;
                        panel.setKeyPressed(20);

                        buttondrop2.ToggleRelease();
                    }

                    @Override
                    public void pressed(int x, int y) {
                        buttondrop2.changeIcon();

                    }

                    @Override
                    public void released(int x, int y) {
                        buttondrop2.setImage(button_dep.getImage());

                    }

                    @Override
                    public void hover(int x, int y, Graphics g) {

                    }
                });
                Button buttondrop3 = new ToggleButtons(0, 99, "Open", 64, 32, button_dep.getImage(), button_pre.getImage(),"Open");

                buttonsDropDown.add(buttondrop1);
                buttonsDropDown.add(buttondrop2);
                buttonsDropDown.add(buttondrop3);
                buttondrop3.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {


                        showOpen=openFile.isShowOpen();
                        System.out.println("into open");
                        openFile.loadFile();

                    }

                    @Override
                    public void pressed(int x, int y) {

                    }

                    @Override
                    public void released(int x, int y) {
                        buttondrop3.ToggleRelease();

                    }

                    @Override
                    public void hover(int x, int y, Graphics g) {

                    }
                });
                b1.changeIcon();
            }


            @Override
            public void pressed(int x, int y) {


            }

            @Override
            public void released(int x, int y) {


                b1.setImage(b1.getImage_depressed());


            }

            @Override
            public void hover(int x, int y, Graphics g) {

            }
        });

        Button b2 = new ToggleButtons(65, 0, "Edit", 64, 32, button_dep.getImage(), button_pre.getImage(),"Press Edit");
        b2.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                dropdown=false;
                b1.ToggleRelease();
                System.out.println("Edit is Clicked");
                if (editDropdown == true) {
                    editDropdown=false;
                    b2.ToggleRelease();

                } else {
                    editDropdown=true;
                    b2.changeIcon();
                    b2.setImage(b2.getPressedImage());
                }

                Button buttondrop1 = new ToggleButtons(65, 33, "undo", 64, 32, button_dep.getImage(), button_pre.getImage(),"Press undo");
                buttondrop1.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {
                        System.out.println("The undo is Clicked");
                        buttondrop1.getImage_depressed();
                        buttondrop1.ToggleRelease();
                    }

                    @Override
                    public void pressed(int x, int y) {
                        buttondrop1.changeIcon();
                        buttondrop1.setImage(buttondrop1.getPressedImage());

                    }

                    @Override
                    public void released(int x, int y) {
                        buttondrop1.changeIcon();
                        //buttondrop1.setImage(buttondrop1.getImage_depressed());


                    }

                    @Override
                    public void hover(int x, int y, Graphics g) {
                        g.drawRect(x+10,y+10,10,15);
                        String statement = "Undo";

                        Font f = new Font("Ariel",1,10);
                        g.setFont(f);
                        FontMetrics m = g.getFontMetrics();
                        int width = m.stringWidth(statement);
                        int height = m.getAscent() -m.getDescent();



                        g.setColor(Color.black);
                        g.drawString(statement,30/2-width/2,20/2+height/2);
                    }
                });

                Button buttondrop2 = new ToggleButtons(65, 66, "redo", 64, 32, button_dep.getImage(), button_pre.getImage(),"Press redo");
                buttondrop2.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {
                        System.out.println("Redo is Clicked");
                        buttondrop2.ToggleRelease();
                    }

                    @Override
                    public void pressed(int x, int y) {
                        buttondrop2.changeIcon();

                    }

                    @Override
                    public void released(int x, int y) {
                        buttondrop2.setImage(button_dep.getImage());


                    }

                    @Override
                    public void hover(int x, int y, Graphics g) {
                        g.drawRect(x+10,y+10,10,15);
                        String statement = "Redo";

                        Font f = new Font("Ariel",1,10);
                        g.setFont(f);
                        FontMetrics m = g.getFontMetrics();
                        int width = m.stringWidth(statement);
                        int height = m.getAscent() -m.getDescent();



                        g.setColor(Color.black);
                        g.drawString(statement,30/2-width/2,20/2+height/2);
                    }
                });
                EditDrop.add(buttondrop1);
                EditDrop.add(buttondrop2);


            }

            @Override
            public void pressed(int x, int y) {


            }

            @Override
            public void released(int x, int y) {
                System.out.println("Active button is released");

            }

            @Override
            public void hover(int x, int y, Graphics g) {
                g.drawRect(x+10,y+10,30,20);
                String statement = "Select to Edit";

                Font f = new Font("Ariel",1,10);
                g.setFont(f);
                FontMetrics m = g.getFontMetrics();
                int width = m.stringWidth(statement);
                int height = m.getAscent() -m.getDescent();



                g.setColor(Color.black);
                g.drawString(statement,30/2-width/2,20/2+height/2);

            }
        });
        mainbuttons.add(b1);
        mainbuttons.add(b2);


    }
    public void Paint(Graphics g, ImageObserver observer) {
        for (Button button:mainbuttons) {
            button.paint(g,observer);

        }
        if(showOpen==true && openFile.isShowOpen()) {

            g.setColor(Color.gray);
            openFile.Paint(g, observer);
        }
        if (editDropdown == true) {
            g.setColor(Color.MAGENTA);
            for (Button b : EditDrop) {
                b.paint(g, observer);

            }
        }

        if (dropdown== true) {
            g.setColor(Color.MAGENTA);
            for (Button b : buttonsDropDown) {
                b.paint(g, observer);
            }
        }
    }


    @Override
    public void clicked(int x, int y) {
        for (Button b:mainbuttons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().click(x, y);
            }

        }

            for (Button b : EditDrop) {
                b.IsClicked(x, y);
                if (b.IsPressed()) {
                    b.getReactor().click(x, y);
                }
            }


            for (Button b : buttonsDropDown) {
                b.IsClicked(x, y);
                if (b.IsPressed()) {
                    b.getReactor().click(x, y);
                }
            }
            if(showOpen==true) {


                openFile.clicked(x, y);
            }


    }

    @Override
    public void pressed(int x, int y) {
        for (Button b:mainbuttons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().pressed(x, y);
            }

        }


    }

    @Override
    public void released(int x, int y) {
        for (Button b:mainbuttons) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().released(x, y);
            }

        }

    }

    @Override
    public void hover(int x, int y, Graphics g) {
        for (Button b:mainbuttons) {
            if (b.ISinside(x, y)) {
                b.getReactor().hover(x, y,g);
            }

        }

        for (Button b : EditDrop) {

            if (b.ISinside(x, y)) {
                b.getReactor().hover(x, y,g);
            }
        }


        for (Button b : buttonsDropDown) {

            if (b.ISinside(x, y)) {
                b.getReactor().hover(x, y,g);
            }
        }
        if(showOpen==true) {


            openFile.hover(x,y,g);
        }


    }

}
