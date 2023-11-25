public abstract class GeometricObject implements Comparable<GeometricObject> {
    private double scale = 1.0;

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public int compareTo(GeometricObject other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    public abstract double getArea();
}
