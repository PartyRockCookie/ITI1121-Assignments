/**
 * @author Willie Ausrotas, Brian Lee
 * Student Numbers: 7804922, 7938501
 * Assignment Number: 2
 * Section: ITI1121 - A
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Database {
	@SuppressWarnings("unused")
	private int m;
	private int n;
	private static String[] response;
	private String[] categories;
	private Question[][] question;
	 
	/**
	  * Creates a new database
	  * @param m
	  * @param n
	  */
	private Database(int m, int n) {
		this.m = m;
		this.setN(n);		
		categories = new String[m];
		
		for(int i = 0;i<categories.length;i++)
		{
			categories[i] = response[i];
		}
		
		question = new Question[m][n];
		int count = m;
		int count2 = count+1;
		for(int i = 0;i<m;i++)
		{
			for(int j = 0;j<n;j++)
			{
				if(count == response.length) break;
				question[i][j] = new Question(response[count],response[count2]);
				count = count + 2;
				count2 +=2;
			}
		}
	}
	/**
	 * Loads the file and will read the number of categories,
	 * questions, and read all the questions and categories.
	 * @param name
	 * @return new database
	 */
	public static Database readQuestions(String name) {
		Scanner sc;
		
		try {
			sc = new Scanner (new File(name));
			int numCategories = Integer.parseInt(sc.nextLine());
			int numQuestions = Integer.parseInt(sc.nextLine());
			response = new String[((numCategories*numQuestions)*2)+numCategories];
			for(int i = 0;i<response.length;i++) {
				response[i] = sc.nextLine();
			}
			sc.close();
			return new Database(numCategories,numQuestions);
		} catch (FileNotFoundException e) {
			sc = null;
			return null;
		}		
	}
	/**
	 * Returns the category at certain index.
	 * @param index
	 * @return category at index.
	 */
	public String getCategory(int index) {
		//Assuming you are going to know that Category 1 is index 0 in the array.
		return categories[index];
	}
	/**
	 * Returns the question at a certain index.
	 * @param category
	 * @param index
	 * @return Question at certain category and question
	 */
	public Question getQuestion(int category, int index)
	{
		return question[category][index];
	}
	/**
	 * Changes the question at a certain point.
	 * @param category
	 * @param index
	 * @param question
	 */
	public void setQuestion(int category, int index, Question question)
	{
		this.question[category][index] = question;
	}
	/**
	 * Returns the # of categories.
	 * @return number of categories.
	 */
	public int getNumCategories() {
		return categories.length;
	}
	/**
	 * Returns the numbers of questions.
	 * @return number of questions.
	 */
	public int getNumQuestions() {
		return question[0].length;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Database d;
		d = readQuestions(JOptionPane.showInputDialog("Enter the file name:"));
		StudentInfo.display();

	}
	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}
}
