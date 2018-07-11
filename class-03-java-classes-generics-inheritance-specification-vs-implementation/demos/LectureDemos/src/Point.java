public class Point {
    public int x;
    public int y;

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
}
