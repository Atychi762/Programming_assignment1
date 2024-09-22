// Peter Fitzgerald
//22323303

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HealthPracticeTest {
    //Test to ensure that the health practice details are stored correctly
    @Test
    public void testNameAndAddressIsCorrect(){
        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");

        assertSame("Test Practice", practice.getPracticeName());
        assertSame("street, town, county", practice.getPracticeAddress());
    }
    //Test to ensure that the patient number is returned correctly
    @Test
    public void testPatientNumberIsReturnedCorrect(){
        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");
        Booking myBooking = new Booking("patient", 1234, practice, LocalDateTime.now());

        assertEquals(1234, myBooking.getPatientNumber());


    }
    //Test to ensure that the patient number can be edited and is returned correctly
    @Test
    public void testPatientNumberIsEditedCorrectly(){
        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");
        Booking myBooking = new Booking("patient", 1234, practice, LocalDateTime.now());

        myBooking.setPatientNumber(2468);
        assertEquals(2468, myBooking.getPatientNumber());
    }
    //Test to ensure that the program handles a valid date in the correct way
    @Test
    public void testAValidDate(){
        LocalDateTime time = LocalDateTime.now();
        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");

        LocalDateTime finalTime = time.plusDays(1);
        Assertions.assertDoesNotThrow(() -> {
           new Booking("patient", 1234, practice, finalTime);
        });
    }
    //Test to ensure that the program handles an invalid date in the correct manner
    @Test
    public void testADateInPast(){
        LocalDateTime time = LocalDateTime.now();
        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");

        LocalDateTime finalTime = time.minusDays(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Booking("patient", 1234, practice, finalTime);
        });
    }
    //Test to ensure that the health practice details are returned correctly when called from the Booking class
    @Test
    public void testQueryOfPracticeInfoFromBooking(){
        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");
        Booking myBooking = new Booking("patient", 1234, practice, LocalDateTime.now());

        assertEquals("Practice Name: Test Practice\nPractice Address: street, town, county", myBooking.getPracticeDetails());

    }
    //Test to ensure that the program handles the case where no date is given correctly
    @Test
    public void testAddingBookingWithoutDateAndTime(){
        HealthPracticeAppointmentWebservice testService = new HealthPracticeAppointmentWebservice(){
            @Override
            public LocalDateTime getBookingDateTime(HealthPractice practice){
                return LocalDateTime.now();
            }
        };

        HealthPractice practice = new HealthPractice("Test Practice", "street, town, county");
        Booking myBooking = new Booking("patient", 1234, practice);

        myBooking.setHealthPracticeAppointmentWebservice(testService);
        myBooking.addDateTime(testService.getBookingDateTime(practice));
    }
}