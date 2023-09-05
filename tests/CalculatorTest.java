import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void example() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.example(1, 2));
    }
}