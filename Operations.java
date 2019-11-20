package Assignment3;

import java.util.Scanner;

public class Operations {


    private static DataAccessObject dao;
    static Scanner input = new Scanner(System.in);
    private static int id = 1009;

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


    //HumanResource
    public static HumRes insertHumRes(){
        HumRes hr = new HumRes();


        hr.setHRId(id++);
        System.out.println("Enter name:");
        String name = input.nextLine();
        hr.setHRName(name);

        System.out.println("Enter address:");
        String addr = input.nextLine();
        hr.setHRAddrStr(addr);

        System.out.println("Enter phone number:");
        String pNum = input.nextLine();
        hr.setHRPhoneNum(pNum);

        System.out.println("Enter latitude:");
        double la = input.nextDouble();
        hr.setHRLatitude(la);

        System.out.println("Enter longitude:");
        double lo = input.nextDouble();
        hr.setHRLongitude(lo);

        System.out.println("Enter type:");
        String type = input.next();
        hr.setHRType(type);

        System.out.println("Enter description:");
        String des = input.nextLine();
        hr.setHRDesc(des);

        System.out.println("Enter open hours:");
        String openHr =  input.nextLine();
        hr.setHROpenHoursStr(openHr);

        return hr;
    }

    public static void updateHumRes(){

    }

    public static void deleteHumRes(){

    }

    //Water
    public static void insertWater(){
        HumRes hr = new HumRes();



    }

    public static void updateWater(){

    }

    public static void deleteWater(){

    }



    //Food
    public static void insertFood(){
        HumRes hr = insertHumRes();
        int id = hr.getHRId();
        System.out.println("Enter food type:");
        String Ftype = input.next();
        System.out.println("Enter number of food meals available:");
        int FMealsAva = input.nextInt();
        System.out.println("Enter food specific description:");
        String Fdesc = input.nextLine();
        Food food = new Food(hr.getHRId(),hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(),hr.getHROpenHoursStr(), Ftype, FMealsAva, Fdesc);
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
