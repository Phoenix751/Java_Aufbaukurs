package de.idvk.aufbaukursjava.dynamic;

import de.idvk.aufbaukursjava.rechner.Taschenrechner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicTest {


    @BeforeEach
    public void init() {
        System.out.println("hello");
    }

    @TestFactory
    Stream<org.junit.jupiter.api.DynamicTest> testMultiply() {
        Taschenrechner tr = new Taschenrechner();
        int[][] input = {{1, 2, 2}, {3, 4, 12}, {20, 100, 2000}};
        return Arrays.stream(input).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return org.junit.jupiter.api.DynamicTest.dynamicTest(m1 + "*" + m2 + "=" + expected, () -> {
                assertEquals(expected, tr.mult(m1, m2));
            });
        });
    }


}
