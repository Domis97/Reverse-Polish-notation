package zad1;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {
        CheckClass checkClass = new CheckClass();

        Scanner in = new Scanner(System.in);

        for(int i = 2;i>0;i++) {

            System.out.print("Dzialanie:");

            String input1 = in.nextLine();

            String result = checkClass.checkStart(input1);

            System.out.println("* " + result + " *");
        }

    }
}
