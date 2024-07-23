import java.awt.*;
import java.io.Serializable;
import java.util.Stack;

public class LayerSaver implements Serializable {
    Stack<Shape> stack = new Stack<>();
    Stack<Shape> undoQueue = new Stack<>();

    public void addShape(Shape shape){
        stack.add(shape);
    }
    public void undo(){
        if(stack.empty()){
            System.out.println("Empty");
            return;
        }
        Shape undoShape = stack.pop();
        if(undoShape !=null){
            undoQueue.push(undoShape);
        }


    }
    public void redo(){
        if(undoQueue.empty()){
            System.out.println("Empty Queue");
            return;
        }
        Shape redoShape = undoQueue.pop();
        if(redoShape!=null){
            stack.push(redoShape);
        }

    }
    public void draw(Graphics g){
        for (Shape shape: stack) {
            shape.show(g,false);

        }
    }

}
