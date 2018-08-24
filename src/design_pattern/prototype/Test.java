package design_pattern.prototype;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape(1);
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShape(2);
        System.out.println("Shape : " + clonedShape2.getType());

    }
}

// 原型模式(Prototype Pattern)是用于创建重复的对象，同时又能保证性能。
// 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
// 这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。
// 当直接创建对象的代价比较大时，则采用这种模式。
// 例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用。

abstract class Shape implements Cloneable {

    private Integer id;
    protected String type;

    abstract void draw();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}

class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class ShapeCache {
    private static HashMap<Integer, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(Integer shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {

        Square square = new Square();
        square.setId(1);
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(2);
        shapeMap.put(rectangle.getId(), rectangle);
    }
}