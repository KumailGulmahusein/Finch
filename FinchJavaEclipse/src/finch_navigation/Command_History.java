package finch_navigation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Command_History {
	File CommandHistory = new File("CommandHistory.txt");
	String lines;

	private void recall(String Backtracks) throws IOException {
	try {
		int Time, WheelL, WheelR, Backtrackcount = Integer.parseInt(Backtracks);
		String direction;
		
		FileReader filereader = new FileReader(CommandHistory);
		BufferedReader bufferreader = new BufferedReader(filereader);
		Stack<String> commandlines = new Stack<String>();
		while ((lines = bufferreader.readLine()) != null) {
			commandlines.add(lines);
		}
		bufferreader.close();
		filereader.close();
		for (int i = 0; i < Backtrackcount; i++) {
			String[] splitter = commandlines.pop().split("\\ ");
			direction = splitter[0];
			Time = Integer.parseInt(splitter[1]);
			WheelL = Integer.parseInt(splitter[2]);
			WheelR = Integer.parseInt(splitter[3]);
			getcmdhistory(direction, Time, WheelL, WheelR);
		}
		PrintWriter writer = new PrintWriter(CommandHistory);
		writer.flush();
		writer.close();
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error! invalid input. Try again");
	}
}
	public void sethistory(String Logs) {

		try {
			if (!CommandHistory.exists()) {
				System.out.println("New text file created in folder.");
				CommandHistory.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(CommandHistory, true);

			BufferedWriter Writer = new BufferedWriter(fileWriter);
			Writer.write(Logs + "\n");
			Writer.close();

			System.out.println("Command Successful");
		} catch (IOException e) {
			System.out.println("Error, Command was unsuccessful! please retry.");
		}

	}

	public void setbacktracks(String backtracks) throws IOException {
		recall(backtracks);
	}

	public void getcmdhistory(String direction, int Time, int WheelL, int WheelR) {
		Finch_Code myf = new Finch_Code();
		myf.retrace(direction, Time, WheelL, WheelR);
	}
}