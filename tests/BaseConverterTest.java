import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseConverterTest {

    @Test
    void baseFourToBaseTen() {
        BaseConverter baseConverter = new BaseConverter();
        assertEquals(1, baseConverter.baseFourToBaseTen(1));
        assertEquals(6, baseConverter.baseFourToBaseTen(12));
        assertEquals(27, baseConverter.baseFourToBaseTen(123));
        assertEquals(108, baseConverter.baseFourToBaseTen(1230));
        assertEquals(433, baseConverter.baseFourToBaseTen(12301));
    }

    @Test
    void baseTenToBaseFour() {
        BaseConverter baseConverter = new BaseConverter();
        assertEquals(0, baseConverter.baseTenToBaseFour(0));
        assertEquals(123, baseConverter.baseTenToBaseFour(27));
        assertEquals(321, baseConverter.baseTenToBaseFour(57));
        assertEquals(3212, baseConverter.baseTenToBaseFour(230));
    }


}