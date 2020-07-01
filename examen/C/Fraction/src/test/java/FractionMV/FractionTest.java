package FractionMV;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Unit test for simple App.
 */

public class FractionTest {

    @Test
    public void testSimplify() {

        String[] arrayNumbers = {"12", "30"};
        Fraction fc1 = new Fraction(Integer.parseInt(arrayNumbers[0]), Integer.parseInt(arrayNumbers[1]));
        fc1.Simplify();
        assertEquals(2, fc1.getNumerator());
        assertEquals(5, fc1.getDenominator());

        String[] arrayNumbers2 = {"-25", "7"};
        Fraction fc2 = new Fraction(Integer.parseInt(arrayNumbers2[0]), Integer.parseInt(arrayNumbers2[1]));
        fc2.Simplify();
        assertEquals(-25, fc2.getNumerator());
        assertEquals(7, fc2.getDenominator());
    }

    @Test
    public void testDenominator() {
        String[] arrayNumbers = {"12", "30"};
        Fraction fc1 = new Fraction(Integer.parseInt(arrayNumbers[0]), Integer.parseInt(arrayNumbers[1]));
        int result = fc1.getDenominator();
        assertEquals("getDenominator() returned " + result + " instead of 30.", 30, result);

        fc1.setDenominator(1);
        int result2 = fc1.getDenominator();
        assertEquals("getDenominator() returned " + result2 + " instead of 1.", 1, result2);
    }

    @Test
    public void testNumerator() {
        String[] arrayNumbers = {"12", "30"};
        Fraction fc1 = new Fraction(Integer.parseInt(arrayNumbers[0]), Integer.parseInt(arrayNumbers[1]));
        int result = fc1.getNumerator();
        assertEquals("getNumerator() returned " + result + " instead of 12.", 12, result);

        fc1.setNumerator(1);
        int result2 = fc1.getNumerator();
        assertEquals("getNumerator() returned " + result2 + " instead of 1.", 1, result2);
    }

    public String[] getNumbersFromFile(String numbersFile) throws IOException {
        int n = 0;
        BufferedReader in = new BufferedReader(new FileReader(numbersFile));
        while ((in.readLine()) != null) {
            n++;
        }
        in.close();

        String[] la = new String[n];
        String s = new String();
        int i = 0;
        in = new BufferedReader(new FileReader(numbersFile));
        while ((s = in.readLine()) != null) {
            la[i] = s;
            i++;
        }
        in.close();
        return la;
    }


}
