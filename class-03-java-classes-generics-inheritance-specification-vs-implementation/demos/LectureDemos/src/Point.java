public class Point {
    public static int MILES_PER_RADIAN = 69;

    public int x;
    public int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // the constructor defines how objects are constructed
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(int x2, int y2) {
        int dx = this.x - x2;
        int dy = this.y - y2;

        double result = Math.sqrt(dx * dx + dy * dy);
        return result;
    }

    public double distanceInMiles(int x2, int y2) {
        double distance = this.distance(x2, y2);
        return distance * MILES_PER_RADIAN;
    }

    // wrote our own toString() method so Java will
    // pretty-print our objects when they're printed.
    @Override
    public String toString() {
        return "(" + this.x +"," + this.y + ")";
    }

    public boolean equals(Point other) {
        return this.x == other.x && this.y == other.y;
    }

    public static Point otherSideOfWorld(Point point) {
        return new Point(-point.x, -point.y);
    }
}
