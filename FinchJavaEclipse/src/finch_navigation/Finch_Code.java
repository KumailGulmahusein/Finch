package finch_navigation;

import com.birdbraintechnologies.Finch;

public class Finch_Code {

	private void Movement(String direction, int Time, int WheelL, int WheelR) {
		Finch myfinch = new Finch();

		switch (direction) {
		case "F":
			myfinch.setWheelVelocities(WheelL, WheelR, Time);
			break;
		case "B":
			myfinch.setWheelVelocities(-WheelL, -WheelR, Time);
			break;
		case "R":
			if (WheelL > WheelR)
				myfinch.setWheelVelocities(WheelL, WheelR, Time);
			else
				myfinch.setWheelVelocities(WheelR, WheelL, Time);
			break;
		case "L":
			if (WheelL > WheelR)
				myfinch.setWheelVelocities(WheelR, WheelL, Time);
			else
				myfinch.setWheelVelocities(WheelL, WheelR, Time);
			break;
		}
	}

	public void move(String direction, int Time, int WheelL, int WheelR) {
		Movement(direction, Time, WheelL, WheelR);
	}
	
	public void retrace(String direction, int Time, int WheelL, int WheelR) {
		Movement(direction, Time, WheelL, WheelR);
	}
}