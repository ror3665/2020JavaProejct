package organization;

public class SeparatedPacketNode {

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
	
	//TCP
	private String sequenceNumber;
	private String acknowledgmentNumber;
	private String tCPheaderLength;
	private String tCPflags;
	private String windowSizeValue;
	private String urgentPointer;
	private String optionOrData;
	
	//UDP
	private String length;
	private String data;
	
	//common
	private String checksum;

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

	public String getUrgentPointer() {
		return urgentPointer;
	}

	public String getOptionOrData() {
		return optionOrData;
	}

	public String getLength() {
		return length;
	}

	public String getData() {
		return data;
	}

	public String getChecksum() {
		return checksum;
	}
	
	public static class Builder {
		//Required parameters
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
		
		//Optional parameters
		//TCP
		private String sequenceNumber = null;
		private String acknowledgmentNumber = null;
		private String tCPheaderLength = null;
		private String tCPflags = null;
		private String windowSizeValue = null;
		private String urgentPointer = null;
		private String optionOrData = null;
		
		//UDP
		private String length = null;
		private String data = null;
		
		//common
		private String checksum = null;
		
		public Builder(String iD, String frame, String destinationMacAddress, String sourceMacAddress, String iPVersion,
				String headerLength, String serviceType, String totalLength, String identification, String flags,
				String timeToLive, String procotolName, String headerChecksum, String sourceIPAddress,
				String destinationIPAddress, String sourcePort, String destinationPort) {
			super();
			ID = iD;
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
		
		public Builder sequenceNumber(String val) {
			sequenceNumber = val;
			return this;
		}
		
		public Builder acknowledgmentNumber(String val) {
			acknowledgmentNumber = val;
			return this;
		}
		
		public Builder tCPheaderLength(String val) {
			tCPheaderLength = val;
			return this;
		}
		
		public Builder tCPflags(String val) {
			tCPflags = val;
			return this;
		}
		
		public Builder windowSizeValue(String val) {
			windowSizeValue = val;
			return this;
		}
		
		public Builder urgentPointer(String val) {
			urgentPointer = val;
			return this;
		}
		
		public Builder optionOrData(String val) {
			optionOrData = val;
			return this;
		}
		
		public Builder length(String val) {
			length = val;
			return this;
		}
		
		public Builder data(String val) {
			data = val;
			return this;
		}
		
		public Builder checksum(String val) {
			checksum = val;
			return this;
		}
		
		public SeparatedPacketNode build() {
			return new SeparatedPacketNode(this);
		}
		
	}
		private SeparatedPacketNode(Builder builder) {
			 this.ID = builder.ID;
			 this.frame = builder.frame;
			 this.destinationMacAddress = builder.destinationMacAddress;
			 this.sourceMacAddress = builder.sourceMacAddress;
			 this.iPVersion = builder.iPVersion;
			 this.headerLength = builder.headerLength;
			 this.serviceType = builder.serviceType;
			 this.totalLength = builder.totalLength;
			 this.identification = builder.identification;
			 this.flags = builder.flags;
			 this.timeToLive = builder.timeToLive;
			 this.procotolName = builder.procotolName;
			 this.headerChecksum = builder.headerChecksum;
			 this.sourceIPAddress = builder.sourceIPAddress;
			 this.destinationIPAddress = builder.destinationIPAddress;
			 this.sourcePort = builder.sourcePort;
			 this.destinationPort = builder.destinationPort;
			 this.sequenceNumber = builder.sequenceNumber;
			 this.acknowledgmentNumber = builder.acknowledgmentNumber;
			 this.tCPheaderLength = builder.tCPheaderLength;
			 this.tCPflags = builder.tCPflags;
			 this.windowSizeValue = builder.windowSizeValue;
			 this.urgentPointer = builder.urgentPointer;
			 this.optionOrData = builder.optionOrData;
			 this.length = builder.length;
			 this.data = builder.data;
			 this.checksum = builder.checksum;
		}
	
}
