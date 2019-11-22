import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Operations {


    private static DataAccessObject dao = new DataAccessObject(); //for all calls to the database
    private static ResultSet daoRset = null; //used for all calls to executeSQLQuery()
    private static String rst; //used for all calls to processResultSet
    static Scanner input = new Scanner(System.in); //used for all user input
    private static int id = 0; //used for creating new HRIDs




    //helper methods for operations

                //sets the HRID to correspond to the next available HRID
                private static int getNextId(){
                    try {
                        daoRset = dao.executeSQLQuery("SELECT MAX(HRID) FROM HumResource"); //fetches current max HRID in the database
                        String HRIDMAX = dao.processResultSet(daoRset);


                        HRIDMAX = HRIDMAX.replaceAll(" ",""); //simplifies the String so it can be cast to int
                        HRIDMAX = HRIDMAX.replaceAll("\n","");


                        int max = Integer.parseInt(HRIDMAX); //casts the max HRID to a string


                        return max + 1; //returns next available HRID, one more than the current max

                    }catch(SQLException e){
                        System.out.println("Could not create new HRID");
                        return -1;
                    }
                }



                //shows all values in a given table
                public static void display(String type) {
                    try {
                        daoRset = dao.executeSQLQuery("select * from " + type); //fetches a table from the database
                        rst = dao.processResultSet(daoRset);


                        System.out.println(rst); //prints the table

                    } catch (SQLException e) {
                        System.out.println("Could not access database at this time");
                    }
                }



    //Always called
    //Parse which operation the user input and call the correct method
    public static void chooseOperation(String type, String operation) {
        try {
            dao.connect(); //connects to database in order to call the display method for delete and update
            dao.setAutoCommit(false); //disable auto commit for sake of transactions

            //Water
            if (type.toLowerCase().equals("water")) {
                if (operation.toLowerCase().equals("insert")) { //if insert

                    id = getNextId(); //generates next available HRID

                    insertWater(); //calls insert

                } else if (operation.toLowerCase().equals("update")) { //if update

                    System.out.println("\nColumns: | HRID | 10 oz Bottles | Half Liter Bottles | 5 Gallon Bottles |"); //displays necessary information to user
                    display("water");

                    updateWater(); //calls update

                } else if (operation.toLowerCase().equals("delete")) { //if delete

                    System.out.println("\nColumns: | HRID | 10 oz Bottles | Half Liter Bottles | 5 Gallon Bottles |"); //displays necessary information to user
                    display("water");

                    deleteWater(); //calls delete

                }




            //Food
            } else if (type.toLowerCase().equals("food")) {
                if (operation.toLowerCase().equals("insert")) { //if insert

                    id = getNextId(); //generates next available HRID

                    insertFood(); //calls insert

                } else if (operation.toLowerCase().equals("update")) { //if update

                    System.out.println("\nColumns: | HRID | Food Type | Food Meals Available | Food Description |"); //displays necessary information to user
                    display("food");

                    updateFood(); //calls update

                } else if (operation.toLowerCase().equals("delete")) { //if delete

                    System.out.println("\nColumns: | HRID | Food Type | Food Meals Available | Food Description |"); //displays necessary information to user
                    display("food");

                    deleteFood(); //calls delete

                }




            //Medical Center
            } else if (type.toLowerCase().equals("medical center")) {
                if (operation.toLowerCase().equals("insert")) { //if insert

                    id = getNextId(); //generates next available HRID

                    insertMedCenter(); //calls insert

                } else if (operation.toLowerCase().equals("update")) { //if update

                    System.out.println("\nColumns: | HRID | Number of Beds | Number of Emergency rooms | Number of Doctors | Number of Nurses |"); //displays necessary information to user
                    display("MedicalCenter");

                    updateMedCenter(); //calls update

                } else if (operation.toLowerCase().equals("delete")) { //if delete

                    System.out.println("\nColumns: | HRID | Number of Beds | Number of Emergency rooms | Number of Doctors | Number of Nurses |"); //displays necessary information to user
                    display("MedicalCenter");

                    deleteMedCenter(); //calls delete

                }
            }

        } catch (SQLException e) {
            System.out.println("could not connect to database.");
        }

        dao.disconnect(); //disconnects from database after every transaction

    }

//All nine operations plus two HumResource operations--------------------------------------------------------------------------------------------------------------------------------------------





                        //HumanResource ------------------------------------------------------------

                        //asks user for all required fields to construct a new HumResource instance
                        public static HumRes insertHumRes(String type) {

                            System.out.println("Enter name:"); //asks for and saves name
                            String name = input.nextLine();

                            System.out.println("Enter address:"); //asks for and saves the address
                            String addr = input.nextLine();

                            System.out.println("Enter phone number:"); //asks for and saves the phone number
                            String pNum = input.nextLine();

                            System.out.println("Enter latitude:"); //asks for and saves the latitude
                            double la = input.nextDouble();

                            System.out.println("Enter longitude:"); //asks for and saves the longitude
                            double lo = input.nextDouble();
                            input.nextLine();

                            System.out.println("Enter description:"); //asks for and saves the description
                            String des = input.nextLine();


                            System.out.println("Enter open hours:"); //asks for and saves the open hours
                            String openHr = input.nextLine();

                            return new HumRes(id, name, addr, pNum, la, lo, type, des, openHr); //creates and returns a new HumResource object
                        }


                        //deletes from the humResource table
                        public static void deleteHumRes(int dId) {
                            try {
                                dao.executeSQLNonQuery("DELETE FROM HumResource WHERE HRID = " + dId); //deletes a humResource table based on given HRID
                            } catch (SQLException e) {
                                System.out.println("Delete failed in HumResource\n");
                                dao.rollback();
                            }
                        }



                                    //Water------------------------------------------------------------------------------

                                    //asks user for all fields needed to create a water instance and inserts it to the database
                                    public static void insertWater() {

                                        HumRes hr = insertHumRes("Water"); //creates a parent object to inherit from

                                        System.out.println("Enter number for 10oz bottles:"); //asks for and saves the number of 10 oz
                                        int num1 = input.nextInt();

                                        System.out.println("Enter number for Half Liter bottles:"); //asks for and saves the number of half liter
                                        int num2 = input.nextInt();

                                        System.out.println("Enter number for 5 gallon bottles:"); //asks for and saves the number of 5 gallon
                                        int num3 = input.nextInt();
                                        input.nextLine();

                                        //creates a new water object using saved fields from this class and parent class
                                        Water water = new Water(hr.getHRId(), hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(), hr.getHROpenHoursStr(), num1, num2, num3);

                                        try {
                                            dao.executeSQLNonQuery("INSERT INTO HumResource VALUES (" + hr.toString() + ")"); //inserts the Parent HumResource instance

                                            dao.executeSQLNonQuery("INSERT INTO Water VALUES (" + water.toString() + ")"); //inserts the Water instance

                                            System.out.println("Insert successful\n");

                                            dao.commit();
                                        } catch (SQLException e) {
                                            System.out.println("SQL Query failed\n");
                                            dao.rollback();
                                        }
                                    }


                                    //allows user to update individual fields in a instance of water based on HRID and column number
                                    public static void updateWater() {

                                        System.out.println("Enter HRID which you would like to update:"); //asks for and saves HRID of instance to update
                                        int uId = input.nextInt();
                                        input.nextLine();

                                        try{
                                            //display the individual resource they wish to update
                                            System.out.println("\nColumns: | HRID | 1) 10 oz Bottles | 2) Half Liter Bottles | 3) 5 Gallon Bottles |");
                                            System.out.println(dao.processResultSet(dao.executeSQLQuery("SELECT * FROM Water WHERE HRID = " + uId)));

                                            //prompts for which column to update
                                            System.out.println("Select a column to update (1-3) :");
                                            int updateColumn = input.nextInt();
                                            input.nextLine();

                                            //ensures no out of bounds errors
                                            if(updateColumn <= 3 && updateColumn >= 1) {

                                                //creates the column name from the number and saves what the type of the value must be
                                                String valueType = "valueType";
                                                String column = "column";


                                                if (updateColumn == 1) {
                                                    column = "Num10OzBottlesAvailable";
                                                    valueType = "int";
                                                } else if (updateColumn == 2) {
                                                    column = "NumHalfLiterBottlesAvailable";
                                                    valueType = "int";
                                                } else if (updateColumn == 3) {
                                                    column = "Num5GallonJugsAvailable";
                                                    valueType = "int";
                                                }


                                                System.out.println("Enter new value: "); //asks for and saves the new value to be updated
                                                String value = input.nextLine();

                                                //makes the string readable by sql
                                                if(valueType.equals("String")){
                                                    value = "'" + value + "'";
                                                }

                                                dao.executeSQLNonQuery("UPDATE Water SET " + column + " = " + value + " WHERE HRID = " + uId); //updates database using gathered information

                                                System.out.println("Update successful\n");

                                                dao.commit();
                                            }else{
                                                System.out.println("Column number not available\n"); //entered column was out of range
                                            }


                                        }catch(SQLException e){
                                            System.out.println("Could not access Database\n");
                                            dao.rollback();
                                        }
                                    }


                                    //deletes an instance of water in database given its HRID
                                    public static void deleteWater() {

                                        System.out.println("Enter HRID that you want to delete:"); //asks for and saves HRID of instance to be deleted
                                        int dId = input.nextInt();
                                        input.nextLine();

                                        try {

                                            dao.executeSQLNonQuery("DELETE FROM Water WHERE HRID = " + dId); //deletes the water instance

                                            deleteHumRes(dId); //deletes the HumResource instance

                                            System.out.println("Delete succeeded in water\n");

                                            dao.commit();
                                        } catch (SQLException e) {
                                            System.out.println("SQL Query failed\n");
                                            dao.rollback();
                                        }
                                    }





                                    //Food-----------------------------------------------------------------


                                    //asks user for all fields needed to create a food instance and inserts it to the database
                                    public static void insertFood() {

                                        HumRes hr = insertHumRes("Food"); //creates parent HumResource object

                                        System.out.println("Enter food type:"); //asks for and saves food type
                                        String Ftype = input.next();

                                        System.out.println("Enter number of food meals available:"); //asks for and saves available meals
                                        int FMealsAva = input.nextInt();
                                        input.nextLine();

                                        System.out.println("Enter food specific description:"); //asks for and saves food description
                                        String Fdesc = input.nextLine();

                                        Food food = new Food(hr.getHRId(), hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(), hr.getHROpenHoursStr(), Ftype, FMealsAva, Fdesc); //creates new food object with all given information

                                        try {

                                            dao.executeSQLNonQuery("INSERT INTO HumResource VALUES (" + hr.toString() + ")"); //inserts Parent HumResource instance into database

                                            dao.executeSQLNonQuery("INSERT INTO Food VALUES (" + food.toString() + ")"); //inserts Food instance into database

                                            System.out.println("Insert successful\n");

                                            dao.commit();
                                        } catch (SQLException e) {
                                            System.out.println("SQL Query failed\n");
                                            dao.rollback();
                                        }
                                    }


                                    public static void updateFood() {

                                        System.out.println("Enter HRID which you would like to update:"); //asks for and saves HRID of instance to update
                                        int uId = input.nextInt();
                                        input.nextLine();

                                        try{
                                            //display the individual resource they wish to update
                                            System.out.println("\nColumns: | HRID | 1) Food Type | 2) Food Meals Available | 3) Food Description |");
                                            System.out.println(dao.processResultSet(dao.executeSQLQuery("SELECT * FROM Food WHERE HRID = " + uId)));

                                            //prompts for which column to update
                                            System.out.println("Select a column to update (1-3) :");
                                            int updateColumn = input.nextInt();
                                            input.nextLine();

                                            //ensures no out of bounds errors
                                            if(updateColumn <= 3 && updateColumn >= 1) {

                                                //creates the column name from the number and saves what the type of the value must be
                                                String valueType = "valueType";
                                                String column = "column";


                                                if (updateColumn == 1) {
                                                    column = "FType";
                                                    valueType = "String";
                                                } else if (updateColumn == 2) {
                                                    column = "FMealsAvailable";
                                                    valueType = "int";
                                                } else if (updateColumn == 3) {
                                                    column = "FSpecificDesc";
                                                    valueType = "String";
                                                }


                                                System.out.println("Enter new value: ");
                                                String value = input.nextLine(); //new updated value

                                                //makes the string readable by sql
                                                if(valueType.equals("String")){
                                                    value = "'" + value + "'";
                                                }

                                                dao.executeSQLNonQuery("UPDATE Food SET " + column + " = " + value + " WHERE HRID = " + uId); //updates a field in a food instance in the database

                                                System.out.println("Update successful\n");

                                                dao.commit();
                                            }else{
                                                System.out.println("Column number not available\n"); //entered column was out of range
                                            }


                                        }catch(SQLException e){
                                            System.out.println("Could not access Database\n");
                                            dao.rollback();
                                        }
                                    }

                                    public static void deleteFood() {

                                        System.out.println("Enter HRID that you want to delete:"); //asks for and saves HRID of Food instance to be deleted
                                        int dId = input.nextInt();
                                        input.nextLine();

                                        try {

                                            dao.executeSQLNonQuery("DELETE FROM FOOD WHERE HRID = " + dId); //deletes instance of food in database based on HRID

                                            deleteHumRes(dId); //deletes the human resource instance in the database

                                            System.out.println("Delete succeeded\n");

                                            dao.commit();
                                        } catch (SQLException e) {
                                            System.out.println("SQL Query failed\n");
                                            dao.rollback();
                                        }
                                    }








                                    //MedicalCenter-----------------------------------------------------------------------

                                    //asks user for all fields needed to create a Medical Center instance and inserts it to the database
                                    public static void insertMedCenter() {

                                        HumRes hr = insertHumRes("MedicalCenter"); //creates a Parent HumResource Object

                                        System.out.println("Enter number of beds: "); //asks for and saves the number of beds
                                        int beds = input.nextInt();

                                        System.out.println("Enter number of Emergency room:"); //asks for and saves the number of emergency rooms
                                        int rooms = input.nextInt();

                                        System.out.println("Enter number of doctors:"); //asks for and saves the number of doctors
                                        int doctors = input.nextInt();

                                        System.out.println("Enter number of nurses:"); //asks for and saves the number of nurses
                                        int nurses = input.nextInt();

                                        //creates a medical center object using all of the given field data
                                        MedicalCenter mc = new MedicalCenter(hr.getHRId(), hr.getHRName(), hr.getHRAddrStr(), hr.getHRPhoneNum(), hr.getHRLatitude(), hr.getHRLongitude(), hr.getHRType(), hr.getHRDesc(), hr.getHROpenHoursStr(), beds, rooms, doctors, nurses);

                                        try {

                                            dao.executeSQLNonQuery("INSERT INTO HumResource VALUES (" + hr.toString() + ")"); //inserts Parent HumResource instance into database

                                            dao.executeSQLNonQuery("INSERT INTO MedicalCenter VALUES (" + mc.toString() + ")"); //inserts medical center instance into database

                                            System.out.println("Insert successful\n");

                                            dao.commit();
                                        } catch (SQLException e) {
                                            System.out.println("SQL Query failed\n");
                                            dao.rollback();
                                        }
                                    }

                                    //call to update a field in medical center
                                    public static void updateMedCenter() {

                                        System.out.println("Enter HRID which you would like to update:"); //asks for and saves the HRID for the medical center instance to be updated
                                        int uId = input.nextInt();
                                        input.nextLine();

                                        try{
                                            //display the individual resource they wish to update
                                            System.out.println("\nColumns: | HRID | 1) Number of Beds | 2) Number of Emergency rooms | 3) Number of Doctors | 4) Number of Nurses |");
                                            System.out.println(dao.processResultSet(dao.executeSQLQuery("SELECT * FROM MedicalCenter WHERE HRID = " + uId)));

                                            //prompts for which column to update
                                            System.out.println("Select a column to update (1-4) :");
                                            int updateColumn = input.nextInt();
                                            input.nextLine();

                                            if(updateColumn <= 4 && updateColumn >= 1) {

                                                //creates the column name from the number and saves what the type of the value must be
                                                String valueType = "valueType";
                                                String column = "column";


                                                //ensures no index out of bounds errors
                                                if (updateColumn == 1) {
                                                    column = "NumBeds";
                                                    valueType = "int";
                                                } else if (updateColumn == 2) {
                                                    column = "EmergencyRoomCapacity";
                                                    valueType = "int";
                                                } else if (updateColumn == 3) {
                                                    column = "NumDoctors";
                                                    valueType = "int";
                                                } else if (updateColumn == 4) {
                                                    column = "NumNurses";
                                                    valueType = "int";
                                                }


                                                System.out.println("Enter new value: "); //asks for and saves the updated value
                                                String value = input.nextLine();

                                                //makes the string readable by sql
                                                if(valueType.equals("String")){
                                                    value = "'" + value + "'";
                                                }

                                                dao.executeSQLNonQuery("UPDATE MedicalCenter SET " + column + " = " + value + " WHERE HRID = " + uId); //updates given column of given row in database using the new value

                                                System.out.println("Update successful\n");

                                                dao.commit();
                                            }else{
                                                System.out.println("Column number not available\n"); //entered column was out of range
                                            }


                                        }catch(SQLException e){
                                            System.out.println("Could not access Database\n");
                                            dao.rollback();
                                        }
                                    }


                                    //call to delete a row in medical center
                                    public static void deleteMedCenter() {

                                        System.out.println("Enter HRID that you want to delete:"); //asks for and saves the HRID for the medical center instance to delete
                                        int dId = input.nextInt();
                                        input.nextLine();

                                        try {
                                            dao.executeSQLNonQuery("DELETE FROM MedicalCenter WHERE HRID = " + dId); //deletes the medical center instance in database

                                            deleteHumRes(dId); //deletes the HumResource instance in database

                                            System.out.println("Delete succeeded\n");

                                            dao.commit();
                                        } catch (SQLException e) {
                                            System.out.println("SQL Query failed\n");
                                            dao.rollback();
                                        }
                                    }
}