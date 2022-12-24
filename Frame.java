import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener, ActionListener{
    JButton EnterButton;
    JTextField input,password;
    JLabel EnterLabel,out;
    public  Frame(){
        this.setTitle("Password Generator SA7-addition");
        this.setSize(400,300);
        Image image=new ImageIcon(this.getClass().getResource("logo.png")).getImage();
        this.setIconImage(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        EnterButton = new JButton("Enter");
        EnterButton.addActionListener(this);
        EnterLabel= new JLabel("Enter number of digits for your password");
        password= new JTextField("");
        out= new JLabel("Your Password is:  ");
        input= new JTextField("");
        this.add(EnterLabel);
        this.add(EnterButton);
        this.add(out);
        this.add(input);
        this.add(password);
        EnterLabel.setBounds(10,10,350,50);
        EnterButton.setBounds(250,60,100,30);
        input.setBounds(10,50,230,50);
        out.setBounds(10,100,150,20);
        password.setBounds(0,120,385,142);
        input.setBackground(Color.CYAN);
        password.setBackground(Color.GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        password.setText(input.getText());
        input.setEditable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public JTextField getPassword(){
        return password;
    }
}
