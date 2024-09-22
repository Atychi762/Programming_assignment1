// Peter Fitzgerald
//22323303

public class HealthPractice {
    //Data fields used in this class
    public String hPName;
    public String hPAddress;

    //Constructor sets the name and address for a practice
    public HealthPractice(String hPName, String hPAddress){
        this.hPName = hPName;
        this.hPAddress = hPAddress;
    }

    //Method to get the practice name
    public String getPracticeName(){
        return this.hPName;
    }

    //Method to get the practice address
    public String getPracticeAddress(){
        return this.hPAddress;
    }
}
