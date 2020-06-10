package project;

public class NodeBasicPackeHex {
	
	private String ID;
	private String frame;
	private String destinationMacAddress;
	private String sourceMacAddress;
	private String iPVersion;
	private String headerLength;
	private String serviceType;
	private String totalLength;
	private String identification;
	private String flags;
	private String timeToLive;
	private String procotolName;
	private String headerChecksum;
	private String sourceIPAddress;
	private String destinationIPAddress;
	private String sourcePort;
	private String destinationPort;
	
	public NodeBasicPackeHex(String ID, String frame, String destinationMacAddress, String sourceMacAddress, String iPVersion,
			String headerLength, String serviceType, String totalLength, String identification, String flags,
			String timeToLive, String procotolName, String headerChecksum, String sourceIPAddress,
			String destinationIPAddress, String sourcePort, String destinationPort) {
		super();
		this.ID = ID;
		this.frame = frame;
		this.destinationMacAddress = destinationMacAddress;
		this.sourceMacAddress = sourceMacAddress;
		this.iPVersion = iPVersion;
		this.headerLength = headerLength;
		this.serviceType = serviceType;
		this.totalLength = totalLength;
		this.identification = identification;
		this.flags = flags;
		this.timeToLive = timeToLive;
		this.procotolName = procotolName;
		this.headerChecksum = headerChecksum;
		this.sourceIPAddress = sourceIPAddress;
		this.destinationIPAddress = destinationIPAddress;
		this.sourcePort = sourcePort;
		this.destinationPort = destinationPort;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getFrame() {
		return frame;
	}
	
	public String getDestinationMacAddress() {
		return destinationMacAddress;
	}

	public String getSourceMacAddress() {
		return sourceMacAddress;
	}

	public String getiPVersion() {
		return iPVersion;
	}

	public String getHeaderLength() {
		return headerLength;
	}

	public String getServiceType() {
		return serviceType;
	}

	public String getTotalLength() {
		return totalLength;
	}

	public String getIdentification() {
		return identification;
	}

	public String getFlags() {
		return flags;
	}

	public String getTimeToLive() {
		return timeToLive;
	}

	public String getProcotolName() {
		return procotolName;
	}

	public String getHeaderChecksum() {
		return headerChecksum;
	}

	public String getSourceIPAddress() {
		return sourceIPAddress;
	}

	public String getDestinationIPAddress() {
		return destinationIPAddress;
	}

	public String getSourcePort() {
		return sourcePort;
	}

	public String getDestinationPort() {
		return destinationPort;
	}

}
