import java.util.Arrays;
import java.util.Date;

public class Logic {
    String compute (String name, String input) {
        double inputVal = Double.parseDouble ( input );

        if (name.equalsIgnoreCase ("SQUARE")) {
            return "" + (inputVal * inputVal);
        } else if (name.equalsIgnoreCase ("CUBE")) {
            return "" + (inputVal * inputVal * inputVal);
        } else if (name.equalsIgnoreCase ("SQRT")) {
            return "" + Math.sqrt(inputVal);
        } else if (name.equalsIgnoreCase ("ONE_OVER_N")) {
            return "" + ((double) 1 / inputVal);
        } else if (name.equalsIgnoreCase ( "ln" )) {
            return "" + Math.log ( inputVal );
        } else if (name.equalsIgnoreCase ( "log" )) {
            return "" + Math.log10 ( inputVal );
        } else if (Arrays.asList ("sin", "cos", "tan").contains ( name )) {
            return "" + this.trig(name, inputVal);
        }
        return "Invalid operation";
    }

    private double trig(String name, double inputVal) {
        double rad = Math.toRadians ( inputVal );
        if (name.equalsIgnoreCase ( "sin" )) {
            return Math.sin(rad);
        } else if (name.equalsIgnoreCase ( "tan" )) {
             return Math.tan ( rad );
        } else if (name.equalsIgnoreCase ( "cos" )) {
            return Math.cos ( rad );
        }
        return inputVal;
    }

    String compute(String operand1, String operand2, String operator){
        try {
            double parsedOperand1 = Double.parseDouble(operand1);
            double parsedOperand2 = Double.parseDouble(operand2);
            if (operator.equalsIgnoreCase("+")) {
                return ""+(parsedOperand1 + parsedOperand2);

            } else if (operator.equalsIgnoreCase("\u00D7")) {
                return ""+(parsedOperand1 * parsedOperand2);

            } else if (operator.equalsIgnoreCase("\u02D7")) {
                return ""+(parsedOperand1 - parsedOperand2);

            } else if (operator.equalsIgnoreCase("MOD")) {
                return ""+(parsedOperand1 % parsedOperand2);

            }else if(operator.equalsIgnoreCase("\u00F7")){
                return ""+(parsedOperand1 / parsedOperand2);

            }
        }catch (Exception e){
            System.out.println(new Date ()+"[Engine][compute] "+e.getMessage());
            return "ERROR";
        }
        return "FAILED";
    }

}
