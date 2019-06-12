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
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.GREY);

        mapKeys = Buttons.getMapKeysByType(this.map, "operator");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.WHITE);

        mapKeys = Buttons.getMapKeysByType(this.map, "number_modifier");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.GREY);

        mapKeys = Buttons.getMapKeysByType(this.map, "answer");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.LIGHT_BLUE);

        this.prepareButtonByKey("exit", Helper.KEY_FONT_MD, Helper.RED);
        this.prepareButtonByKey("clear", Helper.KEY_FONT_MD, Color.ORANGE);
        this.prepareButtonByKey("delete", Helper.KEY_FONT_MD, Color.YELLOW);

        mapKeys = Buttons.getMapKeysByType(this.map, "single_operator");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.WHITE);

        this.prepareButtonByKey("percent", Helper.KEY_FONT_MD, Helper.WHITE);

        this.numPad = new JPanel();
        int keyPadY = (int) (this.getHeight() * Helper.SCREEN_RATIO);
        int keyPadHeight = (int) (this.getHeight() * Helper.KEYPAD_RATIO);
        this.add(this.numPad).setBounds(0, keyPadY, this.getWidth(), keyPadHeight);
        this.numPad.setLayout(null);
        this.numPad.setBackground(Helper.darkGrey);

        this.fixButtonsPlacement();

        System.out.println(new Date()+"[ElementContainer][setupKeyPad] Done!");
    }


}
