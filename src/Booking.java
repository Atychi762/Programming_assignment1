import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.UUID;

public class Booking {
    //Data fields used in this class
    public String bookingNumber;
    public String patient;
    public int patientNum;
    public HealthPractice practice;
    public LocalDateTime dateTime;
    public LocalDate now = LocalDate.now();
    private HealthPracticeAppointmentWebservice timeWebService;

    //Constructor for this class sets the values above in the case all are provided
    public Booking(String patient, int patientNum, HealthPractice practice, LocalDateTime dateTime){
        //Check if date and time is in the future, if not throw IllegalArgumentException
        if(now.isAfter(ChronoLocalDate.from(dateTime))) throw new IllegalArgumentException("Can't have a date in the past");
        this.dateTime = dateTime;

        this.patient = patient;
        this.patientNum = patientNum;
        this.practice = practice;
        this.bookingNumber = UUID.randomUUID().toString();
    }

    public Booking(String patient, int patientNum, HealthPractice practice){
        this.patient = patient;
        this.patientNum = patientNum;
        this.practice = practice;
        this.bookingNumber = UUID.randomUUID().toString();
    }

    public int getPatientNumber(){
        return this.patientNum;
    }
    public void setPatientNumber(int num){
        this.patientNum = num;
    }

    public String getPracticeDetails(){
        String output = "Practice Name: "+practice.getPracticeName()+"\nPractice Address: "+practice.getPracticeAddress();
        return output;
    }

    public void setHealthPracticeAppointmentWebservice(HealthPracticeAppointmentWebservice service){
        this.timeWebService = service;
    }

    public void addDateTime(LocalDateTime time){
        dateTime = time;
    }

}

