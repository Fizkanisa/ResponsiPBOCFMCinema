/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

/**
 *
 * @author zettopiaa
 */
public class PremiumMovie extends Movie {
    public PremiumMovie(String title, String genre, int duration) {
        super(title, genre, duration);
    }
// polimorfism
    @Override
    public String toString() {
        return "[PREMIUM] " + super.toString();
    }
}
