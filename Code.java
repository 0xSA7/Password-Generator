import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class Code extends JFrame implements  ActionListener{
    JButton enterButton;
    JTextField passwordLengthInput;
    JLabel enterLabel,out,passwordLabel;
    public Code(){
        this.setLocationRelativeTo(null);
        this.setTitle("Password Generator SA7-addition");
        this.setSize(400,300);
        Image image=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("icon.png"))).getImage();
        this.setIconImage(image);
        enterButton = new JButton("Generate");
        enterButton.addActionListener(this);
        enterLabel = new JLabel("Enter number of digits for your password");
        passwordLabel = new JLabel("");
        out= new JLabel("Your Password is: ");
        passwordLengthInput = new JTextField("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.add(enterLabel);
        this.add(enterButton);
        this.add(out);
        this.add(passwordLengthInput);
        this.add(passwordLabel);
        enterLabel.setBounds(10,10,350,50);
        enterButton.setBounds(250,60,100,30);
        passwordLengthInput.setBounds(10,50,230,50);
        out.setBounds(10,100,150,20);
        passwordLabel.setBounds(0,120,385,142);
        passwordLengthInput.setBackground(Color.CYAN);
        passwordLabel.setBackground(Color.GRAY);
    }
    public char[] getPassword(){
        try {
            int digit= Integer.valueOf(passwordLengthInput.getText());
            String lowerCases="qwertyuiopasdfghjklzxcvbnm";
            String upperCases="QWERTYUIOPASDFGHJKLZXCVBNM";
            String num ="0123456789";
            String symbols="~!@#$%^&*()_+{}[]|/;:'?>.<,";
            String allCharacters= symbols+lowerCases+upperCases+num;
            char[] password=new char[digit];
            Random random =new Random();
            for (int i=0;i<digit;i++){
                int allCharactersLength = allCharacters.length();
                int randomNumber = random.nextInt(allCharactersLength);
                password[i]=allCharacters.charAt(randomNumber);
            }
            return password;
        } catch (NumberFormatException e) {
            return null;
        }

    }
    public String getPasswordStringValue(char[] password){
        if (password != null ) {
            return new String(password);
        } else {
            return  "دخل رقم يا غبي";
        }
        //return password != null ? new String( password ) : "دخل رقم يا غبي";
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        char[] passwordAsCharArray = this.getPassword();
        String  password = this.getPasswordStringValue(passwordAsCharArray);
        passwordLabel.setText(password);
        passwordLengthInput.setEditable(true);
    }

}
