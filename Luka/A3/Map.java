/**
 * @author Willie Ausrotas, Brian Lee
 * Student Numbers: 7804922, 7938501
 * Assignment Number: 3
 * Section: ITI1121 - A
 */

public interface Map<K,V> {
	public V get(K key);
	public boolean contains(K key);
	public void put(K key, V value);
	public void replace(K key, V value);
	public V remove(K key);
}
