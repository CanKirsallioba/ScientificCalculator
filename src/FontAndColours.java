import java.awt.*;
import java.util.ArrayList;

/**
 * The type Font and colours.
 * @author Can Kirsallioba
 * @version 14.06.2019
 */
public class FontAndColours {

    /**
     * The constant DEFAULT_FONT.
     */
    /* FONT CONSTANTS */
    final static Font DEFAULT_FONT = new Font ("MonoSpaced", Font.BOLD, 30);
    /**
     * The constant FONT_TYPE_1.
     */
    final static Font FONT_TYPE_1 = new Font ("MonoSpaced", Font.BOLD, 15);

    /**
     * The constant CYAN.
     */
    /*COLOUR CONSTANTS*/
    final static Color CYAN = new Color (0,255,255);
    /**
     * The constant BRIGHT_RED.
     */
    final static Color BRIGHT_RED = new Color (225,66,66);
    /**
     * The constant WHITE.
     */
    final static Color WHITE = new Color (255,255,255);
    /**
     * The constant GREY.
     */
    final static Color GREY = new Color ( 110, 119, 129);
    /**
     * The constant ORANGE.
     */
    final static Color ORANGE = new Color (255,69,0);
    /**
     * The constant BACKGROUND_COLOR.
     */
    final static Color BACKGROUND_COLOR = new Color (0, 0,128);

    /**
     * The constant SCREEN_RATIO.
     */
    /*RATIO_INFORMATION*/
    final static double SCREEN_RATIO = 0.2;
    /**
     * The constant NUMPAD_RATIO.
     */
    final static double NUMPAD_RATIO = 0.75;
    /**
     * The constant INFORMATION_RATIO.
     */
    final static double INFORMATION_RATIO = 0.05;
    /**
     * The constant INPUT_RATIO.
     */
    final static double INPUT_RATIO = 0.3;
    /**
     * The constant OUTPUT_RATIO.
     */
    final static double OUTPUT_RATIO = 0.7;

    /**
     * The constant BUTTON_HEIGHT.
     */
    final static int BUTTON_HEIGHT = 40;
    /**
     * The constant BUTTON_PER_LINE.
     */
    final static int BUTTON_PER_LINE = 5;

    /**
     * Operator finder string.
     *
     * @param string   the string
     * @param elements the elements
     * @return the string
     */
    public static String operatorFinder (String string, ArrayList <String> elements) {
        for (String element : elements) {
            if (string.contains ( element )) {
                return element;
            }
        }
        return"";
    }

    /**
     * Is last char boolean.
     *
     * @param string   the entered string
     * @param elements the arraylist of the elements
     * @return the boolean true or false checking if the element is the last in the string
     */
    public static boolean isLastChar(String string, ArrayList <String> elements) {
        String lastChar = string.substring ( string.length() - 1 );

        for (String element : elements) {
            if (lastChar.equalsIgnoreCase ( element )){
                return true;
            }
        }
        return false;
    }
}
