import com.mak.rpn.Operator;
import com.mak.rpn.RPNException;
import org.junit.Test;

import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;

public class OpertorTest {

    @Test
    public void testCalculate() throws RPNException {
        Random r = new Random();
        double firstOperand = r.nextDouble();
        double secondOperand = r.nextDouble();
        assertEquals(secondOperand + firstOperand, Operator.ADDITION.calculate(firstOperand, secondOperand), 0);
        assertEquals(secondOperand - firstOperand, Operator.SUBTRACTION.calculate(firstOperand, secondOperand), 0);
        assertEquals(secondOperand * firstOperand, Operator.MULTIPLICATION.calculate(firstOperand, secondOperand), 0);
        assertEquals(secondOperand / firstOperand, Operator.DIVISION.calculate(firstOperand, secondOperand), 0);
        assertEquals(pow(firstOperand, 2.0), Operator.POWER.calculate(firstOperand, null), 0);
        assertEquals(sqrt(secondOperand), Operator.SQUAREROOT.calculate(secondOperand, null), 0);
    }

    @Test(expected = RPNException.class)
    public void testDivideByZero() throws RPNException {
        Operator.DIVISION.calculate(0.0, 0.0);
    }

    @Test(expected = RPNException.class)
    public void testInvalidOperations() throws RPNException {
        Operator.UNDO.calculate(0.0, 0.0);
        Operator.CLEAR.calculate(0.0, 0.0);
    }
}
