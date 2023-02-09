
/* This lab implements the use of interfaces, inheritance as well as OOP to create some attributes for commong
* geometric shapes.
*
* R Stone
*/
package ch03.Lab4;

import java.text.DecimalFormat;
import java.util.ArrayList;

interface Shape {
    public double area();

    public double perimeter();
}

class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle implements Shape {
    double a;
    double b;
    double c;
    double h;

    public Triangle(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public double area() {
        return (0.5 * b) * h;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}

class Rectangle implements Shape {
    double width;
    double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class shapeOfFoo {
    public static void main(String[] args) {
        Shape circle = new Circle(1);
        Shape triangle = new Triangle(1, 3, 2, 4);
        Shape rectangle = new Rectangle(12, 16);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " area: " + df.format(shape.area()));
            System.out.println(shape.getClass().getSimpleName() + " perimeter: " + df.format(shape.perimeter()));
        }
    }
}