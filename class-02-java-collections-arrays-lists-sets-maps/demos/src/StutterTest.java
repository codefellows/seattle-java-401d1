import static org.junit.jupiter.api.Assertions.*;

class StutterTest {
    @org.junit.jupiter.api.Test
    void emptyList() {
        int[] aa = {};
        int[] stuttered = Stutter.stutter(aa);

        assertEquals(0, stuttered.length);
    }

    @org.junit.jupiter.api.Test
    void threeItemTest() {
        int[] aa = {34, 55, 77};
        int[] stuttered = Stutter.stutter(aa);

        assertEquals(aa.length * 2, stuttered.length);
        assertEquals(stuttered[0], stuttered[1]);
    }


}