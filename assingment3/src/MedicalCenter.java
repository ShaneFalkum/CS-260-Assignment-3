public class MedicalCenter extends HumRes {
    private int numBeds; //number of beds
    private int emergencyRoomCapacity; //emergency room capacity
    private int numDoctors; //number of doctors
    private int numNurses; //number of nurses



    //medical center blank constructor
    public MedicalCenter(){
        this.numBeds = 0;
        this.emergencyRoomCapacity = 0;
        this.numDoctors = 0;
        this.numNurses = 0;
    }


    //medical center full constructor
    public MedicalCenter(int HRId, String HRName, String HRAddrStr, String HRPhoneNum, double HRLatitude, double HRLongitude, String HRType,String HRDesc, String HROpenHoursStr, int numBeds, int emergencyRoomCapacity, int numDoctors, int numNurses){
        super(HRId,HRName, HRAddrStr, HRPhoneNum, HRLatitude, HRLongitude, HRType, HRDesc,HROpenHoursStr);
        this.numBeds = numBeds;
        this.emergencyRoomCapacity = emergencyRoomCapacity;
        this.numDoctors = numDoctors;
        this.numNurses = numNurses;
    }



    //get and set numBeds
    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }



    //get and set emergencyRoomCapacity
    public int getEmergencyRoomCapacity() {
        return emergencyRoomCapacity;
    }

    public void setEmergencyRoomCapacity(int emergencyRoomCapacity) {
        this.emergencyRoomCapacity = emergencyRoomCapacity;
    }



    //get and set numDoctors
    public int getNumDoctors() {
        return numDoctors;
    }

    public void setNumDoctors(int numDoctors) {
        this.numDoctors = numDoctors;
    }



    //get and set numNurses
    public int getNumNurses() {
        return numNurses;
    }

    public void setNumNurses(int numNurses) {
        this.numNurses = numNurses;
    }



    //toString method for creating sql queries
    public String toString(){
        return getHRId() +", " +  getNumBeds() + ", " + getEmergencyRoomCapacity() + ", " + getNumDoctors() + ", " + getNumNurses();
    }
}