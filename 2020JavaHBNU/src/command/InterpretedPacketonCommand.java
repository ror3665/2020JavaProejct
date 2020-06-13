package command;

public class InterpretedPacketonCommand implements Command {

	Interpreter interpreter;
	
	public InterpretedPacketonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public String execute() {
		return interpreter.getAllInterpretedPacket();
	}
}
