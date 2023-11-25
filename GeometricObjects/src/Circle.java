public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "scale=" + getScale() + ", radius=" + radius + ", area=" + getArea() + '}';
    }

    @Override
    public double getArea() {
        double radius = this.radius * getScale();

        return Math.PI * Math.pow(radius, 2.0);
    }
}
