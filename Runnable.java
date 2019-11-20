package Assignment3;

import java.util.Scanner;

public class Runnable {
    static Scanner input1 = new Scanner(System.in);
    static Scanner input2 = new Scanner(System.in);

    public static void runLoop(){

        System.out.println("To stop the program, enter \"exit\" for Operation type.");

        boolean loopBool = true;

        while(loopBool == true){

            String type = firstQuery();

            String operation = secondQuery();

            if(operation.equals("exit")){
                loopBool = false;
            }

            Operations.chooseOperation(type, operation);
        }
    }


    public static String firstQuery(){
        System.out.print("Human Resource Type (Food, Water, Medical Center) : ");
        return input1.nextLine();
    }

    public static String secondQuery(){
        System.out.print("Operation type (Insert, Update, Delete) : ");
        return input2.next();
    }

}
