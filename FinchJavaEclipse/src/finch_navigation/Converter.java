package finch_navigation;

import javax.swing.JOptionPane;

import finch_navigation.Error_Handling;

public class Converter {

	private void converter(String userinput, String direction) {
		try {
			int Time, WheelL, WheelR;
			String[] splitter = userinput.split("\\ ");

			if (direction == "L" || direction == "R") {

				Time = Integer.parseInt(splitter[0]);
				WheelL = Integer.parseInt(splitter[1]);
				WheelR = Integer.parseInt(splitter[2]);
				WheelL = (WheelL * 255) / 100;
				WheelR = (WheelR * 255) / 100;
				Time = Time * 1000;
			} else {
				Time = Integer.parseInt(splitter[0]);
				WheelL = Integer.parseInt(splitter[1]);
				WheelL = (WheelL * 255) / 100;
				WheelR = WheelL;
				Time = Time * 1000;
			}
			errinput(direction, Time, WheelL, WheelR);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error invalid input! Please try agin and reread the instructions");
		}
	}

	public void setinput(String userinput, String direction) {
		converter(userinput, direction);
	}

	public void errinput(String direction, int Time, int WheelL, int WheelR) {
		Error_Handling error = new Error_Handling();
		error.newerror(direction, Time, WheelL, WheelR);
	}
}