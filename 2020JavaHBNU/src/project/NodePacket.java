package project;

public class NodePacket extends TransportProtocolComponent {
	
	private int ID;
	private String value;

	public NodePacket(int ID, String value) {
		super();
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
