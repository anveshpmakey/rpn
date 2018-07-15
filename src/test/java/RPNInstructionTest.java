import com.mak.rpn.Operator;
import com.mak.rpn.RPNException;
import com.mak.rpn.RPNInstruction;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class RPNInstructionTest {

    @Test
    public void testReverseOneOperandInstruction() throws RPNException {

        Operator mockOperator = Mockito.mock(Operator.class);
        when(mockOperator.getNumOfOperators()).thenReturn(1);
        when(mockOperator.getReverseOperation()).thenReturn("sqrt");

        Random r = new Random();
        RPNInstruction rpnInstruction = new RPNInstruction(mockOperator, r.nextDouble());

        assertEquals(String.format("%s", mockOperator.getReverseOperation()), rpnInstruction.getReverseInstruction());
    }

    @Test
    public void testReverseTwoOperandInstruction() throws RPNException {

        Operator mockOperator = Mockito.mock(Operator.class);
        when(mockOperator.getNumOfOperators()).thenReturn(2);
        when(mockOperator.getReverseOperation()).thenReturn("-");

        Random r = new Random();
        double value = r.nextDouble();
        RPNInstruction rpnInstruction = new RPNInstruction(mockOperator, value);

        assertEquals(
                String.format("%f %s %f", value, mockOperator.getReverseOperation(), value),
                rpnInstruction.getReverseInstruction()
        );
    }

    @Test(expected = RPNException.class)
    public void testInvalidOperandsNumber() throws RPNException {
        Operator mockOperator = Mockito.mock(Operator.class);
        when(mockOperator.getNumOfOperators()).thenReturn(0);

        Random r = new Random();
        RPNInstruction rpnInstruction = new RPNInstruction(mockOperator, r.nextDouble());
        rpnInstruction.getReverseInstruction();
    }
}
