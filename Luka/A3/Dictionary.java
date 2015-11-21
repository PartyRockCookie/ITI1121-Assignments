/**
 * @author Willie Ausrotas, Brian Lee
 * Student Numbers: 7804922, 7938501
 * Assignment Number: 3
 * Section: ITI1121 - A
 */
import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Token> {

	/** The elements of this array are of type Pair,
	* a private static nested class. A Pair object
	* stores an association, a key and a value, of
	* type String and Token, respectively.
	*/
	private static class Pair { 
		private String key;
		private Token value;

		private Pair(String key, Token value) {
			this.key = key;
			this.value = value;
		}
	}

	private Pair[] associations;
	private int size;

	public Dictionary() {
		associations = new Pair[10];
		size = 0;
	}

	/** returns the left most value associated with this specified key.
	* The methods throws java.util.NoSuchElementException if the element
	* being requested does not exist. It throws NullPointerException if the
	* specified key is null.
	* @param key
	* @return associations value
	*/
	public Token get(String key) {

		if (key == null) {
			throw new NullPointerException();
		} else
			for (int i = size - 1; i >= 0; i--) {
				if (key.equals(associations[i].key)) { // if (String)key ==
														// (String)(associations[i].key))?
					return associations[i].value;
				}
			}
		throw new NoSuchElementException();
	}

	public boolean contains(String key) {

		if (key == null) {
			throw new NullPointerException();
		}

		else
			for (int i = 0; i < size; i++) {
				if (key.equals(associations[i].key)) {
					return true;
				}
			}
		return false;
	}
	/**
	 * @param key
	 * @param value
	 * @return Pair with new key and value, also mutates the array.
	 */
	public void put(String key, Token value) { // implement dynamic array here
		if (key == null || value == null) {
			throw new NullPointerException();
		}

		if (size == associations.length) {
			Pair[] temp = new Pair[associations.length + 5];
			for (int i = 0; i < associations.length; i++) {
				temp[i] = associations[i];
			}
			associations = temp;
		}

		Pair associationArray = new Pair(key, value);
		associations[size] = associationArray;
		size++;
	}
	/**
	 * @param key
	 * @param value
	 * @return null
	 */
	public void replace(String key, Token value) {
		if (key == null || value == null) {
			throw new NullPointerException();
		}
		for (int i = size - 1; i >= 0; i--) {
			if (key.equals(associations[i].key)) {
				associations[i].value = value;
				return;
			}
		}
		throw new NoSuchElementException();
	}
	/**
	 * @param key
	 * @return temp. the element removed.
	 */
	public Token remove(String key) {
		if (key == null) {
			throw new NullPointerException();
		}
		Token temp = null;
		int i = 0;
		boolean found = false;
		for (i = size - 1; i >= 0; i--) {
			if (key.equals(associations[i].key)) {
				temp = associations[i].value;
				associations[i] = null;
				found = true;
				break;
			}
		} //found key, removed, take note of the element that was removed to shift the ones after down one element
		if (found == true){
		for (int j = i; j < size - 1; j++) {
			associations[j] = associations[j + 1];
		}
		// associations[size-1] = null;
		size--;
		
		return temp;
		}
		else{
		throw new NoSuchElementException();
		}
	}
	/**
	 * @return the dictionary to a string representation.
	 */
	public String toString(){
		String str = "";
		for (int i=0; i<size; i++){
			str += "Dictionary: {elems = [{key = " + associations[i].key + ", value=" + associations[i].value + "}";
		}
		str += "]}";
		return str;
		
	}
}
