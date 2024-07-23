import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

    public class Board extends JPanel
            implements ActionListener , MouseInputListener,Serializable {

        private final int B_WIDTH = 900;
        private final int B_HEIGHT = 900;
        private final int DELAY = 25;
        Graphics g;
        double filecount = 0;
        boolean entered = false;
        ArrayList<LayerSaver> finalStack;
        ArrayList<LayerSaver> deserializedStack;


        private Timer timer;

        private Window w;
        private ArrayList<Button> buttons = new ArrayList<Button>();
        private Button button;
        private DrawingPanel drawingPanel;

        private int key = 0;
        private boolean showGradient = false;
        private boolean keyPressed = false;
        private boolean mousePressed = false;

        private boolean start_drawing = false;

        private int x_init;
        private int y_init;
        private int x_final;
        private int y_final;


        public DrawingPanel getDrawingPanel() {
            return drawingPanel;
        }


        private class TAdapter extends KeyAdapter {

            @Override
            public void keyReleased(KeyEvent e) {
                drawingPanel.keyReleased(e);

                int key = e.getKeyCode();
                keyPressed = false;

                if (key == KeyEvent.VK_SPACE) {

                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                drawingPanel.keyPressed(e);

                keyPressed = true;
                key = e.getKeyCode();

                if (key == KeyEvent.VK_SPACE) {
                    save();
                }
                if (key == KeyEvent.VK_B) {
                    System.out.println("B pressed");
                    try {
                        write("hamza.src");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            }
        }

        public Board() {


            initBoard();
            this.g = getGraphics();
            finalStack = drawingPanel.getLayers();
        }

        private void InitializeAssets() {


        }

        private void initBoard() {

            addMouseListener(this);
            addMouseMotionListener(this);
            addKeyListener(new TAdapter());
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
            setFocusable(true);

            InitializeAssets();

            drawingPanel = new DrawingPanel();
            w = Window.getInstance(this.drawingPanel);


            timer = new Timer(DELAY, this);
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // toolBar.Paint(g,this);
            // toolbar2.Paint(g,this);


            drawingPanel.setG(g);
            drawingPanel.paintComponent(g);

//            button.paint(g,this);

            w.Paint(g, this);


        }

        private void drawNotification(String text, Graphics g) {
            g.setColor(Color.RED);
            g.drawString(text + key + " pressed", 2, 2);
        }

        private void drawButton(Graphics g) {
            ImageObserver observer;
            g.drawImage(button.GetImage(), button.x, button.y, this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {


            Toolkit.getDefaultToolkit().sync();
            repaint();
        }

        public void IsClicked(int x, int y) {
            button.IsClicked(x, y);
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
//            button.getReactor().function(e.getX(),e.getY());
            w.toolBars.get(0).clicked(e.getX(), e.getY());
            //  w.toolBars.get(1).clicked(e.getX(),e.getY());
            //  w.toolBars.get(1).clicked(e.getX(),e.getY());
            drawingPanel.mouseClicked(e);

        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
            // TODO Auto-generated method stub

            x_init = e.getX();
            y_init = e.getY();
            start_drawing = true;

            w.toolBars.get(0).pressed(e.getX(), e.getY());
            //   w.toolBars.get(1).pressed(e.getX(), e.getY());
            drawingPanel.mousePressed(e);


        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

            mousePressed = false;
            start_drawing = false;
//            button.SetPressed(false);
            w.toolBars.get(0).released(e.getX(), e.getY());
            //  w.toolBars.get(1).released(e.getX(),e.getY());
            drawingPanel.mouseReleased(e);

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

            w.toolBars.get(0).mouseEntered(e.getX(), e.getY(), getGraphics());

            // w.toolBars.get(1).mouseEntered(e.getX(),e.getY(),getGraphics());

            drawingPanel.mouseEntered(e);


        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            w.toolBars.get(0).mouseExited(e.getX(), e.getY());
            // w.toolBars.get(1).mouseExited(e.getX(),e.getY());
            drawingPanel.mouseExited(e);


        }

        @Override
        public void mouseDragged(MouseEvent e) {
            drawingPanel.mouseDragged(e);

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            x_final = e.getX() - x_init;
            y_final = e.getY() - y_init;

            w.toolBars.get(0).hover(e.getX(), e.getY(), getGraphics());
            drawingPanel.mouseMoved(e);


        }

        public void save() {

            filecount = Math.random();

            try {
                FileOutputStream fos = new FileOutputStream("C:/Users/Admin/IdeaProjects/finalProject/src/fileLoader/fileNumber3.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(finalStack.get(0).stack);
                oos.close();
                fos.close();
                System.out.println("FinalStack serialized to finalstack.ser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void write(String fileName) throws IOException, ClassNotFoundException {

            //  FileInputStream fis = new FileInputStream("finalstack.ser");
            FileInputStream fos = new FileInputStream("C:/Users/Admin/IdeaProjects/finalProject/src/fileLoader/fileNumber3.ser");

            ObjectInputStream ois = new ObjectInputStream(fos);
            deserializedStack = (ArrayList<LayerSaver>) ois.readObject();
            ois.close();
            fos.close();

            System.out.println("Deserialized FinalStack:");
        //    drawingPanel.setCurrentlayer(deserializedStack.get(0));


        }
        //This code creates a FinalStack object, pushes five integers onto it, and then serializes it to a file named finalstack.ser. It then reads the serialized FinalStack object from the file, deserializes it, and prints the values popped off the stack.
        }










