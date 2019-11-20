package Assignment3;

public class Water extends HumRes {
    private int num10OzAva;
    private int numHelfLAva;
    private int num5GAva;

    public Water(){
        this.num10OzAva = 0;
        this.numHelfLAva = 0;
        this.num5GAva = 0;
    }

    public Water(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr,int num10OzAva, int numHelfLAva, int num5GAva){
        super(HRId,HRName, HRAddrStr, HRPhoneNum, HRLatitude, HRLongitude, HRType, HRDesc,HROpenHoursStr);
        this.num10OzAva = num10OzAva;
        this.numHelfLAva = numHelfLAva;
        this.num5GAva = num5GAva;
    }


    public int getNum10OzAva() {
        return num10OzAva;
    }

    public void setNum10OzAva(int num10OzAva) {
        this.num10OzAva = num10OzAva;
    }

    public int getNumHelfLAva() {
        return numHelfLAva;
    }

    public void setNumHelfLAva(int numHelfLAva) {
        this.numHelfLAva = numHelfLAva;
    }

    public int getNum5GAva() {
        return num5GAva;
    }

    public void setNum5GAva(int num5GAva) {
        this.num5GAva = num5GAva;
    }

    public String toString(){
            return getHRId() + ", " + getNum10OzAva() + ", "+ getNumHelfLAva() + ", " + getNum5GAva();
    }
}

