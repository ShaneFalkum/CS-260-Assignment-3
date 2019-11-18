public class Operations {


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

            //Water
            public static void insertWater(){

            }

            public static void updateWater(){

            }

            public static void deleteWater(){

            }



            //Food
            public static void insertFood(){

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
