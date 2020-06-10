package project;

public class DisplayHexBinaryOnCommand implements Command {

	Interpreter interpreter;
	
	public DisplayHexBinaryOnCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public void execute() {
	
			interpreter.displayHexBinary();
	}

}
