import javax.management.StringValueExp;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner check = new Scanner(System.in);
        int counter = 0;
        int winner = 0;
        int number = 0;


        while(winner == 0) {
            System.out.println("Iveskite bilieto numeri ...");
            number = check.nextInt();
            if (isValid(number) == false ){
                System.out.println("Blogai ivestas bilieto numeris, bandyk dar karta.");
            }
            else if (isWinner(number) == false){
                System.out.println("Bilietas nebuvo laimingas.");
                counter++;
            }
            else if (isWinner(number) == true){
                counter++;
                System.out.println("Sveikiname jus laimejote! Prireke tik: " + counter + " bandymu");
                winner ++;
            }
            else {
                System.out.println("ERROR 404;");
            }


        }
        }


    public static boolean isValid(int data) {

        String temp = Integer.toString(data);
        if (temp.length() != 6){
            return false;
        }

        boolean[] tested = new boolean[10];

        for (int i =0; i < temp.length(); i++) {
            char digitChar = temp.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            if (tested[digit]) {
                return false;
            }
            tested[digit] = true;
        }
        return true;
    }

    public static boolean isWinner(int data){
        String temp = Integer.toString(data);
        String first = temp.substring(0, 3);
        String last = temp.substring(3, 6);
        int sumOne = 0;
        int sumTwo = 0;
        for (int i = 0; i < 3; i++) {
            sumOne += Character.getNumericValue(first.charAt(i));
            sumTwo += Character.getNumericValue(last.charAt(i));
        }
        return sumOne == sumTwo;
    }
}




