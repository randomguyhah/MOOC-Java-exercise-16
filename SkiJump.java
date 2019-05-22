/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domenhocevar
 */
import java.util.Arrays;
import java.util.Random;

public class SkiJump {
    private int length;
    private int[] votes;
    
    public SkiJump(int length, int[] votes) {
        this.length = length;
        this.votes = votes;
    } 
    
    public SkiJump() {
        Random random = new Random();
        this.length = 60 + random.nextInt(61);
        
        this.votes = new int[5];
        for (int i = 0; i < 5; i++) {
            this.votes[i] = 10 + random.nextInt(11);
        }
    }
    
    public String toString() {
        return "length: " + this.length + "\n" + "judge votes: " + this.votes;
    } 
    
    public int getLength() {
        return this.length;
    }
    
    public String voteResults() {
        return "judge votes: " + Arrays.toString(this.votes);
    }
    
    public int score() {
        int score = 0;
        
        score += this.length;
        
        for (int i = 0; i < 5; i++) {
            score += this.votes[i];
        }
        
        score -= this.smallestInArray(this.votes) + this.LargestInArray(this.votes);
        
        return score;
    }
    
    public int smallestInArray(int[] array) {
        int smallest = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        
        return smallest;
    }
    
    public int LargestInArray(int[] array) {
        int largest = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        
        return largest;
    }    
}
