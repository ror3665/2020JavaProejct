package project;

public class NodeUDPPacketHex {
	
	private String ID;
	private String length;
	private String uDPchecksum;
	private String data;
	
	public NodeUDPPacketHex(String ID, String length, String uDPchecksum, String data) {
		super();
		this.ID = ID;
		this.length = length;
		this.uDPchecksum = uDPchecksum;
		this.data = data;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getLength() {
		return length;
	}
	public String getUDPchecksum() {
		return uDPchecksum;
	}
	public String getData() {
		return data;
	}
}
