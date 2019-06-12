import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

/**
 * This class contains the elements for the calculator.
 * @author cankirsallioba
 * @version 12.06.2019
 */
public class Elements extends JFrame {

    //Properties
    Map <String, Buttons> map;
    private JPanel numPad = new JPanel();


    JTextField textField1 = new JTextField ();
    JTextField textField2 = new JTextField ();

    //Constructor
    public Elements (int width, int height) {
        this.setLayout ( null );
        this.setResizable ( false );
        this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
        this.setSize ( width, height );

    }

    private void createNumPad() {
        System.out.println(new Date()+"[ElementContainer][setupKeyPad] Setting up keypad...");
        //------------setting font, color and style of buttons-------
        ArrayList<String> mapKeys = Buttons.getMapKeysByType(this.map, "numeric");
        this.prepareButtons(mapKeys, FontAndColours.FONT_TYPE_1, FontAndColours.GREY);

        mapKeys = Buttons.getMapKeysByType(this.map, "operator");
        this.prepareButtons(mapKeys, FontAndColours.FONT_TYPE_1, FontAndColours.WHITE);

        mapKeys = Buttons.getMapKeysByType(this.map, "number_modifier");
        this.prepareButtons(mapKeys, FontAndColours.FONT_TYPE_1, FontAndColours.GREY);

        mapKeys = Buttons.getMapKeysByType(this.map, "answer");
        this.prepareButtons(mapKeys,  FontAndColours.FONT_TYPE_1, FontAndColours.CYAN);

        this.prepareButtonByKey("exit", FontAndColours.FONT_TYPE_1, FontAndColours. BRIGHT_RED);
        this.prepareButtonByKey("clear", FontAndColours.FONT_TYPE_1, Color.ORANGE);
        this.prepareButtonByKey("delete", FontAndColours.FONT_TYPE_1, Color.YELLOW);

        mapKeys = Buttons.getMapKeysByType(this.map, "single_operator");
        this.prepareButtons(mapKeys, FontAndColours.FONT_TYPE_1, FontAndColours.WHITE);

        this.prepareButtonByKey("percent", FontAndColours.FONT_TYPE_1, FontAndColours.WHITE);

        this.numPad = new JPanel();
        int keyPadY = (int) (this.getHeight() * FontAndColours.SCREEN_RATIO);
        int keyPadHeight = (int) (this.getHeight() * FontAndColours.NUMPAD_RATIO);
        this.add(this.numPad).setBounds(0, keyPadY, this.getWidth(), keyPadHeight);
        this.numPad.setLayout(null);
        this.numPad.setBackground(FontAndColours.BACKGROUND_COLOR);

        this.fixButtonsPlacement();

        System.out.println(new Date()+"[ElementContainer][setupKeyPad] Done!");
    }


}
