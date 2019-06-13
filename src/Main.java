public class Main {
    public static void main (String [] args) {
        CalculatorLogic calculator = new CalculatorLogic ( 450, 600 );
        calculator.setTitle ("CK-Calculator");
        calculator.getContentPane ().setBackground ( FontAndColours.BACKGROUND_COLOR);
        calculator.setLocationRelativeTo ( null );
        calculator.setVisible ( true );
        //calculator.setIcon (  );
    }
}
