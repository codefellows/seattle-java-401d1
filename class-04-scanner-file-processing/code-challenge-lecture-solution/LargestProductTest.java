package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestProductTest {
    @Test
    void largestProduct() {
        int[][] data = {
                {1, 2, 1},
                {2, 4, 2},
                {3, 6, 8},
                {7, 8, 1}
        };
        int result = LargestProduct.largestProduct(data);
        assertEquals(64, result);
    }

}