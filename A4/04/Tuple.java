/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q4
 * Section: ITI1121-A
 */

public class Tuple { 
 
    private final char c; 
    private boolean visited; 
 
    public Tuple(char c) { 
        this.c = c; 
        visited = false; 
    } 
 
    public void toggle() { 
        visited = ! visited; 
    } 
 
    public boolean visited() { 
        return visited; 
    } 
 
    public char getChar() { 
        return c; 
    } 
 
    @Override
    public String toString() { 
        if (visited) { 
            return "(" + c + ",t)"; 
        } else { 
            return "(" + c + ",f)"; 
        } 
    } 
}