/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q4
 * Section: ITI1121-A
 */

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        StudentInfo.display(); //Call to print student info.
        List<Tuple> l;
        l = new LinkedList<Tuple>();

        l.add(new Tuple('a'));
        l.add(new Tuple('b'));
        l.add(new Tuple('a'));
        l.add(new Tuple('c'));
        l.add(new Tuple('b'));
        l.add(new Tuple('a'));
        l.add(new Tuple('c'));
        l.add(new Tuple('a'));
        l.add(new Tuple('d'));
        l.add(new Tuple('d'));
        l.add(new Tuple('b'));

        Frequency.frequency(l);

    }
}