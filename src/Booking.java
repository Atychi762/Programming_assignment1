// Peter Fitzgerald
//22323303

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.*;
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
        //Setting the rest of the fields
        this.patient = patient;
        this.patientNum = patientNum;
        this.practice = practice;
        this.bookingNumber = UUID.randomUUID().toString();
    }

    //Overloaded constructor for cases where Date is not provided
    public Booking(String patient, int patientNum, HealthPractice practice){
        this.patient = patient;
        this.patientNum = patientNum;
        this.practice = practice;
        this.bookingNumber = UUID.randomUUID().toString();
    }

    //Method to access the patient number
    public int getPatientNumber(){
        return this.patientNum;
    }
    //Method to set the patient number
    public void setPatientNumber(int num){
        this.patientNum = num;
    }
    //Method to access the health practice details
    public String getPracticeDetails(){
        String output = "Practice Name: "+practice.getPracticeName()+"\nPractice Address: "+practice.getPracticeAddress();
        return output;
    }
    //Method to set the health practice webservice for getting a time when no time is provided
    public void setHealthPracticeAppointmentWebservice(HealthPracticeAppointmentWebservice service){
        this.timeWebService = service;
    }
    //Method to add the date and time from the web service
    public void addDateTime(LocalDateTime time){
        dateTime = time;
    }
    //ToString Method to nicely display all the booking details
    @Override
    public String toString(){
        String outputString = "";

        outputString += "Booking ID Number: " + this.bookingNumber + "\n";
        outputString += "Patient Number: " + getPatientNumber() + "\n";
        outputString += "Health Practice: " + practice.getPracticeName() + "\n";
        outputString += "Address: " + practice.getPracticeAddress() + "\n";
        outputString += "Date & Time: On" + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(dateTime) + "at" + dateTime.getHour() + ":" + dateTime.getMinute() +  "\n";

        return outputString;
    }
}

