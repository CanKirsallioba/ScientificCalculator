import java.awt.*;
import java.util.ArrayList;

public class FontAndColours {

    /* FONT CONSTANTS */
    final static Font DEFAULT_FONT = new Font ("MonoSpaced", Font.BOLD, 30);
    final static Font FONT_TYPE_1 = new Font ("MonoSpaced", Font.BOLD, 15);
    final static Font FONT_TYPE_2 = new Font ("MonoSpaced", Font.BOLD, 10);

    /*COLOUR CONSTANTS*/
    final static Color GHOST_GREEN = new Color ( 0, 120, 0 );
    final static Color CYAN = new Color (0,255,255);
    final static Color BRIGHT_RED = new Color (225,66,66);
    final static Color WHITE = new Color (255,255,255);
    final static Color GREY = new Color ( 110, 119, 129);
    final static Color ORANGE = new Color (255,69,0);
    final static Color BACKGROUND_COLOR = new Color (0, 0,128);

    /*RATIO_INFORMATION*/
    final static double SCREEN_RATIO = 0.2;
    final static double NUMPAD_RATIO = 0.75;
    final static double INFORMATION_RATIO = 0.05;
    final static double INPUT_RATIO = 0.3;
    final static double OUTOUT_RATIO = 0.7;

    final static int BUTTON_HEIGHT = 40;
    final static int BUTTON_PER_LINE = 5;

    public static String operatorFinder (String string, ArrayList <String> elements) {
        for (String element : elements) {
            if (string.contains ( element )) {
                return element;
            }
        }
        return"";
    }

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
