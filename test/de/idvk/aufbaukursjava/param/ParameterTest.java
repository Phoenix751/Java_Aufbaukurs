package de.idvk.aufbaukursjava.param;

import de.idvk.aufbaukursjava.rechner.Taschenrechner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {

    @BeforeEach
    public void init() {
        System.out.println("hello");
    }

    public static int[][] data() {
        return new int[][]{{1, 2, 2}, {3, 4, 12}, {20, 100, 2000}};
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void paramTestMult(int[] data) {
        Taschenrechner tester = new Taschenrechner();
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, tester.mult(m1, m2));
    }
}
