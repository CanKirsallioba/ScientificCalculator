import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class CalculatorLogic extends Elements implements ActionListener {
    private Logic logic = new Logic();

    public CalculatorLogic (int width, int height) {
        super (width, height);
        addActionListenerToAll();
    }

    private void addActionListenerToAll() {
        for (String key : map.keySet()) {
            map.get(key).addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Buttons pressedButton = (Buttons) e.getSource();
        String buttonType = pressedButton.buttonType;
        String pureName = pressedButton.nameOfElement;

        System.out.println(new Date ()+"[Calculator][actionPerformed] Button clicked :" + e.getActionCommand()+" "+e.getSource());

        if(pureName.equalsIgnoreCase("exit")){
            System.exit(0);

        }else if(pureName.equalsIgnoreCase("clear")){
            this.clearScreen();

        }else if(pureName.equalsIgnoreCase("delete")){
            this.deleteInput();

        }else if(buttonType.equalsIgnoreCase("advancedOperator")){
            this.singleOperation(pressedButton);

        }else if(buttonType.equalsIgnoreCase("numeric")){
            this.displayNumber(pressedButton);

        }else if(buttonType.equalsIgnoreCase("number_modifier")){
            this.displayNumberModifier(pressedButton);

        }else if(buttonType.equalsIgnoreCase("operator")){
            this.displayOperator(pressedButton);

        }else if(buttonType.equalsIgnoreCase("answer")){
            this.getAnswer(this.tf1.getText());
        }
    }

    private void clearScreen(){
        this.tf1.setText("0");
        this.tf2.setText("0");
    }

    private void deleteInput(){
        String input = this.tf1.getText();
        ArrayList<String> operators = Buttons.getScreenTextListByType(this.map, "operator");
        ArrayList<String> numbers = Buttons.getScreenTextListByType(this.map, "numeric");
        if(input.length() == 1){
            this.tf1.setText("0");
        }else if(FontAndColours.isLastChar(input, operators) || FontAndColours.isLastChar(input, numbers)){
            this.tf1.setText(input.substring(0, input.length()-1));
        }
    }

    private void displayNumber(Buttons numericButton){
        if(this.isInputClear()){
            this.tf1.setText(numericButton.message);
        }else{
            this.tf1.setText(this.tf1.getText()+numericButton.message);
        }
    }

    private void displayNumberModifier(Buttons numberModifierButton){
        String inputText = this.tf1.getText();
        if(!inputText.contains(numberModifierButton.message)){
            this.tf1.setText(this.tf1.getText()+numberModifierButton.message);
        }
    }

    private void displayOperator(Buttons operatorButton){

        if(this.hasInputOperator()){
            this.getAnswer(this.tf1.getText());
        }
        if(this.isOutputClear()){
            this.tf1.setText(this.tf1.getText()+operatorButton.message);
        }else{
            this.tf1.setText(this.tf2.getText()+operatorButton.message);
        }
    }

    private void singleOperation(Buttons operatorButton){
        String input = "";
        if(!this.isOutputClear()){
            input = this.tf2.getText();
        }else{
            if(this.hasInputOperator()){
                this.getAnswer(this.tf1.getText());
                input = this.tf2.getText();
            }else{
                input = this.tf1.getText();
            }
        }

        this.tf1.setText(operatorButton.message + "(" + input + ")");

        String result = this.logic.compute(operatorButton.nameOfElement, input);
        this.tf2.setText(result);
    }

    private void getAnswer(String input){
        String operator = this.getInputFirstOperator();
        if(operator.equals("")){
            this.tf2.setText(this.tf1.getText());
        }else{
            int operatorPosition = input.indexOf(operator);
            String operand1 = input.substring(0, operatorPosition);
            String operand2 = input.substring(operatorPosition+operator.length(), input.length());
            String result = this.logic.compute(operand1, operand2, operator);
            this.tf2.setText(result);
        }
    }

    private boolean isInputClear(){
        return this.tf1.getText().equals("0");
    }

    private boolean isOutputClear(){
        return this.tf2.getText().equals("0");
    }

    private boolean isBothDisplayClear(){
        return this.isInputClear() && this.isOutputClear();
    }

    private String getInputFirstOperator(){
        String input = this.tf1.getText();
        ArrayList<String> operatorList = Buttons.getScreenTextListByType(this.map, "operator");
        return FontAndColours.operatorFinder (input, operatorList);
    }

    private boolean hasInputOperator(){
        return !this.getInputFirstOperator().equals("");
    }

}
