import java.util.Random;
import java.util.Scanner;

public class Code {
    static Scanner input =new Scanner(System.in);

    public static void main(String[]args){
        Frame frame=new Frame();
        System.out.println("Enter number of digits");
        int digit=input.nextInt();
        String lower_cases="qwertyuiopasdfghjklzxcvbnm";
        String upper_cases="QWERTYUIOPASDFGHJKLZXCVBNM";
        String num ="0123456789";
        String symbols="~!@#$%^&*()_+{}[]|/;:'?>.<,";
        String mix= symbols+lower_cases+upper_cases+num;
        char[] password=new char[digit];
        Random random =new Random();
        for (int i=0;i<digit;i++){
            password[i]=mix.charAt(random.nextInt(mix.length()));
        }
        System.out.print("Your password is: ");
        System.out.println(password);
    }
    }
