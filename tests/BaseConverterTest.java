import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseConverterTest {

    @Test
    void baseTenToBaseFour() {
        BaseConverter baseConverter = new BaseConverter();
        assertEquals(0, baseConverter.baseTenToBaseFour(0));
    }

    @Test
    void baseFourToBaseTen() {
        BaseConverter baseConverter = new BaseConverter();
        assertEquals(0, baseConverter.baseFourToBaseTen(0));
    }
}