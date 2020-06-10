package project;

public class DisplayTCPonCommand implements Command {

	Interpreter interpreter;
	
	public DisplayTCPonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	@Override
	public void execute() {
		interpreter.displayTCP();
	}
}
