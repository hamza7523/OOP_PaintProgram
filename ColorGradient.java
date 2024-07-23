import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ColorGradient extends newRect implements popUpwindListener {
    Color[][] colorGradients = new Color[256][256];
    ToolBar toolBar;
    Color colorupdate = new Color(1, 1, 255);

    private boolean showGradient = false;
    int red = 0;
    int green = 0;
    int blue = 0;
    int okayCount = 0;


    private float lum = 0.75f;
    ArrayList<ColorButton> colorButtons = new ArrayList<>();
    ArrayList<ColorButton> newColorList = new ArrayList<>();
    ArrayList<Button> buttonsGradient = new ArrayList<>();
    private static ColorGradient colorGradient;


    ImageIcon button_dep = new ImageIcon("Images/square_depressed.png");

    ImageIcon button_pre = new ImageIcon("Images/square_pressed.png");

    ColorButton c;
    public static ColorGradient getInstance(ToolBar toolBar){
        if(colorGradient==null){
            colorGradient=new ColorGradient(220,220,400,400,toolBar);
        }
        return colorGradient;
    }


    private ColorGradient(int x, int y, int width, int height,ToolBar toolBar) {
        super(x, y, width, height);
        showGradient = true;
        this.toolBar=toolBar;


        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {

                colorGradients[i][j] = Color.getHSBColor((256 - i) / 256.0f, j / 256.0f, 0.8f);

                ColorButton b = new ColorButton((220 - 0) + i, (220 - 0) + j, 1, 1, colorGradients[i][j]);


                c = new ColorButton(220, 500, 30, 30, colorupdate);
                b.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {
                        System.out.println("Specific Color Clicked");


                        Color color = getColor(b);
                        red = color.getRed();
                        green = color.getGreen();
                        blue = color.getBlue();
                        b.setColors(red, green, blue);
                        System.out.println("Red: " + red + ", Green: " + green + ", Blue: " + blue);


                        colorupdate = new Color(red, green, blue);
                        c.setC(red, green, blue);
                        System.out.println("_____________________________\n");


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
                colorButtons.add(b);
                colorButtons.add(c);
            }
        }

        Button okayButton = new ToggleButtons(520, 500, "Ok", 50, 30, button_dep.getImage(), button_pre.getImage(),"ok press");
        okayButton.setTextColor(Color.BLACK);
        okayButton.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                showGradient = false;
                System.out.println("Okay button pressed");
                okayCount++;
                c.setColors(red, green, blue);
                int x1 = 450;
                if (okayCount == 2) {
                    x1 = x1 + 50;
                } else if (okayCount == 3) {
                    x1 = x1 + 50;
                }
                else if(okayCount==4){
                    x1=x1+50;
                }
                ColorButton newColor = new ColorButton(x1, 110, 30, 30, c.getC());
                newColor.setReactor(new Reactor() {
                    @Override
                    public void click(int x, int y) {
                        System.out.println("The new Color is pressed");
                        toolBar.colorUpdating(newColor);

                        newColor.ToggleRelease();
                        if(toolBar.fillColorselected==true) {

                            toolBar.setC1color(newColor);
                        } else if (toolBar.fillColorselected==true) {
                            toolBar.setC2color(newColor);
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
                });

                newColorList.add(newColor);

            }

            @Override
            public void pressed(int x, int y) {
                okayButton.changeIcon();

            }

            @Override
            public void released(int x, int y) {
                okayButton.ToggleRelease();


            }

            @Override
            public void hover(int x, int y, Graphics g) {

            }
        });


        buttonsGradient.add(okayButton);
        Button button = new ToggleButtons(510, 210, "X", 20, 20,button_dep.getImage(),button_pre.getImage(),"close");
        button.setReactor(new Reactor() {
            @Override
            public void click(int x, int y) {
                System.out.println("Color Gradient Closed");

                showGradient=false;
                okayButton.ToggleRelease();
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

        buttonsGradient.add(button);

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

    public Color getColor(ColorButton b) {
        Color color = b.getC();
        System.out.println(color.getRed());
        System.out.println(color.getBlue());
        System.out.println(color.getGreen());
        return color;
    }




    public void Paint(Graphics g, ImageObserver observer) {
        for (Button b : newColorList) {
            b.paint(g, observer);

        }


        if(showGradient==true) {
            g.setColor(Color.gray);
            g.fillRect(200, 200, 400, 350);
            for (Button b : colorButtons) {
                g.setColor(Color.black);
                Font f = new Font("Red: " + red + ", Green: " + green + ", Blue: " + blue,2,15);
                g.setFont(f);
                g.drawString("Red: " + red + ", Green: " + green + ", Blue: " + blue,300,500);
                g.setColor(Color.gray);
                b.paint(g, observer);

            }
            for (Button b : buttonsGradient) {
                b.paint(g, observer);
            }


            for (Button b : buttonsGradient) {
                b.paint(g, observer);

            }
        }
    }


    @Override
    public void clicked(int x, int y) {
        if(showGradient==true) {

            if (this.IsClicked(x, y) == true) {
                for (Button b : buttonsGradient) {
                    b.IsClicked(x, y);
                    if (b.IsPressed()) {
                        b.getReactor().click(x, y);
                        b.setPressed(false);
                    }
                }

                System.out.println("you have clicked inside the Color Gradient");
//            int newX = x - 40;
//            int newY = y - 40;

                for (ColorButton button : colorButtons) {
                    button.IsClicked(x, y);
                    if (button.getPressed() == true) {
                        button.getReactor().click(x, y);
                        button.setPressed(false);
                    }
                }

            }
        }
        for (ColorButton b : newColorList) {
            b.IsClicked(x, y);
            if (b.IsPressed()) {
                b.getReactor().click(x, y);
                b.setPressed(false);
            }
        }
    }

    @Override
    public void pressed(int x, int y) {
        if(showGradient==true) {
            if (this.IsClicked(x, y) == true) {
                for (Button b : buttonsGradient) {
                    b.IsClicked(x, y);
                    if (b.IsPressed()) {
                        b.getReactor().pressed(x, y);
                        b.setPressed(false);
                    }
                }
                System.out.println("Pressed");

                for (ColorButton button : colorButtons) {
                    button.IsClicked(x, y);
                    if (button.getPressed() == true) {
                        button.getReactor().pressed(x, y);
                        button.setPressed(false);
                    }
                }

            }
        }
    }




    public boolean isShowGradient() {
        return showGradient;
    }

    @Override
        public void released ( int x, int y){
        if(showGradient==true) {
            if (this.IsClicked(x, y) == true) {
                for (Button b : buttonsGradient) {
                    b.IsClicked(x, y);
                    if (b.IsPressed()) {
                        b.getReactor().released(x, y);
                        b.ToggleRelease();
                        b.setPressed(false);
                    }
                }
                System.out.println("Released");

                for (ColorButton button : colorButtons) {
                    button.IsClicked(x, y);
                    if (button.getPressed() == true) {
                        button.getReactor().released(x, y);
                        button.ToggleRelease();
                        button.setPressed(false);
                    }
                }

            }
        }


        }

    @Override
    public void hover(int x, int y, Graphics g) {

    }

    public void setShow(boolean b)
        {
            showGradient=b;
        }
    }
