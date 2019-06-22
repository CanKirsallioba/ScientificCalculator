import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Buttons.
 * @author Can Kirsallioba
 * @version 14.06.2019
 */
public class Buttons extends JButton {
    /**
     * The Button type.
     */
    String buttonType;
    /**
     * The Name of element.
     */
    String nameOfElement;
    /**
     * The Message.
     */
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


    /**
     * This method has all the elements in the calculator.
     *
     * @return map of the elements
     */
    public static Map<String, Buttons> getAll() {
        Map <String, Buttons> map = new HashMap <String, Buttons>();
        for (int i = 0; i <= 9  ; i++) {
            map.put("" + i, new Buttons("numeric", "" + i, "" + i, "" + i));
        }

        map.put("ADD", new Buttons("operator","ADD","+", "+"));
        map.put("SUB", new Buttons("operator","SUBTRACT","\u02D7", "\u02D7"));
        map.put("MUL", new Buttons("operator","MULTIPLY","\u00D7", "\u00D7"));
        map.put("DIV", new Buttons("operator","DIVIDE","\u00F7", "\u00F7"));
        map.put("MOD", new Buttons("operator","MOD","MOD", "MOD"));
        map.put("EQUAL", new Buttons("answer","EQUAL","=", "="));
        map.put("POINT", new Buttons("number_modifier","POINT",".", "."));
        map.put("DEL", new Buttons("command","DELETE","DEL", ""));
        map.put("CLEAR", new Buttons("command","CLEAR","C", ""));
        map.put("EXIT", new Buttons("command","EXIT","EXIT", ""));
        map.put("PERCENT", new Buttons("PERCENT","PERCENT", "%","%"));
        /* ADVANCED OPERATORS */
        map.put("ONE_OVER_N", new Buttons("advancedOperator","ONE_OVER_N","1/n","1/n"));
        map.put("SQUARE", new Buttons("advancedOperator", "SQUARE","x\u00B2","x\u00B2"));
        map.put("CUBE", new Buttons("advancedOperator","CUBE","x\u00B3","x\u00B3"));
        map.put("SQRT", new Buttons("advancedOperator","SQRT","x\u00B3","x\u00B3"));
        map.put("TENTH_POWER", new Buttons("advancedOperator","TENTH_POWER","10^n","10^n"));
        map.put("ABS", new Buttons("advancedOperator","ABSOLUTE","ABS","ABS"));

        String[] others = {"sin", "cos", "tan", "asin", "acos", "atan", "sinh", "cosh", "tanh", "ln", "log"};
        for (String text : others) {
            map.put(text, new Buttons ("advancedOperator", text, text, text));
        }
        return map;
    }

    /**
     * Gets map keys by type.
     *
     * @param buttonMap the map of the buttons
     * @param type is the type of the key value.
     * @return an arrayList of the map keys.
     */
    static ArrayList<String> getMapKeysByType(Map<String, Buttons> buttonMap, String type) {
        ArrayList<String> keyList = new ArrayList<>();
        for (String mapKey : buttonMap.keySet()) {
            Buttons button = buttonMap.get(mapKey);
            if (button.buttonType.equalsIgnoreCase(type)) {
                keyList.add(mapKey);
            }
        }
        return keyList;
    }

    /**
     * Get screen text list by type array list.
     *
     * @param buttonMap the map of the buttons
     * @param type  button type.
     * @return the array list of the buttons.
     */
    static ArrayList<String> getScreenTextListByType(Map<String, Buttons> buttonMap, String type){
        ArrayList<String> textList = new ArrayList<>();
        for (String mapKey : buttonMap.keySet()) {
            Buttons button = buttonMap.get(mapKey);
            if (button.buttonType.equalsIgnoreCase(type)) {
                textList.add(button.message);
            }
        }
        return textList;
    }


}
