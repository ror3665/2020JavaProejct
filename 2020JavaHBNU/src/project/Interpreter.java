package project;

public class Interpreter {
	TransportProtocolComponent allInterpretedPackets;
	
	public Interpreter(TransportProtocolComponent allInterpretedPackets) {
		this.allInterpretedPackets = allInterpretedPackets;
	}
	
	public void display() {
		allInterpretedPackets.display();
	}
}
