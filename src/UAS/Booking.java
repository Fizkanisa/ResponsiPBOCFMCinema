/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
//Java Library (Date & Time API)
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zettopiaa
 */
//class
public class Booking {
//enkapsulasi
    private String customerName;
    private Schedule schedule;
    private String seatNumber;
    private LocalDateTime timestamp;
//Konstruktor
    public Booking(String customerName, Schedule schedule, String seatNumber) {
        this.customerName = customerName;
        this.schedule = schedule;
        this.seatNumber = seatNumber;
        this.timestamp = LocalDateTime.now();
    }
//Getter (Encapsulation)
    public String getCustomerName() { return customerName; }
    public Schedule getSchedule() { return schedule; }
    public String getSeatNumber() { return seatNumber; }
    public LocalDateTime getTimestamp() { return timestamp; }
//Method Overriding + Polymorphism
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s | %s | %s | %s | %s",
                timestamp.format(fmt),
                customerName,
                schedule.getMovie().getTitle(),
                schedule.getTime(),
                seatNumber);
    }
}