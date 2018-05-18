/**
 * @author Willie Ausrotas, Brian Lee
 * Student Numbers: 7804922, 7938501
 * Assignment Number: 2
 * Section: ITI1121 - A
 */

import javax.swing.*;
import java.awt.event.*;

public class JeopardyButton extends JFrame{
	/**
	 *  Auto-generated.
	 */
	private static final long serialVersionUID = 1L;
	
	private int category;
	private int question;
	protected JButton button;
	/**
	 * Creates the JeopardyButton with such params.
	 * @param listener
	 * @param category
	 * @param question
	 * @param amount
	 */
	JeopardyButton(ActionListener listener, int category, int question, int amount)
	{

		this.category = category;
		this.question = question;
		button = new JButton(""+amount);
		button.addActionListener(listener);
	}
	/**
	 * Returns the category at certain index.
	 * @return category
	 */
	public int getCategoryIndex() {
		return this.category;
	}
	/**
	 * Returns the question at certain index.
	 * @return question
	 */
	public int getQuestionIndex() {
		return this.question;
	}
	

}
