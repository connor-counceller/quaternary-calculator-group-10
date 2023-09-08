public class BaseConverter {

    public int baseFourToBaseTen(int baseFourInt) {
        String baseFourString = Integer.toString(baseFourInt);
        int baseFourDigits = baseFourString.length();
        int baseTenInt = 0;
        int currentDigit;

        for (int i = 0; i < baseFourDigits; i++) {
            currentDigit = Character.getNumericValue(baseFourString.charAt(i));
            baseTenInt += currentDigit * (Math.pow(4, (baseFourDigits - i - 1)));
        }
        return baseTenInt;
    }

    public int baseTenToBaseFour(int baseTenInt) {
        String baseTenString = Integer.toString(baseTenInt);
        int baseFourInt = 0;
        int power = 1;
        for (int i = baseTenString.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(baseTenString.charAt(i));
            baseFourInt += digit * power;
            power = power * 4;
        }
        return baseFourInt;
    }
}
