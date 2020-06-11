package project;


public class TransportInterpreterItem extends TransportProtocolComponent{
	TransportProtocolComponent allInterpretedPackets;
	
	public TransportInterpreterItem(TransportProtocolComponent allInterpretedPackets) {
		this.allInterpretedPackets = allInterpretedPackets;
	}
	
	public String display() {
		return allInterpretedPackets.display();
	}
}
