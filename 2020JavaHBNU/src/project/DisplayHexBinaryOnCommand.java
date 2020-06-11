package project;

public class DisplayHexBinaryOnCommand implements Command {

	Interpreter interpreter;
	
	public DisplayHexBinaryOnCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public String execute() {
			return interpreter.displayHexBinary();
	}

}
