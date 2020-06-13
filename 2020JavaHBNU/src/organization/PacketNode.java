package organization;

public class PacketNode {
	private String ProtocolType;
	private String value;

	public PacketNode(String protocolType, String value) {
		super();
		ProtocolType = protocolType;
		this.value = value;
	}
	
	public String getProtocolType() {
		return ProtocolType;
	}
	public String getValue() {
		return value;
	}
}
