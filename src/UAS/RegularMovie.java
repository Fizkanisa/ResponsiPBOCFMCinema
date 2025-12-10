/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

/**
 *
 * @author zettopiaa
 */
public class RegularMovie extends Movie {
    public RegularMovie(String title, String genre, int duration) {
        super(title, genre, duration);
    }
// polimorfism
    @Override
    public String toString() {
        return "[REGULAR] " + super.toString();
    }
}
