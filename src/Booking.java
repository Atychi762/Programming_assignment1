import java.time.*;
import java.util.UUID;

public class Booking {
    //Data fields used in this class
    public String bookingNumber;
    public String patient;
    public int patientNum;
    public HealthPractice practice;
    public LocalDateTime dateTime;

    //Constructor for this class sets the values above in the case all are provided
    public Booking(String patient, int patientNum, HealthPractice practice, LocalDateTime dateTime){
        this.patient = patient;
        this.patientNum = patientNum;
        this.practice = practice;
        this.dateTime = dateTime;
        this.bookingNumber = UUID.randomUUID().toString();
    }

    //Method returns the data about the health practice
    public HealthPractice GetPractice(){
        return practice;
    }

    public int GetPatientNum(){
        return patientNum;
    }

    public void SetPatientNum(int patientNum){
        this.patientNum = patientNum;
    }

    @Override
    public String toString(){
        String outputString = "";
        outputString += "Booking ID Number: " + bookingNumber + "\n";
        outputString += "Patient Number: " + patientNum +"\n";
        outputString += "Health Practice: " + practice.GetPracticeName() + "\n";
        outputString += "Address: " + practice.GetPracticeAddress() + "\n";
        outputString += "Date & Time: On " + dateTime.getDayOfWeek() + ", "+ dateTime.getMonthValue() + dateTime.getMonth() + dateTime.getYear() + " at " + dateTime.getHour() + ":" + dateTime.getMinute();

        return outputString;
    }

    public static void main(String[] args){
        LocalDateTime dateTime = LocalDateTime.now();
    }

}

