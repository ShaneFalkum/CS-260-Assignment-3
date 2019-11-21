import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {


    private static DataAccessObject dao = new DataAccessObject();
    private static ResultSet daoRset = null;
    private static String rst;
    static Scanner input = new Scanner(System.in);
    private static int id = 1009;

    public static void chooseOperation(String type, String operation){
        try {
            dao.connect();
            dao.setAutoCommit(false);

            if (type.toLowerCase().equals("water")) {
                if (operation.toLowerCase().equals("insert")) {
                    insertWater();
                } else if (operation.toLowerCase().equals("update")) {
                    display("water");
                    updateWater();
                } else if (operation.toLowerCase().equals("delete")) {
                    display("water");
                    deleteWater();
                }
            } else if (type.toLowerCase().equals("food")) {
                if (operation.toLowerCase().equals("insert")) {
                    insertFood();
                } else if (operation.toLowerCase().equals("update")) {
                    display("food");
                    updateFood();
                } else if (operation.toLowerCase().equals("delete")) {
                    display("food");
                    deleteFood();
                }
            } else if (type.toLowerCase().equals("medical center")) {
                if (operation.toLowerCase().equals("insert")) {
                    insertMedCenter();
                } else if (operation.toLowerCase().equals("update")) {
                    display("MedicalCenter");
                    updateMedCenter();
                } else if (operation.toLowerCase().equals("delete")) {
                    display("MedicalCenter");
                    deleteMedCenter();
                }
            }
        }catch(SQLException e){
            System.out.println("could not connect to database.");
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
        input.nextLine();

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

    public static void display(String type){
//        try {
//            // get the database
//            daoRset = dao.executeSQLQuery("SELECT * FROM Food");
//            rst = dao.processResultSet(daoRset);
//
//            System.out.println("Display table from " + type + ":\n" + rst);
//        } catch (SQLException e) {
//            System.out.println("Error");
//        }
        try{
            daoRset = dao.executeSQLQuery("select * from " + type);
            rst = dao.processResultSet(daoRset);
            System.out.println("results in " + type);
            System.out.println(rst);
        }catch(SQLException e){
            System.out.println("Could not access database at this time");
        }
    } //Water
    public static void insertWater(){
        HumRes hr = insertHumRes();
        System.out.println("Enter number for 10oz bottle:");
        int num1 = input.nextInt();
        System.out.println("Enter number for Half Liter bottle:");
        int num2 = input.nextInt();
        System.out.println("Enter number for 5 gallon bottle:");
        int num3 = input.nextInt();
        input.nextLine();
        Water water = new Water(hr.getHRId(),hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(),hr.getHROpenHoursStr(), num1,num2,num3);
        try {
            dao.executeSQLNonQuery("INSERT INTO HumResource VALUES (" + hr.toString() +")");
            dao.executeSQLNonQuery("INSERT INTO Water VALUES (" + water.toString() + ")");
            dao.commit();
        }catch(SQLException e){
            System.out.println("SQL Query failed");
            dao.rollback();
        }
        dao.disconnect();
    }

    public static void updateWater(){

    }

    public static void deleteWater(){


    }//Food
    public static void insertFood(){
        HumRes hr = insertHumRes();
        System.out.println("Enter food type:");
        String Ftype = input.next();
        System.out.println("Enter number of food meals available:");
        int FMealsAva = input.nextInt();
        input.nextLine();
        System.out.println("Enter food specific description:");
        String Fdesc = input.nextLine();

        Food food = new Food(hr.getHRId(),hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(),hr.getHROpenHoursStr(), Ftype, FMealsAva, Fdesc);
        try {
            dao.executeSQLNonQuery("INSERT INTO HumResource VALUES (" + hr.toString() +")");
            dao.executeSQLNonQuery("INSERT INTO Food VALUES (" + food.toString() + ")");
            dao.commit();
        }catch(SQLException e){
            System.out.println("SQL Query failed");
            dao.rollback();
        }
        dao.disconnect();
    }


    public static void updateFood(){

    }

    public static void deleteFood(){
        //display data in  human resource
        deleteHumRes();
    }



    //MedicalCenter
    public static void insertMedCenter(){
        HumRes hr = insertHumRes();
        System.out.println("Enter number of beds: ");
        int beds = input.nextInt();
        System.out.println("Enter number of Emergency room:");
        int rooms = input.nextInt();
        System.out.println("Enter number of doctors:");
        int doctors = input.nextInt();
        System.out.println("Enter number of nurses:");
        int nurses = input.nextInt();
        MedicalCenter mc = new MedicalCenter(hr.getHRId(),hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(),hr.getHROpenHoursStr(), beds,rooms,doctors,nurses);
        try {
            dao.executeSQLNonQuery("INSERT INTO HumResource VALUES (" + hr.toString() +")");
            dao.executeSQLNonQuery("INSERT INTO MedicalCenter VALUES (" + mc.toString() + ")");
            dao.commit();
        }catch(SQLException e){
            System.out.println("SQL Query failed");
            dao.rollback();
        }
        dao.disconnect();
    }

    public static void updateMedCenter(){

    }

    public static void deleteMedCenter(){

    }
}
