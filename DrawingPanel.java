import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

import javax.swing.*;
import javax.swing.SwingUtilities;

public class  DrawingPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	// PROPERTIES
	final int DEFAULT_WIDTH = 1000;
	private int layerPressed =1;
	public ArrayList<Stack> stacksLayers =new ArrayList<Stack>();
	private ArrayList<Point> beizerArray;
	private Queue<Shape> shapeQueue = new LinkedList<>();
	int count=0;


	public void setLayerPressed(int layerPressed) {
		this.layerPressed = layerPressed;
	}

	public Stack<Shape> layer1Stack = new Stack<>();
	public Stack<Shape> layer2Stack = new Stack<>();
	public Stack<Shape> layer3Stack = new Stack<>();
	LayerSaver currentlayer;
	ArrayList<LayerSaver> layers = new ArrayList<>();



	final int DEFAULT_HEIGHT = 1000;

	private int x1, y1;
	private int counter = 0;
	private int y3;
	private Color fillColor;

	private Point bottom;
	LayerSaver layer1;
	LayerSaver layer2;
	LayerSaver layer3;
	private Point top;
	private Point thirdpoint;
	private int x2;
	private int y2;
	BezierCurve beizerCurve;

	private Graphics g;
	protected int keyPressed;
	protected int strokeWidth;
	private Color strokeColor;
	private Random random = new Random();

	private ArrayList<Shape> pen = new ArrayList<Shape>();

	public void setKeyPressed(int i){
		this.keyPressed=i;
		return;
	}



	public void setG(Graphics g) {
		this.g = g;
	}

	public int getKeyPressed(){
		return keyPressed;
	}
	public void setColor(Color c){
		this.fillColor = c;

	}
	public void setStrokeColor(Color c){
		this.strokeColor=c;
	}


	protected Stack<Shape> shapeStack = new Stack<Shape>();
	//private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	// CONSTRUCTOR


	public DrawingPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		stacksLayers.add(layer1Stack);
		stacksLayers.add(layer2Stack);
		stacksLayers.add(layer3Stack);
		 layer1 = new LayerSaver();
		 layer2 = new LayerSaver();
		 layer3 = new LayerSaver();
		 layers.add(0,layer1);
		 layers.add(1,layer2);
		 layers.add(2,layer3);
		if(layerPressed==1){
			currentlayer =layers.get(0);
		}
		if(layerPressed==2){
			currentlayer = layers.get(1);
		}
		if(layerPressed==3){
			currentlayer=layers.get(2);
		}




		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		setFocusable(true);

	}

	// METHOD
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color a = fillColor;
		Color strokeColor1 = strokeColor;
		setUpDrawingGraphics(false);

		currentlayer.draw(g);


		if(keyPressed==1){
			Shape c = new Circle((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), new Point(x1, y1),a,strokeWidth,strokeColor1);
			c.show(g, false);
		}
		if(keyPressed==3){
			Shape x = new Triangle(((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))),new Point(x1,y1),new Point(x2,y2),a,strokeWidth,strokeColor1);
			x.show(g,false);
		}
		if(keyPressed==2){
			Shape r = new Rectangle(((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))), new Point(x1, y1), new Point(x2, y2), a,strokeWidth,strokeColor1);
			r.show(g, false);
		}
		if(keyPressed==4){
			Shape x = new Hexagon(((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))),new Point(x1,y1),new Point(x2,y2),a,strokeWidth,strokeColor1);
			x.show(g,false);
		}
		if(keyPressed==5){
			Shape x = new Equilateral(((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))),new Point(x1,y1),new Point(x2,y2),a,strokeWidth,strokeColor1);
			x.show(g,false);
		}
		if(keyPressed==6){
			Shape x = new Pentagram(((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))),new Point(x1,y1),new Point(x2,y2),a,strokeWidth,strokeColor1);
			x.show(g,false);
		}







	}

	private void setUpDrawingGraphics(boolean clear) {
		// if(circles!=null)
		//		circle.show(g);
//		for (int i = 0; i < shapeStack.getSize(); i++) {
//			Shape shape =shapeStack.pop();
//			shape.show(g);

		//System.out.println(shapeStack.size());

//		if (clear == true) {
//			g.setColor(Color.white);
//			g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
//		} else {


			for (int i = 0; i < layer1Stack.size(); i++) {
				Shape a = layer1Stack.get(i);
				a.show(g, false);

			}
			for (int i = 0; i < layer2Stack.size(); i++) {
				Shape a = layer2Stack.get(i);
				a.show(g, false);

			}
			for (int i = 0; i < layer3Stack.size(); i++) {
				Shape a = layer3Stack.get(i);
				a.show(g, false);

			}
			for(int i =0;i<pen.size();i++){
				Shape a = pen.get(i);
				a.show(g,false);
			}
			if(keyPressed==20){
				currentlayer.stack.clear();
			}


		}





	@Override
	public void mouseClicked(MouseEvent e) {


		// TODO Auto-generated method stub

		int x = e.getX();
		int y = e.getY();
		top = new Point(x, y);

	}

	public void mousePressed(MouseEvent e) {


		if (SwingUtilities.isLeftMouseButton(e)) {

			x1 = e.getX();
			y1 = e.getY();
			top = new Point(x1, y1);
			if (SwingUtilities.isLeftMouseButton(e) && keyPressed == 11) {

				counter++;
				System.out.println(counter);
				if (counter == 1) {
					beizerArray=new ArrayList<Point>();
					x1 = e.getX();
					y1 = e.getY();
					beizerArray.add(0,new Point(x1,y1));
					beizerCurve = new BezierCurve();




					System.out.println(x1);

				} else if (counter == 2) {
					x2 = e.getX();
					y2 = e.getY();
					beizerArray.add(1,new Point(x2,y2));
					System.out.println(x2);
					g.setColor(Color.black);
					Graphics2D graphics2D = (Graphics2D)g;
					graphics2D.setStroke(new BasicStroke(20.0f));
					beizerCurve.setControlPoints(beizerArray);
					beizerCurve.show(g,false);
					layer1Stack.push(beizerCurve);



				} else if (counter == 3) {
					int x3 = e.getX();
					int y3 = e.getY();
					beizerArray.add(2,new Point(x3,y3));
					System.out.println(x3);
					beizerCurve.setControlPoints(beizerArray);
					beizerCurve.show(g,false);
					layer1Stack.push(beizerCurve);



				} else if (counter==4) {
					int x4 = e.getX();
					int y4 = e.getY();
					beizerArray.add(3,new Point(x4,y4));
					System.out.println(beizerArray.size());
					System.out.println(x4);
					beizerCurve.setControlPoints(beizerArray);
					beizerCurve.setStrokeSize(strokeWidth);
					beizerCurve.setStrokeColor(strokeColor);
					beizerCurve.show(g,false);

						currentlayer.addShape(beizerCurve);

					System.out.println(beizerCurve.toString());


					counter = 0;

				}
				repaint();
				}






		} else if (SwingUtilities.isRightMouseButton(e)) {

			count++;

			System.out.println("Right Clicked");
			Shape topShape = currentlayer.stack.get(0);

					// Remove the top shape from the stack
					currentlayer.undo();

					System.out.println("------------------"+topShape.text + " poped times:"+count);
					currentlayer.addShape(topShape);
					// Remove the top shape from the canvas by painting the canvas with a white background
					setUpDrawingGraphics(false);

					// Re-draw the remaining shapes on the canvas

					System.out.println("Removed " + topShape.getClass().getSimpleName());





				}else if (SwingUtilities.isMiddleMouseButton(e)) {

//				System.out.println("middle pressed");
//				currentlayer.redo();
//
//				setUpDrawingGraphics(false);


			}
		}






	@Override
	public void mouseReleased(MouseEvent e) {

		if (keyPressed == 1) {
			x2 = e.getX();
			y2 = e.getY();
			bottom = new Point(x2, y2);
			Color a = fillColor;

			Shape c = new Circle((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2)), top,a,strokeWidth,strokeColor );
			currentlayer.addShape(c);



			c.text = "Circle";
			shapeDrawn();
			top = null;
        	bottom=null;


		}
		if (keyPressed == 2) {
			x2 = e.getX();
			y2 = e.getY();
			bottom = new Point(x2, y2);
			Shape r = new Rectangle(((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2))), top, bottom, fillColor,strokeWidth,strokeColor);
			currentlayer.addShape(r);
			shapeDrawn();
			r.text = "Rectangle";
			bottom = null;
			top = null;
		}
		if(keyPressed==4){
			x2 = e.getX();
			y2 = e.getY();
			bottom = new Point(x2, y2);
			Shape r = new Hexagon(((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2))), top, bottom, fillColor,strokeWidth,strokeColor);
			currentlayer.addShape(r);
			shapeDrawn();
			r.text = "Hexagon";
			bottom = null;
			top = null;

		}
		if(keyPressed==3){
			x2 = e.getX();
			y2 = e.getY();
			bottom = new Point(x2, y2);
			Shape x = new Triangle(((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2))),top,bottom, fillColor,strokeWidth,strokeColor);
			currentlayer.addShape(x);
			shapeDrawn();
			x.text = "Equilateral";
			bottom = null;
			top = null;
		}
		if(keyPressed==5){
			x2 = e.getX();
			y2 = e.getY();
			bottom = new Point(x2, y2);
			Shape x = new Equilateral(((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2))),top,bottom, fillColor,strokeWidth,strokeColor);
			currentlayer.addShape(x);
			shapeDrawn();
			x.text = "Equilateral";
			bottom = null;
			top = null;

		}


		if(keyPressed==6){
			x2 = e.getX();
			y2 = e.getY();
			bottom = new Point(x2, y2);
			Shape x = new Pentagram(((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2))),top,bottom, fillColor,strokeWidth,strokeColor);
			currentlayer.addShape(x);
			shapeDrawn();
			x.text = "Pentagram";
			bottom = null;
			top = null;

		}
		System.out.println();
		repaint();


	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}


	@Override
	public void mouseExited(MouseEvent e) {
	}


	@Override
	public void mouseDragged(MouseEvent e) {

			x2 = e.getX();
			y2 = e.getY();


		if(SwingUtilities.isLeftMouseButton(e)&&keyPressed==7){
			Shape circle = new Circle(6,new Point(e.getX(),e.getY()), fillColor,strokeWidth,true,strokeColor);
			pen.add(circle);

		}
		repaint();




		}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		setUpDrawingGraphics(false);
		if(layerPressed==1){
			currentlayer =layers.get(0);
		}
		if(layerPressed==2){
			currentlayer = layers.get(1);
		}
		if(layerPressed==3){
			currentlayer=layers.get(2);
		}

		}








	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public ArrayList<LayerSaver> getLayers() {
		return layers;
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("key pressed");
//		if (e.getKeyChar() == '1') {
//
//			keyPressed = 1;
//
//
//		}
//		if (e.getKeyChar() == '2') {
//			keyPressed = 2;
//		}
//		if (e.getKeyChar() == '3') {
//			keyPressed = 3;
//		}
//		shapeDrawn();
		if(e.getKeyChar()=='r'){
			currentlayer.redo();
		}


		if (e.getKeyChar() == 'z') {
			if (currentlayer.stack.size()!=0) {
				count++;

				System.out.println("Z is pressed");
				Shape topShape = currentlayer.stack.get(0);

				// Remove the top shape from the stack
				currentlayer.undo();

				System.out.println("------------------"+topShape.text + " poped times:"+count);
				//currentlayer.addShape(topShape);
				// Remove the top shape from the canvas by painting the canvas with a white background
				setUpDrawingGraphics(false);

				// Re-draw the remaining shapes on the canvas

				System.out.println("Removed " + topShape.getClass().getSimpleName());
			} else {
				System.out.println("Empty Stack now");
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void shapeDrawn() {
		g.setColor(Color.black);
		Font f = new Font("Aries",2,50);
		g.setFont(f);
		if (keyPressed == 1) {
			g.drawString("Circle", 50, 500);
		}
		if (keyPressed == 2) {
			g.drawString("Rectangle", 5, DEFAULT_HEIGHT - 150);
		}
		if(keyPressed==3){
			g.drawString("Triangle",5,DEFAULT_HEIGHT-150);
		}
	}
}


