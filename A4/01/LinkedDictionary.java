/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q1
 * Section: ITI1121-A
 */


import java.util.NoSuchElementException;


public class LinkedDictionary implements Map<String, Token> {


    private static class Elem {
        private String key;
        private Token value;
        private Elem next;

        private Elem(String key, Token value, Elem next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //Instance variables
    private Elem head;
    private Elem tail;

    public LinkedDictionary()
    {
        this.head = null;
        this.tail = null;
    }

    /**
     * Creates a new association in the list.
     * @param key key with which the specified value is to be associated
     * @param value the value to be associated with this key
     */
    public void put(String key, Token value) {
        if(key == null || value == null)
        {
            throw new NullPointerException(); //If Key or Value doesn't exist throw an error.
        }
        if(head == null) //If this is null it means our list is empty
        {
            head = new Elem(key, value, null); //Adds the new element to the head.
            tail = head;
        }
        else{
            Elem temp = new Elem(key, value, tail); //Adds the elem to the tail if there is already elements.
            tail = temp;
        }
    }

    /**
     * This method will return true if key is in the list, otherwise
     * it will return false.
     * @param key looking up for an association containing this key
     * @return true if it contains the key, false otherwise.
     */
    public boolean contains(String key) {
        if(key == null)
        {
            throw new NullPointerException(); //If key is null throw an error.
        }
        if(head == null)
        {
            return false; //If head is null, list is empty, therefor key can't exist.
        }
        Elem current = tail; //make the current element the tail of the list.
        while(current != null) //As long as there is another element keep looping.
        {
            if(current.key.equals(key)) //If the key is found:
            {
                return true; //Return true.
            }
            current = current.next; //Go to the next position if key is not found.
        }
        return false; //Return false if key is never found.
    }

    /**
     * This method will go to a certain key and replace the value.
     * @param key key with which the specified value is to be associated
     * @param value the value to be associated with this key
     * @throws NoSuchElementException if key is not found.
     */
    public void replace(String key, Token value){
        if(key == null || value == null)
        {
            throw new NullPointerException(); //If key or value is null, throw an error.
        }

        Elem current = tail; //Set the current element to tail.
        while(current != null) //Loop through list while there is more elements.
        {
            if(current.key.equals(key)) //If the key is found:
            {
                current.value = value; //Replace the value.
                return; //End the method.
            }
            current = current.next; //Else move on to the next position.
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns the left most value associated with the key.
     * @param key key whose associated value is to be returned
     * @return The value associated with key, else a error.
     */
    public Token get(String key) {
        if(key == null)
        {
            throw new NullPointerException(); //If key is null, throw a new error.
        }
        Elem current = tail; // set current to the tail.
        while(current != null) {
            if (current.key.equals(key)) { //If the key is found
                return current.value; //Return the value
            }
            current = current.next; //Else move to the next element.
        }
        throw new NoSuchElementException(); //If it is not found throw an error.
    }

    /**
     * This method will remove the left most association for key and returns the value of Token.
     * @param key the key of the association to remove
     * @return the removed Token or if not found an error.
     * @throws NoSuchElementException
     */
    public Token remove(String key) throws NoSuchElementException
    {
        if(key == null)
        {
            throw new NullPointerException();
        }
        Elem tmp = head;
        Token token;
        while(tmp.next.key!=key)
        {
            tmp = tmp.next;
        }
        token = tmp.next.value;
        tmp.next = tmp.next.next;
        return token;
    }
}


