1. Create your repo `data-structures-and-algorithms` on GitHub
2. Clone it down to your computer
3. Create a new project inside the cloned repo
4. Make one file called `D00_NameOfChallenge.java` in the `src` folder
  * like, `D01_ArrayReverse.java` for the first days challange
5. Create a method as specified by the challenge
  * Make sure the method is `public` `static`.
  * Choose an appropriate return type (`void` if nothing)
  * Choose appropriate method name (as specified)
  * Choose appropriate parameter types
6. Place your cursor 

**D01_ReverseArray.java**
```java
public class D01_ArrayReverse {
    public static void reverseArray(int[] arr) {
        
    }
}
```

Creating Tests

1. Place your cursor on the class name
2. Press `CMD` + `SHIFT` + `T` and choose `Create New Test...`
3. Choose JUnit 5 for the testing library
  * Click `Fix` button beneath dropdown if you see "JUnit 5 library not found in
    the module"
  * Choose "Use JUnit 5 from IntelliJ IDEA distribution"
  * Press "OK"
4. Check the checkbox for `reverseArray` in the "Generate test methods for:"
   section

A test file will appear with errors. Put your cursor on the first line with the
import with "Assertions." Wait for a red light-bulb drop-down icon to appear.
Click on it and choose "Add JUnit 5 to classpath."
                        
```java
import org.junit.jupiter.api.Test;

class D01_ArrayReverseTest {
    @Test
    void reverseArray() {
    }
}
```
