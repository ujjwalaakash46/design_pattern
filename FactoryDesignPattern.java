public class FactoryDesignPattern {

    /**
     *
     * 	1.	Encapsulation of Creation Logic: The Factory Pattern centralizes the creation logic, allowing easy changes
     * 	in how objects are instantiated without modifying the client code.
     * <p>
     * 	2.	Decoupling Client Code: By using getShape, the client doesn’t need to know about specific subclasses (e.g.,
     * 	Circle, Square), reducing dependencies and improving flexibility.
     * <p>
     * 	3.	Easier Maintenance and Scalability: Adding new shapes only requires changes in the factory, not in multiple
     * 	parts of your code.
     * <p>
     * 	4.	Enables Polymorphism: The factory can return different subclasses based on input, letting you change the
     * 	object returned without altering the client code.
     */


    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get an object of Square and call its draw method
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        // Get an object of Rectangle and call its draw method
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();

    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class ShapeFactory {
    // Use a method to get the object based on the type
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}