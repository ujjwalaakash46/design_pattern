package AbstractFactory;

public class AbstractFactoryPattern {

    /**
     * 1.	Regular Factory Pattern: Creates individual objects based on input (like shapes or colors).
     * 	2.	Abstract Factory Pattern: Creates factories that produce families of related objects. So, instead of
     * 	directly creating an object (e.g., a Circle or Red color), it creates a ShapeFactory or a ColorFactory that can
     * 	produce specific objects within their respective categories.
     */

    public static void main(String[] args) {
        // Get AbstractFactory.Shape Factory
        AbstractFactory<Shape> shapeFactory = (AbstractFactory<Shape>) FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.create("CIRCLE");
        shape1.draw();

        // Get AbstractFactory.Color Factory
        AbstractFactory<Color> colorFactory = (AbstractFactory<Color>) FactoryProducer.getFactory("COLOR");
        Color color1 = colorFactory.create("RED");
        color1.fill();
    }
}

class FactoryProducer {
    public static AbstractFactory<?> getFactory(String choice) {
        if ("SHAPE".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else if ("COLOR".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}

class ShapeFactory implements AbstractFactory<Shape> {
    public Shape create(String shapeType) {
        if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }
}

class ColorFactory implements AbstractFactory<Color> {
    public Color create(String colorType) {
        if ("RED".equalsIgnoreCase(colorType)) {
            return new Red();
        } else if ("BLUE".equalsIgnoreCase(colorType)) {
            return new Blue();
        }
        return null;
    }
}

interface AbstractFactory<T> {
    T create(String type);
}

// AbstractFactory.Shape Implementations
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a AbstractFactory.Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a AbstractFactory.Square");
    }
}

// AbstractFactory.Color Implementations
class Red implements Color {
    public void fill() {
        System.out.println("Filling with AbstractFactory.Red");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Filling with AbstractFactory.Blue");
    }
}

interface Shape {
    void draw();
}

interface Color {
    void fill();
}