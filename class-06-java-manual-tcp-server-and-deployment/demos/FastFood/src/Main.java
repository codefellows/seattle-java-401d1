import fastfood.McDonalds;

public class Main {
    public static void main(String[] args) {
        McDonalds mc = new McDonalds();

        System.out.println("opens: " + mc.openingHour());
        System.out.println("closes: " + mc.closingHour());
    }
}
