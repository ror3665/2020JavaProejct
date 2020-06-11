package project;

public class NodeInterpretedUDP extends TransportProtocolComponent {
	private int ID;
	private String value;
	
	public NodeInterpretedUDP(int ID, String value) {
		this.ID = ID;
		this.value = value;
	}

	public int getID() {
		return ID;
	}
	public String getValue() {
		return value;
	}
	
	public String display() {
		return "\n" + getValue();
	}
	

}
