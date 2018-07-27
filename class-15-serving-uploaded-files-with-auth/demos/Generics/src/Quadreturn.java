public class Quadreturn<A, B, C, D> {
    A a;
    B b;
    C c;
    D d;

    public static void main(String[] args) {
        Quadreturn<String, Integer, Integer, Integer> info = analyzeText();
        System.out.println("Words: " + info.c);
    }

    public static Quadreturn<String, Integer, Integer, Integer> analyzeText() {
        Quadreturn<String, Integer, Integer, Integer> qq =
         new Quadreturn<>();
        qq.a = "Book Title";
        qq.b = 1234; // lines
        qq.c = 98882; // words
        qq.d = 123232; // syllables

        return qq;
    }
}
