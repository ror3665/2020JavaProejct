package command;

public class RawPacketOnCommand implements Command {

	Interpreter interpreter;

	public RawPacketOnCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public String execute() {
		return interpreter.getRawPacket();
	}

}
