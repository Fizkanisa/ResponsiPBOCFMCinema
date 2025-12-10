/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

/**
 *
 * @author zettopiaa
 */
//class
public class Seat {
//enkapsulasi
     private String seatNumber;
    private boolean booked;
//konstruktor  
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }
//getter
    public String getSeatNumber() { return seatNumber; }
//getter&setter
    public boolean isBooked() { return booked; }
    public void setBooked(boolean booked) { this.booked = booked; }
//Method Overriding + Polymorphism
    @Override
    public String toString() {
        return seatNumber + " (" + (booked ? "Terisi" : "Kosong") + ")";
    }
}