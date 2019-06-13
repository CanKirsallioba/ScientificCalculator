import javax.swing.*;
import java.awt.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * This class contains the elements for the calculator.
 * @author cankirsallioba
 * @version 12.06.2019
 */
public class Elements extends JFrame {

    //Properties
    Map <String, Buttons> map;
    private JPanel numPad = new JPanel();
    private JPanel information = new JPanel ();

    JTextField tf1 = new JTextField ();
    JTextField tf2 = new JTextField ();

    //Constructor
    public Elements (int width, int height) {
        this.setLayout ( null );
        this.setResizable ( false );
        this.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        this.setSize ( width, height );
        this.setBackground ( FontAndColours.BACKGROUND_COLOR );

        this.map = Buttons.getAll ();
        this.createNumPad ();
        this.setupFooter ();
        this.setupDisplay ();

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

        this.prepareButtonByKey("EXIT", FontAndColours.FONT_TYPE_1, FontAndColours. BRIGHT_RED);
        this.prepareButtonByKey("CLEAR", FontAndColours.FONT_TYPE_1, Color.ORANGE);
        this.prepareButtonByKey("DEL", FontAndColours.FONT_TYPE_1, Color.YELLOW);

        mapKeys = Buttons.getMapKeysByType(this.map, "advancedOperator");
        this.prepareButtons(mapKeys, FontAndColours.FONT_TYPE_1, FontAndColours.WHITE);

        this.prepareButtonByKey("PERCENT", FontAndColours.FONT_TYPE_1, FontAndColours.WHITE);

        this.numPad = new JPanel();
        int keyPadY = (int) (this.getHeight() * FontAndColours.SCREEN_RATIO);
        int keyPadHeight = (int) (this.getHeight() * FontAndColours.NUMPAD_RATIO);
        this.add(this.numPad).setBounds(0, keyPadY, this.getWidth(), keyPadHeight);
        this.numPad.setLayout(null);
        this.numPad.setBackground(FontAndColours.BACKGROUND_COLOR);

        this.fixButtonsPlacement();

        System.out.println(new Date()+"[ElementContainer][setupKeyPad] Done!");
    }

    private void setupDisplay() {
        System.out.println(new Date()+"[ElementContainer][setupDisplay] Setting up display screens...");
        JPanel screen = new JPanel();
        screen.setLayout(null);
        int screenHeight = (int) (this.getHeight() * FontAndColours.SCREEN_RATIO);
        this.add(screen).setBounds(0, 0, this.getWidth(), screenHeight);
        //Input display
        screen.add(tf1);
        int inputDisplayHeight = (int) (screen.getHeight() * FontAndColours.INPUT_RATIO);
        this.tf1.setBounds(0, 0, screen.getWidth(), inputDisplayHeight);
        this.tf1.setHorizontalAlignment(JTextField.LEFT);
        this.tf1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        this.tf1.setText("0");
        this.tf1.setEditable(false);
        this.tf1.setBackground(FontAndColours.GHOST_GREEN);
        this.tf1.setForeground(Color.BLACK);

        //Output display
        screen.add(this.tf2);
        int outputDisplayHeight = (int) (screen.getHeight() * FontAndColours.OUTPUT_RATIO);
        this.tf2.setBounds(0, inputDisplayHeight, screen.getWidth(), outputDisplayHeight);
        this.tf2.setHorizontalAlignment(JTextField.RIGHT);
        this.tf2.setFont(FontAndColours.DEFAULT_FONT);
        this.tf2.setText("0");
        this.tf2.setEditable(false);
        this.tf2.setBackground(FontAndColours.GHOST_GREEN);
        this.tf2.setForeground(Color.BLACK);
        System.out.println(new Date()+"[ElementContainer][setupDisplay] Done!");
    }
    private void setupFooter(){
        System.out.println(new Date()+"[ElementContainer][setupFooter] Setting up footer...");
        int footerY = (int) (this.getHeight() * (FontAndColours.SCREEN_RATIO + FontAndColours.NUMPAD_RATIO));
        int footerHeight = (int)(this.getHeight() * FontAndColours.INFORMATION_RATIO);
        this.add(information).setBounds(0, footerY, this.getWidth(), footerHeight);

        JLabel copyrightTag = new JLabel("\u00A9 "+ Year.now().getValue()+"  CanKirsallioba");
        copyrightTag.setForeground(FontAndColours.CYAN);
        this.information.add(copyrightTag).setBounds(0, 0, this.information.getWidth(), this.information.getHeight());
        System.out.println(new Date()+"[ElementContainer][setupFooter] Done!");
    }

