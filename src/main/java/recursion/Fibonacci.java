package recursion;

import java.math.BigInteger;

public class Fibonacci {

    public BigInteger calculate(int i) {
        if(i == 1) {
            return new BigInteger("0");
        } else if (i == 2) {
            return new BigInteger("1");
        }
        return calculate(i - 1).add(calculate(i - 2));
    }

}
