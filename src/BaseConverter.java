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
        int baseFourInt;
        StringBuilder baseFourBuilder = new StringBuilder();
        if (baseTenInt == 0){
            return 0;
        }
        else{
            while(baseTenInt != 0){
                int quotient = baseTenInt % 4;
                baseFourBuilder.insert(0, quotient);
                baseTenInt = baseTenInt/4;
            }
        }
        String baseFourString = baseFourBuilder.toString();
        baseFourInt = Integer.parseInt(baseFourString);
        return baseFourInt;
    }
}
