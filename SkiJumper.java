/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domenhocevar
 */
import java.util.ArrayList;

public class SkiJumper implements Comparable<SkiJumper> {
    private String name;
    private ArrayList<SkiJump> skiJumps;
    
    public SkiJumper(String name) {
        this.name = name;
        this.skiJumps = new ArrayList<SkiJump>();
    }
    
    public String toString() {
        return this.name + " (" + this.wholeScore() + " points)";
    }
    
    public String getName() {
        return this.name;
    }
    
    public void addSkiJump() {
        this.skiJumps.add(new SkiJump());
    }
    
    public ArrayList<SkiJump> getSkiJumps() {
        return this.skiJumps;
    }
    
    public SkiJump getLastSkiJump() {
        return this.skiJumps.get(this.skiJumps.size() - 1);
    }
    
    public int wholeScore() {
        int score = 0;
        for (SkiJump skiJump : this.skiJumps) {
            score += skiJump.score();
        }
        
        return score;
    }
    
    public int compareTo(SkiJumper skiJumper) {
        if (this.wholeScore().compareTo(skiJumper.wholeScore()) > 0) {
            return 1;
        } else if (this.wholeScore().compareTo(skiJumper.wholeScore()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public String achievedLengths() {
        String lengths = "";
        
        for (SkiJump skiJump : this.skiJumps) {
            lengths += skiJump.getLength() + "m, ";
        }
        lengths = lengths.substring(0, lengths.length() - 2);
        
        return lengths;
    }
}
