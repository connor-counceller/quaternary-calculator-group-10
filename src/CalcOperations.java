import java.text.BreakIterator;

public class CalcOperations {
    private char operatorClicked;
    

    public void getResult () {
        double result = 0;
        double[] temporary = {0, 0};
        temporary[1] = Double.parseDouble(String.valueOf(Calculator.class));
        try {
            if (operatorClicked == '+') {
                result = temporary[0] + temporary[1];
            } else if (operatorClicked == '-') {
                result = temporary[0] - temporary[1];
            } else if (operatorClicked == '*') {
                result = temporary[0] * temporary[1];
            } else if (operatorClicked == '/') {
                result = temporary[0] / temporary[1];
            }
            String s = Double.toString(result);
            for (int i = 0; i < 4; i++) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}