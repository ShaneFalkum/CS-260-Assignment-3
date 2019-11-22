public class Food extends HumRes{
    private String FType; //food type
    private int FMealsAva; //number of meals available
    private String FDec; //food description



    //blank food constructor
    public Food(){
        this.FType = "";
        this.FMealsAva = 0;
        this.FDec = "";
    }


    //full food constructor
    public Food(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr, String FType, int FMealsAva, String FDec){
        super(HRId,HRName, HRAddrStr, HRPhoneNum, HRLatitude, HRLongitude, HRType, HRDesc,HROpenHoursStr);
        this.FType = FType;
        this.FMealsAva = FMealsAva;
        this.FDec = FDec;
    }



    //get and set food type
    public String getFType() {
        return FType;
    }

    public void setFType(String FType) {
        this.FType = FType;
    }




    //get and set meals available
    public int getFMealsAva() {
        return FMealsAva;
    }

    public void setFMealsAva(int FMealsAva) {
        this.FMealsAva = FMealsAva;
    }


    //get and set food description
    public String getFDec() {
        return FDec;
    }

    public void setFDec(String FDec) {
        this.FDec = FDec;
    }


    //creates a string for use in sql queries
    public String toString(){
        return getHRId() + ", '" + getFType() + "'," + getFMealsAva() +  ", '" + getFDec()  + "'";
    }
}