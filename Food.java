package Assignment3;

public class Food extends HumRes{
    private int HRId;
    private String FType;
    private int FMealsAva;
    private String FDec;

    public Food(){
        this.HRId = 0;
        this.FType = "";
        this.FMealsAva = 0;
        this.FDec = "";
    }

    public Food(int HRId, String FType, int FMealsAva, String FDec){
            this.HRId = HRId;
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

    public boolean equals(Object object){
            if(object instanceof Food){
                    Food food = (Food) object;
                    return food.getHRId() == this.getHRId();
            }
            return false;
    }

}
