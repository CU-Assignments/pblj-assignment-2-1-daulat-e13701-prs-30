import java.util.concurrent.*;
class BookTicket{
    private static int availableSeats = 10;
    public synchronized void bookTicket(String passenger, int noOfSeats){
        if(availableSeats >= noOfSeats){
            System.out.println(passenger + " has successfully booked " + noOfSeats + " seats.");
            availableSeats = availableSeats - noOfSeats;
        }
        else{
            System.out.println("Not enough seats for " + passenger);
        }
    }
}
class Passenger extends Thread{
    private BookTicket bookingSystem;
    private int seats;
    private String passengerName;
    public Passenger(BookTicket bookingSystem, String passengerName, int seats, int priority){
        this.bookingSystem = bookingSystem;
        this.seats = seats;
        this.passengerName = passengerName;
        setPriority(priority);
    }
    public void run(){
        bookingSystem.bookTicket(passengerName, seats);
    }
}
public class TicketBookingSystem{
    public static void main(String[] args){
        BookTicket bookingSystem = new BookTicket();
        Passenger p1 = new Passenger(bookingSystem,"Andrew", 2, Thread.MAX_PRIORITY);
        Passenger p2 = new Passenger(bookingSystem,"Jenny", 1, Thread.MAX_PRIORITY);
        Passenger p3 = new Passenger(bookingSystem,"Mike", 3, Thread.MAX_PRIORITY);
        Passenger p4 = new Passenger(bookingSystem,"Annie", 4, Thread.MAX_PRIORITY);
        Passenger p5 = new Passenger(bookingSystem,"Ben", 2, Thread.MAX_PRIORITY);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}