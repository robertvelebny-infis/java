package dalsiHustaSlozkaNaInterfejsy;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class nejakejSetNeboNeco {
    public static void main(String[] args) {
        Set<Point> set = new HashSet<>();

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            points.add(new Point(Math.floor(Math.random() * 10) / 10, Math.floor(Math.random() * 10) / 10));
            set.add(points.get(i));
        }
        System.out.println(set.size());

    }
}

class Point{
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
