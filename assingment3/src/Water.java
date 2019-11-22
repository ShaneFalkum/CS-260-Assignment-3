public class Water extends HumRes {
    private int num10OzAva; //number of 10 oz
    private int numHelfLAva; //number of half liter
    private int num5GAva; //number of 5 gallon


    //blank water constructor
    public Water(){
        this.num10OzAva = 0;
        this.numHelfLAva = 0;
        this.num5GAva = 0;
    }


    //full water constructor
    public Water(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr,int num10OzAva, int numHelfLAva, int num5GAva){
        super(HRId,HRName, HRAddrStr, HRPhoneNum, HRLatitude, HRLongitude, HRType, HRDesc,HROpenHoursStr);
        this.num10OzAva = num10OzAva;
        this.numHelfLAva = numHelfLAva;
        this.num5GAva = num5GAva;
    }



    //get and set 10 oz
    public int getNum10OzAva() {
        return num10OzAva;
    }

    public void setNum10OzAva(int num10OzAva) {
        this.num10OzAva = num10OzAva;
    }



    //get and set half liter
    public int getNumHelfLAva() {
        return numHelfLAva;
    }

    public void setNumHelfLAva(int numHelfLAva) {
        this.numHelfLAva = numHelfLAva;
    }



    //get and set 5 gallon
    public int getNum5GAva() {
        return num5GAva;
    }

    public void setNum5GAva(int num5GAva) {
        this.num5GAva = num5GAva;
    }



    //toString for making sql queries
    public String toString(){
        return getHRId() + ", " + getNum10OzAva() + ", "+ getNumHelfLAva() + ", " + getNum5GAva();
    }
}
