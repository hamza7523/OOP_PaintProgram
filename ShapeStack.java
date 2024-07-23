import java.util.ArrayList;

public class ShapeStack {
    Shape shape;
    int size;
    ArrayList<Shape> shapeStack = new ArrayList<>();


    public void push(Shape element) {
        shapeStack.add(element);
        size++;
    }

    public Shape pop() {
        if (shapeStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        size--;
        return shapeStack.remove(shapeStack.size()-1);
    }

    public Shape peek() {
        if (shapeStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return shapeStack.get(shapeStack.size() - 1);
    }

    public boolean isEmpty() {
        return shapeStack.isEmpty();
    }

    public int size() {
        return shapeStack.size();
    }


    public int getSize() {
        return size;
    }
    public Shape getShape(int i){
        return shapeStack.get(i);

        }

}





