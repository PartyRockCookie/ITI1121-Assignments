/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q2
 * Section: ITI1121-A
 */
import java.util.LinkedList;


public class CircularQueue<E> implements Queue<E> {

    private int front, rear, size;
    private final E[] elems;

    @SuppressWarnings("unchecked")

    public CircularQueue(int capacity) {
        elems = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void enqueue(E value) {
        rear = (rear + 1) % elems.length;
        elems[rear] = value;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        E savedValue = elems[front];
        elems[front] = null; // ``scrubbing''
        size--;
        front = (front + 1) % elems.length;
        return savedValue;
    }
    /**
     * This method will use the circular array technique 
     * to dequeue a set amount of elements and add them
     * to a list in reverse order.
     * @param n
     * @return the list with all dequeued elements
     */
    public LinkedList<E> dequeue(int n)
    {
    	if(size < n) {
    		throw new EmptyQueueException();
    	}
    	
    	LinkedList<E> value = new LinkedList<E>();
    	while(n != 0) //Loop will keep running until n is 0.
    	{
    		E tempValue = elems[front];
    		elems[front] = null;
    		size--;
    		front = (front + 1)%elems.length;
    		value.addFirst(tempValue); // Add the current number to the list.
    		n--; // Decrease the value of n, causing the amount left to dequeue to run out.
    	}
    	return value; //Return the List
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder(getClass().getName() + "[");

        if (size > 0) {

            int offset = 0;

            str.append(elems[front]);
            offset = offset + 1;

            while (offset < size) {

                str.append(", ");
                str.append(elems[(front + offset) % elems.length]);
                offset = offset + 1;

            }

        }

        str.append("]");

        return str.toString();

    }
}