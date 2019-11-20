package Assignment3;

public class Food extends HumRes{
    private String FType;
    private int FMealsAva;
    private String FDec;

    public Food(){
        this.FType = "";
        this.FMealsAva = 0;
        this.FDec = "";
    }

    public Food(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr, String FType, int FMealsAva, String FDec){
            super(HRId,HRName, HRAddrStr, HRPhoneNum, HRLatitude, HRLongitude, HRType, HRDesc,HROpenHoursStr);
            this.FType = FType;
            this.FMealsAva = FMealsAva;
            this.FDec = FDec;
    }

    public String getFType() {
        return FType;
    }

    public void setFType(String FType) {
        this.FType = FType;
    }

    public int getFMealsAva() {
        return FMealsAva;
    }

    public void setFMealsAva(int FMealsAva) {
        this.FMealsAva = FMealsAva;
    }

    public String getFDec() {
        return FDec;
    }

    public void setFDec(String FDec) {
        this.FDec = FDec;
    }

    public String toString(){
            return getHRId() + ", '" + getFType() + "'," + getFMealsAva() +  ", '" + getFDec()  + "',";
    }
}
