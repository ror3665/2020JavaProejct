package project;

public class NodeInterpretedPacket {

	private int ID;
	private String value;

	public NodeInterpretedPacket(int iD, String value) {
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
