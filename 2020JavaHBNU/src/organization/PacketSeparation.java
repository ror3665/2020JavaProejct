package organization;

import java.util.ArrayList;
import java.util.Iterator;

public class PacketSeparation extends OrganizePacketDecorator {

	private ArrayList<?> spaceRemovedList;

	public PacketSeparation(OrganizePacket decoratedOrganizePacket) {
		super(decoratedOrganizePacket);
	}

	@Override
	public ArrayList<SeparatedPacketNode> organize() {
		spaceRemovedList = super.organize();
		return packetSeparation();
	}

	private ArrayList<SeparatedPacketNode> packetSeparation() {
		ArrayList<SeparatedPacketNode> separatedPacketList = new ArrayList<>();

		for (int i = 0; i < spaceRemovedList.size(); i++) {
			String packet = spaceRemovedList.get(i).toString();
			String frame = Integer.toString(packet.length());
			String destinationMacAddress = packet.substring(0, 12);
			String sourceMacAddress = packet.substring(12, 24);
			String iPVersion = packet.substring(24, 28);
			String headerLength = packet.substring(28, 30);
			String serviceType = packet.substring(30, 32);
			String totalLength = packet.substring(32, 36);
			String identification = packet.substring(36, 40);
			String flags = packet.substring(40, 44);
			String timeToLive = packet.substring(44, 46);
			String procotolName = packet.substring(46, 48);
			String headerChecksum = packet.substring(48, 52);
			String sourceIPAddress = packet.substring(52, 60);
			String destinationIPAddress = packet.substring(60, 68);
			String sourcePort = packet.substring(68, 72);
			String destinationPort = packet.substring(72, 76);

			if (procotolName.equals("06")) {
				String sequenceNumber = packet.substring(76, 84);
				String acknowledgmentNumber = packet.substring(84, 92);
				String tCPheaderLength = packet.substring(92, 94);
				String tCPflags = packet.substring(94, 96);
				String windowSizeValue = packet.substring(96, 100);
				String tCPchecksum = packet.substring(100, 104);
				String urgentPointer = packet.substring(104, 108);
				String optionOrData = "";
				if (packet.length() > 108)
					optionOrData = packet.substring(108, packet.length());;

					//Builder
					separatedPacketList.add(new SeparatedPacketNode
							.Builder(Integer.toString(i), frame, destinationMacAddress, sourceMacAddress, iPVersion, tCPheaderLength, serviceType, totalLength, identification, tCPflags, timeToLive, procotolName, headerChecksum, sourceIPAddress, destinationIPAddress, sourcePort, destinationPort)
							.sequenceNumber(sequenceNumber)
							.acknowledgmentNumber(acknowledgmentNumber)
							.tCPheaderLength(tCPheaderLength)
							.tCPflags(tCPflags)
							.windowSizeValue(windowSizeValue)
							.checksum(tCPchecksum)
							.urgentPointer(urgentPointer)
							.optionOrData(optionOrData)
							.build());
			} else if (procotolName.equals("11")) {

				String length = packet.substring(76, 80);
				String uDPchecksum = packet.substring(80, 84);
				String data = packet.substring(84, packet.length());

				//Builder
				separatedPacketList.add(new SeparatedPacketNode
						.Builder(Integer.toString(i), frame, destinationMacAddress, sourceMacAddress, iPVersion, headerLength, serviceType, totalLength, identification, flags, timeToLive, procotolName, headerChecksum, sourceIPAddress, destinationIPAddress, sourcePort, destinationPort)
						.length(length)
						.checksum(uDPchecksum)
						.data(data)
						.build());
			}
		}
		return separatedPacketList;
	}

	@Override
	public Iterator createIterator() {
		return null;
	}
}
