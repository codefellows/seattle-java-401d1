public class MyMapProgram {
    public static void main(String[] args) {
        System.out.println("Miles per radian: " + Point.MILES_PER_RADIAN);

        Point origin = new Point();
        Point portland = new Point(45, 122);
        Point singapore = new Point(1, 103);
        Point tokyo = new Point(35, 139);

        double tokyoToSingapore = tokyo.distanceInMiles(singapore.x, singapore.y);
        System.out.println(tokyoToSingapore);
        System.out.println();

        String seattleName1 = "seattle";
        String seattleName2 = "seattle";

        Point seattle = new Point(47, 122);
        Point bizzarroSeattle = new Point(47, 122);

        boolean isSameName = seattleName1 == seattleName2;
        boolean isSamePoint = seattle.equals(bizzarroSeattle);

        System.out.println("seattle1 == seattle2? " + isSameName);
        System.out.println("Is seattle bizarroSeattle? " + isSamePoint);

        // originally they have the same coordinates
        System.out.println(seattle);
        System.out.println(bizzarroSeattle);
        System.out.println();

        // change the x coordinate of bizzaroSeattle to prove
        // that it is it's own object and won't affect other Seattle
        bizzarroSeattle.x = -bizzarroSeattle.x;

        // inspect after modifying
        System.out.println(seattle);
        System.out.println(bizzarroSeattle);
        System.out.println();


        Point oppositeSeattle = Point.otherSideOfWorld(seattle);
    }
}
