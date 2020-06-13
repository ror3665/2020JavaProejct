package command;

public class TCPonCommand implements Command {

	Interpreter interpreter;
	
	public TCPonCommand(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	@Override
	public String execute() {
		return interpreter.getTCPPacket();
	}
}
