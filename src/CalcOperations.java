public class CalcOperations {
    

    public int getResult (String operatorClicked, int baseFourNumber, int baseFourOperand) {

         if (operatorClicked.equals("+")) {
          baseFourNumber += baseFourOperand;
         }else if (operatorClicked.equals("-")){
          baseFourNumber -= baseFourOperand;
         }else if (operatorClicked.equals("*")) {
          baseFourNumber *= baseFourOperand;
         }else if (operatorClicked.equals("/")){
            if (baseFourOperand != 0) {
                baseFourNumber /= baseFourOperand;
            } else {
                return -1;
            }
         }
         return baseFourNumber;
    }
}