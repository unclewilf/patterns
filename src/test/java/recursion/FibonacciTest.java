package recursion;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

    private Fibonacci fib = new Fibonacci();

    int[] sequence = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};

    @Test
    public void allInSequence() throws Exception {
        for (int i=1; i<sequence.length+1; i++) {
            int result = sequence[i - 1];
            assertThat(fib.calculate(i), is(equalTo(BigInteger.valueOf(result))));
        }
    }

    @Test
    public void whatIsThisMassiveNumber() throws Exception {
        int testNumber = 50;
        BigInteger number = fib.calculate(testNumber);
        System.out.println("test number: '" + testNumber + "' fibonacci result: '" + number);
        assertThat(number, is(any(BigInteger.class)));
    }

}
