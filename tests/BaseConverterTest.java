import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseConverterTest {

    @Test
    void baseFourToBaseTen() {
        BaseConverter baseConverter = new BaseConverter();
        assertEquals(1, baseConverter.baseFourToBaseTen(1));
    }

    @Test
    void baseTenToBaseFour() {
        BaseConverter baseConverter = new BaseConverter();
        assertEquals(0, baseConverter.baseTenToBaseFour(0));
    }


}