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
import java.util.Scanner;
import java.util.Collections;

public class UserInterface {
    private ArrayList<SkiJumper> skiJumpers;
    private Scanner reader;
    
    public UserInterface(Scanner reader) {
        this.skiJumpers = new ArrayList<SkiJumper>();
        this.reader = reader;
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week" + "\n");
        
        this.enteringNames();
        
        System.out.println("\n" + "The tournament begins!" + "\n");
        
        this.jumping();
        
        System.out.println("\n" + "Thanks!" + "\n ");
        
        this.tournamentResults();
    }
    
    public void enteringNames() {
        System.out.println("Write the names of the participants one"
                + " at a time; an empty string brings you to the"
                + " jumping phase.");
        
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            
            if (name.isEmpty()) {
                break;
            }
            
            this.skiJumpers.add(new SkiJumper(name));
        }
    }
    
    public void jumping() {
        int i = 0;
        while (true) {
            Collections.sort(this.skiJumpers);
            
            i += 1;
            
            System.out.print("Write \"jump\" to jump; otherwise you quit:");
            if (!reader.nextLine().equals("jump")) {
                break;
            }
            
            System.out.println("\n" + "Round " + i + "\n");
            
            System.out.println("Jumping order:");
            
            for (int j = 1; j <= this.skiJumpers.size(); j++) {
                System.out.println("  " + j + ". " + this.skiJumpers.get(j - 1));
            }
            
            this.jump();
            
            System.out.println("\n" + "Results of round " + i);
            this.printResultsOfLastRound();
            System.out.println("");
            
            
        }    
    }
    
    public void jump() {
        for (SkiJumper skiJumper : this.skiJumpers) {
            skiJumper.addSkiJump();
        }
    }
    
    public void printResultsOfLastRound() {
        for (SkiJumper skiJumper : this.skiJumpers) {
            System.out.println("  " + skiJumper.getName());
            System.out.println("    " +" length: " +  skiJumper.getLastSkiJump().getLength());
            System.out.println("     " + skiJumper.getLastSkiJump().voteResults());
        }
    }
    
    public void tournamentResults() {
        Collections.reverse(this.skiJumpers);
        
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        
        int i = 0;
        for (SkiJumper skiJumper : this.skiJumpers) {
            i++;
            System.out.println(i + "           " + skiJumper.getName() + " (" + skiJumper.wholeScore() + ")");
            System.out.println("            jump lengths: " + skiJumper.achievedLengths());
        }
    }
}
