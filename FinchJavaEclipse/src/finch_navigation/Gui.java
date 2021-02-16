package finch_navigation;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

class Gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel mypanel;
	JButton F, L, R, B, Exit, Run, Backtrack;
	JLabel Label1, Label2;
	JTextField text;
	String direction = "";

	public Gui() {

		mypanel = new JPanel();
		F = new JButton("Forward(F)");
		L = new JButton("Left(L)");
		R = new JButton("Right(R)");
		B = new JButton("Backward");
		Exit = new JButton("Exit (S)");
		Run = new JButton("Run");
		Backtrack = new JButton("Backtrack(B)");
		Label1 = new JLabel("Select a command or 'Exit' to close the program");
		Label2 = new JLabel("I exist");
		text = new JTextField(20);
		text.setEditable(false);
		Label2.setVisible(false);

		add(mypanel);
		mypanel.add(F);
		mypanel.add(L);
		mypanel.add(R);
		mypanel.add(B);
		mypanel.add(Exit);
		mypanel.add(Backtrack);
		mypanel.add(Label1);
		mypanel.add(Label2);
		mypanel.add(text);
		mypanel.add(Run);

		F.addActionListener(this);
		L.addActionListener(this);
		R.addActionListener(this);
		B.addActionListener(this);
		Exit.addActionListener(this);
		Run.addActionListener(this);
		Backtrack.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		Converter myconv = new Converter();
		Command_History command = new Command_History();
		if (e.getSource() == F) {
			Label1.setText("Input a duration and a speed, separate values by a space.");
			Label2.setVisible(true);
			Label2.setText("Ranges = Duration (1 - 6) and Speed (0 - 100).");
			text.setEditable(true);
			direction = "F";
		} else if (e.getSource() == L) {
			Label1.setText("Input duration and 2 different speeds, separate values by a space.");
			Label2.setVisible(true);
			Label2.setText("Ranges = Duration (1 - 6) and Speeds (-100 - 100).");
			text.setEditable(true);
			direction = "L";
		} else if (e.getSource() == R) {
			Label1.setText("Input duration and 2 different speeds, separate values by a space.");
			Label2.setVisible(true);
			Label2.setText("Ranges = Duration (1 - 6) and Speeds (100 - 100).");
			text.setEditable(true);
			direction = "R";
		} else if (e.getSource() == B) {
			Label1.setText("Input a duration and a speed, separate values by a space.");
			Label2.setVisible(true);
			Label2.setText("Ranges = Duration (1 - 6) and Speeds (0 - 100).");
			text.setEditable(true);
			direction = "B";
		} else if (e.getSource() == Run) {
			String input = text.getText();
			if (direction == null) {
				try {
					command.setbacktracks(input);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else {
				myconv.setinput(input, direction);
			}
			Label1.setText("Select a command or 'Exit' to close the program");
			Label2.setVisible(false);
			text.setText("");
			text.setEditable(false);
		} else if (e.getSource() == Exit) {
			System.exit(0);
		} else if (e.getSource() == Backtrack) {
			Label1.setText("Input a value to backtrack and replay");
			Label2.setVisible(true);
			Label2.setText(" previous commands in reverse order.");
			text.setEditable(true);
			direction = null;
		}

	}

	public void doit() {
		JFrame frame = new Gui();
		frame.setTitle("Finch");
		frame.setSize(400, 200);
		frame.setLocation(20, 120);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}