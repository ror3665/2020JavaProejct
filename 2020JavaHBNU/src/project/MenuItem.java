package project;

public class MenuItem {
	Command[] commands;
	
	public MenuItem() {
		commands = new Command[4];
		
		Command noCommand =  new NoCommand();
		for(int i =0; i<4; i++) {
			commands[i] = noCommand; 
		}
	}
	
	public void setCommand(int slot, Command command) {
		commands[slot] = command;
	}
	
	public String onButtonWasPushed(int slot) {
		return commands[slot].execute();
	}
}
