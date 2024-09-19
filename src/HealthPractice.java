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
    public String GetPracticeName(){
        return this.hPName;
    }

    //Method to get the practice address
    public String GetPracticeAddress(){
        return this.hPAddress;
    }
}
