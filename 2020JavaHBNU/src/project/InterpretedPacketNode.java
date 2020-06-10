package project;

public class InterpretedPacketNode {

	private int ID;
	private String value;

	public InterpretedPacketNode(int iD, String value) {
		super();
		ID = iD;
		this.value = value;
	}

	public int getID() {
		return ID;
	}

	public String getValue() {
		return value;
	}
}
