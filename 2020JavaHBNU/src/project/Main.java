package project;

public class Main {

	public static void main(String[] args) {
		
		String path = "C:/wireshark/sample.txt";
		
		MenuItem menuItem = new MenuItem();
		Interpreter interpreter = new Interpreter(path);
		
		DisplayHexBinaryOnCommand displayHexBinaryOnCommand = new DisplayHexBinaryOnCommand(interpreter);
		DisplayTCPnUDPonCommand displayTCPnUDPonCommand = new DisplayTCPnUDPonCommand(interpreter);
		DisplayTCPonCommand displayTCPonCommand = new DisplayTCPonCommand(interpreter);
		DisplayUDPonCommand displayUDPonCommand = new DisplayUDPonCommand(interpreter);
		
		menuItem.setCommand(0, displayHexBinaryOnCommand);
		menuItem.setCommand(1, displayTCPnUDPonCommand);
		menuItem.setCommand(2, displayTCPonCommand);
		menuItem.setCommand(3, displayUDPonCommand);
		
		//menuItem.onButtonWasPushed(0);
		menuItem.onButtonWasPushed(0);

	}

}
