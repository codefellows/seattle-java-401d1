public class Main {
  public static void main(String[] args) {
    GenericClass<String> stringer = new GenericClass<>();
    stringer.set("I am a string!");

    GenericClass<Integer> inter = new GenericClass<>();
    inter.set(42);

    GenericClass<GenericClass<Boolean>> lister = new GenericClass<>();
    GenericClass<Boolean> booler = new GenericClass<>();
    booler.set(true);
    lister.set(booler);

    System.out.println("Stringer: " + stringer.get());
    System.out.println("Integer: " + inter.get());
    System.out.println("Lister: " + lister.get().get());
  }
}
