package project;

public class DisplayTCPonCommand implements Command {

	Interpreter interpreter;
	
	public DisplayTCPonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	@Override
	public String execute() {
		interpreter.displayTCP();
		return interpreter.displayTCP();
	}
}
