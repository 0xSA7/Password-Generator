
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class Code extends JFrame implements ActionListener {

    JButton enterButton;                 //declaration of Generate button
    JTextField passwordLengthInput;      //declaration of cell of the password digit
    JLabel entryLabel, out, passwordLabel; //declaration of labels

    public Code() {
        this.setTitle("Password Generator SA7-addition");            //name of the app
        this.setSize(400, 300);                                 //diminutions of the app window
        Image image = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("icon.png"))).getImage(); //decelerate app icon
        this.setIconImage(image);                                                          // use it
        enterButton = new JButton("Generate");                                        //name of the button
        enterButton.addActionListener(this);                                           //action of the button
        entryLabel = new JLabel("Enter number of digits for your password");        //name of the entry label
        passwordLabel = new JLabel("");                                            //initialisation of password
        out = new JLabel("Your Password is: ");                                   // name of the label
        passwordLengthInput = new JTextField("");                                    //empty text filed for user to write rhe digits
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                        // when the user hit Close icon what should happen
        this.setVisible(true);                                                     // making the app visible for user
        this.setResizable(false);                                                 // user can't change diminutions of the app (14)
        this.setLayout(null);                                                    // how the buttons ,labels and text fields will be designed
        this.add(entryLabel);                                                   // adding the label to the visible app
        this.add(enterButton);                                                 // adding the button to the visible app
        this.add(out);                                                        // adding the label to the visible app
        this.add(passwordLengthInput);                                       // adding the Text failed to the visible app
        this.add(passwordLabel);                                            // adding the label to the visible app
        this.setLocationRelativeTo(null);                                  // When you run it the app window will appear at the center of the screen
        entryLabel.setBounds(10, 10, 350, 50);           // setting the location of the label
        enterButton.setBounds(250, 60, 100, 30);        // setting the location of the button
        passwordLengthInput.setBounds(10, 50, 230, 50);// setting the location of the Text field
        out.setBounds(10, 100, 150, 20);              // setting the location of the label
        passwordLabel.setBounds(5, 120, 385, 142);   // setting the location of the label
        passwordLengthInput.setBackground(Color.CYAN);                // setting the background of the label
        passwordLabel.setBackground(Color.GRAY);                     // setting the location of the label
    }

    public char[] getPassword() {                                     //in this method we generate the password as a char[]
        try {                                                        //we use try and catch to avoid any input except int num
            int digit = Integer.valueOf(passwordLengthInput.getText());
            /* get the input from user as text and casting it into int
            if the text is only int num valueOf function will be casting it into an int variable called digit
            else valueOf function will throw it away and ignore it */
            String lowerCases = "qwertyuiopasdfghjklzxcvbnm"; // all lowerCases
            String upperCases = "QWERTYUIOPASDFGHJKLZXCVBNM";// all upperCases
            String num = "0123456789";                      // all num
            String symbols = "!@#$%&*_+-/";                // some symbols most often used in passwords
            String allCharacters = symbols + lowerCases + upperCases + num;    //All possible password characters
            char[] password = new char[digit];
            // creating a password char [] variable
            Random random = new Random();
            // a new object frm class Random
            for (int i = 0; i < digit; i++) {                  //making password digits equal to the user input
                int allCharactersLength = allCharacters.length();
                // countering from q to / and store the result in allCharacterLength variable
                int randomNumber = random.nextInt(allCharactersLength);
                //pick a random int num form zero to allCharacterLength and store it at randomNumber variable
                password[i] = allCharacters.charAt(randomNumber);
                //go to get the character that stored in index of randomNumber at allCharacters variable then store it in the password char [] variable
            }
            return password;
        } catch (NumberFormatException e) {                   //the thrown input from valueOf will be continued from the catch
            return null;
        }

    }

    public String getPasswordStringValue(char[] password) {          //checking if the returned password is String
        if (password != null) {
            return new String(password);
        } else {
            return "Please enter A valid number";
        }
        //return password != null ? new String( password ) : "دخل رقم يا غبي";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] passwordAsCharArray = this.getPassword();
        //password as char[]
        String password = this.getPasswordStringValue(passwordAsCharArray);
        // casting it to string to return it in the label
        passwordLabel.setText(password);     // show the use the password
        passwordLengthInput.setEditable(true);  //user can use the app many times at one opening
    }

}
public class Main {

    public static void main(String[]args){
        new Code();
    }
}
