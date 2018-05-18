/**
 * @author Willie Ausrotas, Brian Lee
 * Student Numbers: 7804922, 7938501
 * Assignment Number: 2
 * Section: ITI1121 - A
 */

public class Question {
	private String question;
	private String response;
	/**
	 * 
	 * @param question
	 * @param response
	 */
	public Question(String question, String response)
	{
		this.question = question;
		this.response = response;
	}
	/**
	 * 
	 * @return
	 */
	String getQuestion()
	{
		return this.question;
	}
	/**
	 * 
	 * @return
	 */
	String getResponse()
	{
		return this.response;
	}
}
