package finch_navigation;

import javax.swing.JOptionPane;
import finch_navigation.Command_History;
import finch_navigation.Finch_Code;

public class Error_Handling {
	private void error(String direction, int Time, int WheelL, int WheelR) {
		String command = direction + " " + Time + " " + WheelL + " " + WheelR;

		if (Time > 6000) {
			JOptionPane.showMessageDialog(null, "Duration value out of bounds(0 - 6)");
		} else if (WheelL > 255 || WheelR > 255 || WheelL < 0 || WheelR < 0) {
			JOptionPane.showMessageDialog(null, "Speed value out of bounds (0 - 100)");
		} else {
			switch (direction) {
			case "L":
			case "R":
				if (WheelL == WheelR) {
					JOptionPane.showMessageDialog(null, "For 'Left' or 'Right' commands, second and third value must vary");
				} else
					errinput(direction, Time, WheelL, WheelR, command);
				break;
			case "F":
			case "B":
				errinput(direction, Time, WheelL, WheelR, command);
				break;
			}
		}
	}

	public void newerror(String direction, int Time, int WheelL, int WheelR) {
		error(direction, Time, WheelL, WheelR);
	}

	public void errinput(String direction, int Time, int WheelL, int WheelR, String command) {
		Finch_Code myf = new Finch_Code();
		myf.move(direction, Time, WheelL, WheelR);
		Command_History sethistory = new Command_History();
		sethistory.sethistory(command);
	}
}