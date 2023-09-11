import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcOperationsTest {

    @Test

    void getResult(){
        CalcOperations calcOperations = new CalcOperations();
        assertEquals(1, calcOperations.getResult("+", 0, 1));
        assertEquals(1, calcOperations.getResult("-", 5, 4));
        assertEquals(20, calcOperations.getResult("*", 5, 4));
        assertEquals(2, calcOperations.getResult("/", 10, 5));
    }
}
