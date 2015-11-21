/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q4
 * Section: ITI1121-A
 */

import java.util.Iterator;
import java.util.List;

public class Frequency<E> {
    /**
     *
     * @param l
     */
    public static void frequency(List<Tuple> l) {
        Iterator<Tuple> iter = l.iterator(); //Initialize the original iterator
        Tuple temp = iter.next(); //Set the first item in list to a temp object.
        int counter = 0; //See comments at line 42.
        int count; //This holds the amount of items we toggle per cycle.
        while (counter < l.size()) {
            counter = 0; //Reinitialize this to keep looping through list.
            count = 0; //Variable to hold how many items we toggle per cycle.
            if (temp.visited()) { //If the object in temp has been visited already, we want to start on the next item.
                temp = iter.next(); //Go to the next item and check again.
            } else if (!(temp.visited())) { //If it has not  been visited, we want to visit all of that type.
                temp.toggle(); //Mark the first as visited.
                count++; //Increase the amount we have visited this cycle by 1.
                char first = temp.getChar(); //We take the first char that was not toggle and want to toggle all of this type.
                while (iter.hasNext()) { //Keep looping through list till we toggle all of type "first"
                    Tuple temp1 = iter.next(); //Create another temp object which is 1 position ahead of first.
                    if (temp1.getChar() == first) { //If the char value of temp1 and first are the same:
                        temp1.toggle(); //Toggle it as visited.
                        count++; //Increase the amount we have visited this cycle by 1.
                    }
                }
                iter = l.iterator(); //Restart the iterator.
                while (iter.hasNext()) {
                    Tuple check = iter.next(); //Holds each Tuple one at a time.
                    System.out.print(check.toString()); //Print it out to a String.
                    if (check.visited()) {
                        counter++; //If it is already visited, increase this by one. If this is equal to list.size,
                                    //Then we know that the whole list has been toggled, if it is not equal, we must reset it
                                    //To 0 at line 19, and repeat the whole process till the list is all toggled.
                    }
                }
                System.out.print(" "+first+" : "+count); //Print out the char we were toggling and how many we toggled this cycle.
                System.out.println(); //Print a blank like for clarity.
                iter = l.iterator(); //Restart the iterator so we can loop through the list again.

            }

        }
    }
}
