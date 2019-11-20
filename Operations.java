package Assignment3;

import java.util.Scanner;

public class Operations {


    private static DataAccessObject dao;

    public static void chooseOperation(String type, String operation){
        if(type.toLowerCase().equals("water")){
            if(operation.toLowerCase().equals("insert")){
                insertWater();
            }
            else if(operation.toLowerCase().equals("update")){
                updateWater();
            }
            else if(operation.toLowerCase().equals("delete")){
                deleteWater();
            }
        }
        else if(type.toLowerCase().equals("food")){
            if(operation.toLowerCase().equals("insert")){
                insertFood();
            }
            else if(operation.toLowerCase().equals("update")){
                updateFood();
            }
            else if(operation.toLowerCase().equals("delete")){
                deleteFood();
            }
        }
        else if(type.toLowerCase().equals("medical center")){
            if(operation.toLowerCase().equals("insert")){
                insertMedCenter();
            }
            else if(operation.toLowerCase().equals("update")){
                updateMedCenter();
            }
            else if(operation.toLowerCase().equals("delete")){
                deleteMedCenter();
            }
        }

    }
    static Scanner input = new Scanner(System.in);



    //Water
    public static void insertWater(){



    }

    public static void updateWater(){

    }

    public static void deleteWater(){

    }



    //Food
    public static void insertFood(){
        Food food = new Food();
        System.out.println("Enter HRId:");
        int id = input.nextInt();
        food.setHRId(id);
        System.out.println("Enter food type:");
        String Ftype = input.next();
        food.setFType(Ftype);
        System.out.println("Enter number of food meals available:");
        int FMealsAva = input.nextInt();
        food.setFMealsAva(FMealsAva);
        System.out.println("Enter food specific description:");
        String Fdesc = input.nextLine();
        food.setFDec(Fdesc);
        dao.executeSQLNonQuery("INSERT INTO Food VALUES(" + food.toString() + ")");
    }

    public static void updateFood(){

    }

    public static void deleteFood(){

    }



    //MedicalCenter
    public static void insertMedCenter(){

    }

    public static void updateMedCenter(){

    }

    public static void deleteMedCenter(){

    }
}