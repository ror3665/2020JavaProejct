package project;

public class NodeInterpretedTCP extends TransportProtocolComponent {
	private int ID;
	private String value;
	
	public NodeInterpretedTCP(int ID, String value) {
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
