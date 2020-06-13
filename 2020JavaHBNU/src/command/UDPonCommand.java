package command;


public class UDPonCommand implements Command {

	Interpreter interpreter;

	public UDPonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public String execute() {
		return interpreter.getUDPPacket();
	}
}
