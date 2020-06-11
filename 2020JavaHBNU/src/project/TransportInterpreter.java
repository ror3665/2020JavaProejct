package project;


public class TransportInterpreter implements DisplayInterface {
	TransportProtocolComponent allInterpretedPackets;
	
	public TransportInterpreter(TransportProtocolComponent allInterpretedPackets) {
		this.allInterpretedPackets = allInterpretedPackets;
	}
	
	@Override
	public String display() {
		return allInterpretedPackets.display();
	}
}
