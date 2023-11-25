public class Triangle extends GeometricObject {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" + "scale=" + getScale() + ", a=" + a + ", b=" + b + ", c=" + c + ", area=" + getArea() + '}';
    }

    @Override
    public double getArea() {
        double a = this.a * getScale();
        double b = this.b * getScale();
        double c = this.c * getScale();

        double halfPerimeter = (a + b + c) / 2.0;

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
