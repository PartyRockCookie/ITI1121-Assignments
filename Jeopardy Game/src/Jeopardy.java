/**
 * @author Willie Willie Ausrotas, Brian Lee
 * Student Numbers: 7804922, 7938501
 * Assignment Number: 2
 * Section: ITI1121 - A
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Jeopardy extends JFrame implements ActionListener {

	/**
	 * Auto-Generated.
	 */
	private static final long serialVersionUID = 1L;

	protected JeopardyButton[][] button;
	private JButton reveal = new JButton("Reveal");
	private JButton load = new JButton("Load");
	private JLabel[] label;
	private JLabel question = new JLabel(" ");
	private JLabel answer = new JLabel(" ");
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	private Database d;
	private Question q;
	/**
	 * Main class for all the GUI.
	 */
	Jeopardy() {
		super("Jeopardy");
		//Sets up the directory window to choose the file.
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text documents only", "txt");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fc.showOpenDialog(null);
		
		if (fc.getSelectedFile() != null) {
			d = Database.readQuestions(fc.getSelectedFile().getName());
		} else {
			JOptionPane.showMessageDialog(null, "File not selected.", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		
		if (d != null) {
			//Initializes all the Panels.
			northPanel = new JPanel(new GridLayout(1, d.getNumCategories()));
			centerPanel = new JPanel(new GridLayout(d.getNumQuestions(),
					d.getNumCategories(), 10, 10));
			southPanel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			label = new JLabel[d.getNumCategories()];
			button = new JeopardyButton[d.getNumCategories()][d
					.getNumQuestions()];
			
			//Adds panels to the overall frame and sets default colors + layout.
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.add(northPanel, BorderLayout.NORTH);
			this.add(centerPanel, BorderLayout.CENTER);
			this.add(southPanel, BorderLayout.SOUTH);
			northPanel.setBackground(Color.YELLOW);
			centerPanel.setBackground(Color.WHITE);
			southPanel.setBackground(Color.WHITE);
			centerPanel.setBorder(BorderFactory.createEmptyBorder(3, 5, 10, 5));
			northPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
			northPanel.setPreferredSize(new Dimension(700, 25));
			
			//Creates labels and sets actionlisteners to the buttons.
			createLabels(label);
			createJeopardyButtons(button);
			reveal.addActionListener(this);
			load.addActionListener(this);
			
			//Gridbag layout
			c.gridx = 0;
			c.gridy = 400;
			c.insets = new Insets(10, 0, 10, 150);
			southPanel.add(reveal, c);
			c.insets = new Insets(10, 0, 10, 0);
			southPanel.add(load, c);
			c.gridx = 0;
			c.gridy = 325;
			c.weightx = 1;
			c.weighty = 1;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			southPanel.add(answer, c);
			c.gridx = 0;
			c.gridy = 250;
			c.weightx = 1;
			c.weighty = 1;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			southPanel.add(question, c);
			//Adds labels to the Frame.
			for (int i = 0; i < label.length; i++) {
				northPanel.add(label[i]);
			}
			//Adds buttons to the frame.
			for (int i = 0; i < button[0].length; i++) {
				for (int j = 0; j < button.length; j++) {
					centerPanel.add(button[j][i].button);
				}
			}
			this.pack();

		} else {
			JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

	}
	/**
	 * Initializes the labels.
	 * @param label
	 */
	private void createLabels(JLabel[] label) {
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(d.getCategory(i));
			label[i].setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		}
	}
	/**
	 * Initializes the buttons.
	 * @param button
	 */
	private void createJeopardyButtons(JeopardyButton[][] button) {
		int price = 100;
		int m = d.getNumCategories();
		int n = d.getNumQuestions();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				button[i][j] = new JeopardyButton(this, i, j, price);
				price += 100;
			}
			price = 100;
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Jeopardy j = new Jeopardy();
		j.setVisible(true);
		StudentInfo.display();
	}
	/**
	 * Handles all the action events for the buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				if (button[i][j].button == e.getSource()) {
					q = d.getQuestion(i, j);
					question.setText(q.getQuestion());
					button[i][j].button.setText("-");
					answer.setText("");
				} else if (cmd.equals("Reveal")) {
					if (q != null) {
						answer.setText(q.getResponse());
					} else {
						JOptionPane.showMessageDialog(centerPanel,
								"No question selected.", "Error",
								JOptionPane.ERROR_MESSAGE);
						i = button.length + 1;
						j = button[0].length + 1;

					}
				}

				else if (cmd.equals("Load")) {
					this.dispose();
					Jeopardy jeopardy = new Jeopardy();
					jeopardy.setVisible(true);
					i = button.length + 1;
					j = button[0].length + 1;

				}

			}
		}
	}

}
