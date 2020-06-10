package project;

public class DisplayUDPonCommand implements Command {

	Interpreter interpreter;
	
	public DisplayUDPonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	@Override
	public void execute() {
		interpreter.displayUDP();
	}
}
