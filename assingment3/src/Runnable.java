import java.util.Scanner;

public class Runnable {
    static Scanner input1 = new Scanner(System.in); //input for first query
    static Scanner input2 = new Scanner(System.in); //input for second query

    public static void runLoop(){

        System.out.println("To stop the program, enter \"exit\" for Operation type.");

        boolean loopBool = true; //boolean loop variable

        while(loopBool){

            String type = firstQuery(); //asks first question and saves answer

            String operation = secondQuery(); //asks second question and saves answer

            if(operation.equals("exit")){
                loopBool = false; //exits loop using loop boolean when user types "exit"
            }

            Operations.chooseOperation(type, operation); //calls the operation parser using the two saved answers
        }
    }

    //asks for and returns a resource type
    public static String firstQuery(){
        System.out.print("Human Resource Type (Food, Water, Medical Center) : ");
        return input1.nextLine();
    }
    //asks for and returns a operation type
    public static String secondQuery(){
        System.out.print("Operation type (Insert, Update, Delete) : ");
        return input2.next();
    }

}