    private void prepareButtons(ArrayList<String> buttonHolderMapKeys, Font font, Color bgColor) {
        for (String key : buttonHolderMapKeys) {
            this.prepareButtonByKey(key, font, bgColor);
        }
    }

    private void prepareButtonByKey(String key, Font font, Color bgColor) {
        this.map.get(key).setFont(font);
        this.map.get(key).setBackground(bgColor);
        this.map.get(key).setFocusable(false);
    }

    private void fixButtonsPlacement() {
        System.out.println(new Date()+"[ElementContainer][fixButtonsPlacement] Placing buttons...");

        int btnWidth = this.numPad.getWidth() / FontAndColours.BUTTON_PER_LINE;
        this.numPad.add(this.map.get("CLEAR")).setBounds(0, 0, btnWidth, FontAndColours.BUTTON_HEIGHT);
        this.numPad.add(this.map.get("DEL")).setBounds(btnWidth, 0, btnWidth, FontAndColours.BUTTON_HEIGHT);

        String[] commonButtons = {"1", "2", "3", "ADD", "SUB", "4", "5", "6", "MUL", "DIV", "7", "8", "9", "MOD", "0", "POINT", "PERCENT", "EQUAL"};
        this.setButtonByKeyList(commonButtons, FontAndColours.BUTTON_HEIGHT);

        String[] scientificButtons = {"sin", "cos", "tan", "ln", "log", "ONE_OVER_N", "SQUARE", "CUBE", "SQRT", "EXIT"};
        this.setButtonByKeyList(scientificButtons, 6 * FontAndColours.BUTTON_HEIGHT);
        System.out.println(new Date()+"[ElementContainer][fixButtonsPlacement] Done!");
    }

    private void setButtonByKeyList(String[] buttonsKeys, int startY){
        int btnPerLine = FontAndColours.BUTTON_PER_LINE;
        int btnWidth = this.numPad.getWidth() / btnPerLine;
        int btnHeight = FontAndColours.BUTTON_HEIGHT;
        int extraBlock = this.totalExtraBlock(buttonsKeys.length, btnPerLine);

        int rowCounter = 0, colCounter = 0, counter = 0;
        for(String buttonKey: buttonsKeys){
            int x = colCounter * btnWidth, y = rowCounter * btnHeight + startY;


            if(buttonKey.equalsIgnoreCase("MOD") || buttonKey.equalsIgnoreCase("EQUAL")){
                this.numPad.add(this.map.get(buttonKey)).setBounds(x, y, btnWidth*2, btnHeight);
                counter +=2;
            }else{
                this.numPad.add(this.map.get(buttonKey)).setBounds(x, y, btnWidth, btnHeight);
                counter++;
            }
            rowCounter = counter % btnPerLine == 0 ? rowCounter + 1 : rowCounter;
            colCounter = counter % btnPerLine == 0 ? 0 : colCounter + 1;
        }
    }

    private int totalExtraBlock(int numberOfBtn, int btnPerLine){
        return numberOfBtn - (numberOfBtn % btnPerLine);
    }

    void setIcon(String iconPath){
        ImageIcon img = new ImageIcon(iconPath);
        this.setIconImage(img.getImage());
    }



}
