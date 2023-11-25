public class Rectangle extends GeometricObject {
    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "scale=" + getScale() + ", a=" + a + ", b=" + b + ", area=" + getArea() + '}';
    }

    @Override
    public double getArea() {
        double a = this.a * getScale();
        double b = this.b * getScale();

        return a * b;
    }
}
