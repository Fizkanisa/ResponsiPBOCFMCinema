/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zettopiaa
 */
public class Schedule {
    // enkapsulasi
    private Movie movie;
    private String time; 
    private List<Seat> seats; 

    public Schedule(Movie movie, String time) {
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();
        initSeats(); 
    }

    private void initSeats() {
        String[] rows = {"A","B","C"};
        int cols = 6; 
        for (String r : rows) {
            for (int c = 1; c <= cols; c++) {
                seats.add(new Seat(r + c));
            }
        }
    }

    public Movie getMovie() { return movie; }
    public String getTime() { return time; }

    public List<Seat> getSeats() { return seats; }

    public Seat findSeatByNumber(String seatNumber) {
        for (Seat s : seats) {
            if (s.getSeatNumber().equalsIgnoreCase(seatNumber)) return s;
        }
        return null;
    }

    // POLIMORFISME
    @Override
    public String toString() {
        return movie.getTitle() + " - " + time;
    }
}
