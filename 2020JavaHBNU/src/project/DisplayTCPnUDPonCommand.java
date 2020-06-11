package project;


public class DisplayTCPnUDPonCommand implements Command {

	Interpreter interpreter;
	
	public DisplayTCPnUDPonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public String execute() {
		return interpreter.displayTCPnUDP();
	}
}
