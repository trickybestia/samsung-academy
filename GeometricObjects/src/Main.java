import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[] {new Circle(10), new Rectangle(5, 5), new Triangle(5, 3, 3)};

        Arrays.sort(objects);

        System.out.println(Arrays.toString(objects));
    }
}
