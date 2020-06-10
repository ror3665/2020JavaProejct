package project;

public class NodeTCPPacketHex {
	
	private String ID;
	private String sequenceNumber;
	private String acknowledgmentNumber;
	private String tCPheaderLength;
	private String tCPflags;
	private String windowSizeValue;
	private String tCPchecksum;
	private String urgentPointer;
	private String optionOrData;

	public NodeTCPPacketHex(String ID, String sequenceNumber, String acknowledgmentNumber, String tCPheaderLength, String tCPflags,
			String windowSizeValue, String tCPchecksum, String urgentPointer, String optionOrData) {
		super();
		this.ID = ID;
		this.sequenceNumber = sequenceNumber;
		this.acknowledgmentNumber = acknowledgmentNumber;
		this.tCPheaderLength = tCPheaderLength;
		this.tCPflags = tCPflags;
		this.windowSizeValue = windowSizeValue;
		this.tCPchecksum = tCPchecksum;
		this.urgentPointer = urgentPointer;
		this.optionOrData = optionOrData;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public String getAcknowledgmentNumber() {
		return acknowledgmentNumber;
	}

	public String gettCPheaderLength() {
		return tCPheaderLength;
	}

	public String gettCPflags() {
		return tCPflags;
	}

	public String getWindowSizeValue() {
		return windowSizeValue;
	}

	public String gettCPchecksum() {
		return tCPchecksum;
	}

	public String getUrgentPointer() {
		return urgentPointer;
	}

	public String getOptionOrData() {
		return optionOrData;
	}
}
