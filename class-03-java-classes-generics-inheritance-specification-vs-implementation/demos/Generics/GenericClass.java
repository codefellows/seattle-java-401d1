public class GenericClass<E> {
  E thing;

  public GenericClass() {

  }

  public void set(E thing) {
    this.thing = thing;
  }

  public E get() {
    return this.thing;
  }
}
