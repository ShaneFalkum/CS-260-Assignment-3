public class HumRes {
    private int HRId;
    private String HRName;
    private String HRAddrStr;
    private String HRPhoneNum;
    private double HRLatitude;
    private double HRLongitude;
    private String HRType;
    private String HRDesc;
    private String HROpenHoursStr;



    public HumRes(){
        this.HRId = 0;
        this.HRName = "";
        this.HRAddrStr = "";
        this.HRPhoneNum = "";
        this.HRLatitude = 0;
        this.HRLongitude = 0;
        this.HRType = "";
        this.HRDesc = "";
        this.HROpenHoursStr = "";

    }

    public HumRes(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr){
        this.HRId = HRId;
        this.HRName = HRName;
        this.HRAddrStr = HRAddrStr;
        this.HRPhoneNum = HRPhoneNum;
        this.HRLatitude = HRLatitude;
        this.HRLongitude = HRLongitude;
        this.HRType = HRType;
        this.HRDesc = HRDesc;
        this.HROpenHoursStr = HROpenHoursStr;
    }

    public int getHRId() {
        return HRId;
    }

    public void setHRId(int HRId) {
        this.HRId = HRId;
    }

    public String getHRName() {
        return HRName;
    }

    public void setHRName(String HRName) {
        this.HRName = HRName;
    }

    public String getHRAddrStr() {
        return HRAddrStr;
    }

    public void setHRAddrStr(String HRAddrStr) {
        this.HRAddrStr = HRAddrStr;
    }

    public String getHRPhoneNum() {
        return HRPhoneNum;
    }

    public void setHRPhoneNum(String HRPhoneNum) {
        this.HRPhoneNum = HRPhoneNum;
    }

    public double getHRLatitude() {
        return HRLatitude;
    }

    public void setHRLatitude(double HRLatitude) {
        this.HRLatitude = HRLatitude;
    }

    public double getHRLongitude() {
        return HRLongitude;
    }

    public void setHRLongitude(double HRLongitude) {
        this.HRLongitude = HRLongitude;
    }

    public String getHRType() {
        return HRType;
    }

    public void setHRType(String HRType) {
        this.HRType = HRType;
    }

    public String getHRDesc() {
        return HRDesc;
    }

    public void setHRDesc(String HRDesc) {
        this.HRDesc = HRDesc;
    }

    public String getHROpenHoursStr() {
        return HROpenHoursStr;
    }

    public void setHROpenHoursStr(String HROpenHoursStr) {
        this.HROpenHoursStr = HROpenHoursStr;
    }

    public String toString(){
        return getHRId() + ", " + "'"+ getHRName() + "'" + ", " +  "'" + getHRAddrStr() +  "'" +", '" + getHRPhoneNum() + "', "  +getHRLatitude() + ", "
                + getHRLongitude() + ", " +  "'" +getHRType() +  "'" +", " +  "'" +getHRDesc()  + "'" +", " +  "'" + getHROpenHoursStr() +"'";
    }

    public boolean equals(Object object){
        if(object instanceof  HumRes){
            HumRes hr = (HumRes) object;
            return hr.getHRId() == this.getHRId();
        }
        return false;
    }
}