/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q3
 * Section: ITI1121-A
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JStock j = new JStock();
		j.buy(100, 20);
		j.buy(20, 24);
		j.buy(200, 36);
		System.out.println(j.sell(120, 30));
		j.buy(500, 5);
		System.out.println(j.getValue());
		j.buy(10,10);
		System.out.println(j.getValue());
		
	}

}
