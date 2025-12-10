/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zettopiaa
 */
public class CinemaSystem {
    // Enkapsulasi
    private List<Movie> movies; 
    private List<Schedule> schedules;
    private File bookingFile;

    public CinemaSystem() {
        movies = new ArrayList<>();
        schedules = new ArrayList<>();
        bookingFile = new File("booking.txt"); //Input Output
        initSampleData();
        loadBookingsToSeats(); // jika ada file lama, tandai kursi terpakai
    }

    private void initSampleData() {
        // sample movies (mix regular & premium)
        // inheritance dan polimorfisme
        Movie m1 = new RegularMovie("Inside Out 2", "Animation", 95);
        Movie m2 = new RegularMovie("Conjuring", "Horror", 120);
        Movie m3 = new PremiumMovie("Dilan1990", "Romance", 110);
        Movie m4 = new RegularMovie("Petaka Gunung Gede", "Horror", 98);
        Movie m5 = new RegularMovie("Danur", "Horror", 78);
        Movie m6 = new RegularMovie("Abadi Nan Jaya", "Zombie", 116);
        Movie m7 = new RegularMovie("Agak Laen", "Komedi", 119);
        Movie m8 = new PremiumMovie("Jumbo", "Animasi", 102);
        Movie m9 = new PremiumMovie("Moana", "Fantasi", 104);
        Movie m10 = new PremiumMovie("Frozen", "Fantasi", 102);
        
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        movies.add(m5);
        movies.add(m6);
        movies.add(m7);
        movies.add(m8);
        movies.add(m9);
        movies.add(m10);

        schedules.add(new Schedule(m1, "14:00"));
        schedules.add(new Schedule(m2, "19:00"));
        schedules.add(new Schedule(m3, "16:00"));
        schedules.add(new Schedule(m4, "20:00"));
        schedules.add(new Schedule(m5, "11:00"));
        schedules.add(new Schedule(m6, "13:00"));
        schedules.add(new Schedule(m7, "13:30"));
        schedules.add(new Schedule(m8, "14:20"));
        schedules.add(new Schedule(m9, "15:00"));
        schedules.add(new Schedule(m10, "15:30"));
    }

    public List<Movie> getMovies() { return movies; }
    public List<Schedule> getSchedules() { return schedules; }

    public List<Schedule> getSchedulesForMovie(Movie movie) {
        List<Schedule> result = new ArrayList<>();
        for (Schedule s : schedules) {
            if (s.getMovie().equals(movie)) result.add(s);
        }
        return result;
    }

    // untuk menyimpan pesanan
    public boolean makeBooking(Booking booking) {
        // untuk cek ketersediaan kursi di jadwal
        Seat seat = booking.getSchedule().findSeatByNumber(booking.getSeatNumber());
        if (seat == null || seat.isBooked()) {
            return false;
        }

        seat.setBooked(true);
        // EXCEPTION
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bookingFile, true))) {
            bw.write(booking.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<String> readBookingLines() {
        List<String> lines = new ArrayList<>();
        if (!bookingFile.exists()) return lines;
        try (BufferedReader br = new BufferedReader(new FileReader(bookingFile))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void loadBookingsToSeats() {
        if (!bookingFile.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(bookingFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 5) continue;
                String movieTitle = parts[2].trim();
                String time = parts[3].trim();
                String seatNo = parts[4].trim();

                for (Schedule s : schedules) {
                    if (s.getMovie().getTitle().equalsIgnoreCase(movieTitle) &&
                        s.getTime().equalsIgnoreCase(time)) {
                        Seat seat = s.findSeatByNumber(seatNo);
                        if (seat != null) seat.setBooked(true);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
