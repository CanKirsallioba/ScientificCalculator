import javax.swing.*;

public class Buttons extends JButton {
    String buttonType;
    String nameOfElement;
    String message;

    private Buttons(String buttonType, String nameOfElement, String buttonText, String message) {
        super(buttonText);
        this.buttonType = buttonType;
        this.nameOfElement = nameOfElement;
        this.message = message;
    }

    public String toString() {
        return "{ButtonType: " + this.buttonType + ", nameOfElement: " + this.nameOfElement + ", button:" + this.getText() + ", message: " + this.message + "}";
    }

    public boolean isOperator

}
