package Assignment3;

public class MedicalCenter extends HumRes {
    private int numBeds;
    private int emergencyRoomCapacity;
    private int numDoctors;
    private int numNurses;

    public MedicalCenter(){
        this.numBeds = 0;
        this.emergencyRoomCapacity = 0;
        this.numDoctors = 0;
        this.numNurses = 0;
    }

    public MedicalCenter(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr, int numBeds, int emergencyRoomCapacity, int numDoctors, int numNurses){
        super(HRId,HRName, HRAddrStr, HRPhoneNum, HRLatitude, HRLongitude, HRType, HRDesc,HROpenHoursStr);
        this.numBeds = numBeds;
        this.emergencyRoomCapacity = emergencyRoomCapacity;
        this.numDoctors = numDoctors;
        this.numNurses = numNurses;
    }


    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public int getEmergencyRoomCapacity() {
        return emergencyRoomCapacity;
    }

    public void setEmergencyRoomCapacity(int emergencyRoomCapacity) {
        this.emergencyRoomCapacity = emergencyRoomCapacity;
    }

    public int getNumDoctors() {
        return numDoctors;
    }

    public void setNumDoctors(int numDoctors) {
        this.numDoctors = numDoctors;
    }

    public int getNumNurses() {
        return numNurses;
    }

    public void setNumNurses(int numNurses) {
        this.numNurses = numNurses;
    }

    public String toString(){
            return getHRId() +", " +  getNumBeds() + ", " + getEmergencyRoomCapacity() + ", " + getNumDoctors() + ", " + getNumNurses();
    }
}
