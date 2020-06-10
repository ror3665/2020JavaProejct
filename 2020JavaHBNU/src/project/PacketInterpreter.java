package project;

import java.math.BigInteger;
import java.util.ArrayList;

public class PacketInterpreter implements ProtocolInterface {

	private ArrayList<NodePacket> trimmedPacketList;
	private ArrayList<NodeBasicPackeHex> basicPacketList;
	private ArrayList<NodeTCPPacketHex> TCPPacketList;
	private ArrayList<NodeUDPPacketHex> UDPPacketList;

	/**
	 * 패킷 사이의 공백 제거
	 */
	public void trimSpacePacketList() {
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		trimmedPacketList = new ArrayList<>();
		TCPPacketList = new ArrayList<>();
		UDPPacketList = new ArrayList<>();

		for (int i = 0; i < hexFileInputStream.getPacketList().size(); i++) {
			String packet = hexFileInputStream.getPacketList().get(i).getPacket();
			packet = packet.replaceAll(" ", "");
			trimmedPacketList.add(new NodePacket(packet));
		}
	}

	@Override
	public void organizePacket() {

		String frame;
		String destinationMacAddress;
		String sourceMacAddress;
		String iPVersion;
		String headerLength;
		String serviceType;
		String totalLength;
		String identification;
		String flags;
		String timeToLive;
		String procotolName;
		String headerChecksum;
		String sourceIPAddress;
		String destinationIPAddress;
		String sourcePort;
		String destinationPort;

		basicPacketList = new ArrayList<>();

		for (int i = 0; i < trimmedPacketList.size(); i++) {
			String packet = trimmedPacketList.get(i).getPacket();
			frame = Integer.toString(packet.length());
			destinationMacAddress = packet.substring(0, 12);
			sourceMacAddress = packet.substring(12, 24);
			iPVersion = packet.substring(24, 28);
			headerLength = packet.substring(28, 30);
			serviceType = packet.substring(30, 32);
			totalLength = packet.substring(32, 36);
			identification = packet.substring(36, 40);
			flags = packet.substring(40, 44);
			timeToLive = packet.substring(44, 46);
			procotolName = packet.substring(46, 48);
			headerChecksum = packet.substring(48, 52);
			sourceIPAddress = packet.substring(52, 60);
			destinationIPAddress = packet.substring(60, 68);
			sourcePort = packet.substring(68, 72);
			destinationPort = packet.substring(72, 76);

			basicPacketList.add(new NodeBasicPackeHex(Integer.toString(i), frame, destinationMacAddress,
					sourceMacAddress, iPVersion, headerLength, serviceType, totalLength, identification, flags,
					timeToLive, procotolName, headerChecksum, sourceIPAddress, destinationIPAddress, sourcePort,
					destinationPort));

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
					optionOrData = packet.substring(108, packet.length());

				TCPPacketList.add(new NodeTCPPacketHex(Integer.toString(i), sequenceNumber, acknowledgmentNumber,
						tCPheaderLength, tCPflags, windowSizeValue, tCPchecksum, urgentPointer, optionOrData));
				UDPPacketList.add(new NodeUDPPacketHex(Integer.toString(i), null, null, null));
			} else if (procotolName.equals("11")) {
				String length = packet.substring(76, 80);
				String uDPchecksum = packet.substring(80, 84);
				String data = packet.substring(84, packet.length());

				UDPPacketList.add(new NodeUDPPacketHex(Integer.toString(i), length, uDPchecksum, data));
				TCPPacketList
						.add(new NodeTCPPacketHex(Integer.toString(i), null, null, null, null, null, null, null, null));
			}
		}
	}

	@Override
	public void packetBasicInterpreter() {
		for (int i = 0; i < basicPacketList.size(); i++) {
			int intFrame = Integer.parseInt(basicPacketList.get(i).getFrame());
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Frame " + basicPacketList.get(i).getID() + ": " + intFrame / 2 + " bytes on wire ("
					+ intFrame * 4 + " bits), " + intFrame / 2 + " bytes captured (" + intFrame * 4 + " bits)");
			System.out.println("Destination Mac Address: " + "("
					+ addColon(basicPacketList.get(i).getDestinationMacAddress()) + ")");
			System.out.println(
					"Source Mac Address: " + "(" + addColon(basicPacketList.get(i).getSourceMacAddress()) + ")");
			System.out.println("Type: " + distinguishIPversion(basicPacketList.get(i).getiPVersion()) + " (0x"
					+ basicPacketList.get(i).getiPVersion() + ")");
			System.out.println(HeaderLengthFront(basicPacketList.get(i).getHeaderLength()) + ".... = Version: "
					+ basicPacketList.get(i).getHeaderLength().charAt(0));
			System.out.println(".... " + HeaderLengthRear(basicPacketList.get(i).getHeaderLength())
					+ " = Header Length: " + calculateByte(basicPacketList.get(i).getHeaderLength().charAt(1))
					+ " bytes " + "(" + basicPacketList.get(i).getHeaderLength().charAt(1) + ")");
			System.out.println("Type Of Service: " + binaryValue(basicPacketList.get(i).getServiceType()));
			System.out.println("Total Length: " + decValue(basicPacketList.get(i).getTotalLength()));
			System.out.println("Identification: " + "0x" + basicPacketList.get(i).getIdentification() + " ("
					+ decValue(basicPacketList.get(i).getIdentification()) + ")");
			System.out.println("Flags: " + "0x" + basicPacketList.get(i).getFlags() + " "
					+ distinguishFlags(basicPacketList.get(i).getFlags()));
			System.out.println("Time to live: " + decValue(basicPacketList.get(i).getTimeToLive()));
			System.out.println("Protocol: " + distinguishProtocol(basicPacketList.get(i).getProcotolName()));
			System.out.println("Header checksum: " + "0x" + basicPacketList.get(i).getHeaderChecksum());
			System.out.println("Source IP address: " + hexIPToDecIP(basicPacketList.get(i).getSourceIPAddress()));
			System.out.println(
					"Destination IP address :" + hexIPToDecIP(basicPacketList.get(i).getDestinationIPAddress()));
			System.out.println("Source Port: " + decValue(basicPacketList.get(i).getSourcePort()));
			System.out.println("Destination Port: " + decValue(basicPacketList.get(i).getDestinationPort()));

			if (basicPacketList.get(i).getProcotolName().equals("06"))
				packetTCPInterpreter(Integer.parseInt(basicPacketList.get(i).getID()));
			else if (basicPacketList.get(i).getProcotolName().equals("11"))
			packetUDPInterpreter(Integer.parseInt(basicPacketList.get(i).getID()));
		}
	}

	@Override
	public void packetTCPInterpreter(int index) {
		int i = index;
		System.out.println("Sequence number (raw): " + decValue(TCPPacketList.get(i).getSequenceNumber()));
		System.out.println("Acknowledgment number (raw): " + decValue(TCPPacketList.get(i).getAcknowledgmentNumber()));
		System.out.println(TCPHeaderLengthBin(TCPPacketList.get(i).getSequenceNumber()) + " .... = Header Length:"
				+ TCPHeaderLength(TCPPacketList.get(i).getSequenceNumber()) + "bytes");
		System.out.println("Flags: 0x" + TCPPacketList.get(i).gettCPflags());
		System.out.println("Window size value: " + decValue(TCPPacketList.get(i).getWindowSizeValue()));
		System.out.println("Urgent pointer: " + decValue(TCPPacketList.get(i).getUrgentPointer()));
		if (TCPPacketList.get(i).getOptionOrData() != null)
			System.out.println("Option|data: " + TCPPacketList.get(i).getOptionOrData());
	}

	@Override
	public void packetUDPInterpreter(int index) {
		int i = index;
		
		System.out.println("Length: " + decValue(UDPPacketList.get(i).getLength()));
		System.out.println("Checksum: 0x" + UDPPacketList.get(i).getUDPchecksum());
		System.out.println("Data ("+ (UDPPacketList.get(i).getData().length()/2) + " bytes): " + UDPPacketList.get(i).getData());

	}

	/**
	 * @param macAddress
	 * @return 맥주소 사이에 콜론(:)을 추가함
	 */
	private String addColon(String macAddress) {
		String designedMacAddress = "" + macAddress.charAt(0) + macAddress.charAt(1);
		for (int i = 2; i <= macAddress.length() - 1; i++) {
			if (i % 2 == 0)
				designedMacAddress += ":" + macAddress.charAt(i);
			else
				designedMacAddress += macAddress.charAt(i);
		}
		return designedMacAddress;
	}

	/**
	 * @param typePacket
	 * @return 0x600 이상의 Type 값
	 */
	private String distinguishIPversion(String typePacket) {
		String type = "";
		if (typePacket.equals("0800"))
			type = "IPv4";
		else if (typePacket.equals("86DD"))
			type = "IPv6";
		else if (typePacket.equals("8191"))
			type = "NetBIOS";
		else if (typePacket.equals("0600"))
			type = "Xerox XNS IDP";
		else if (typePacket.equals("0805"))
			type = "X.25";
		else if (typePacket.equals("0806"))
			type = "ARP";
		else if (typePacket.equals("0835"))
			type = "RARP";
		else if (typePacket.equals("6003"))
			type = "DEC DECnet Phase IV";
		else if (typePacket.equals("8137"))
			type = "Novell Netware IPX";
		else if (typePacket.equals("8847"))
			type = "MPLS";
		else if (typePacket.equals("8863"))
			type = "PPPoE Discovery Stage";
		else if (typePacket.equals("8864"))
			type = "PPPoE PPP Session Stage";
		return type;
	}

	/**
	 * @param headerLengthPacket
	 * @return 헤더길이의 두자리 16진수 값 중 첫째 자리 (IP정보)
	 */
	private String HeaderLengthFront(String headerLengthPacket) {
		String ipVersion = "" + headerLengthPacket.charAt(0);
		String binIPversion = binaryValue(ipVersion);
		return binIPversion;
	}

	/**
	 * @param headerLengthPacket
	 * @return 헤더길이의 두자리 16진수 값 중 두번째 자리 (헤더길이)
	 */
	private String HeaderLengthRear(String headerLengthPacket) {
		String headerLength = "" + headerLengthPacket.charAt(1);
		String binHeadLength = binaryValue(headerLength);
		return binHeadLength;
	}

	/**
	 * @param headerLengthPacket
	 * @return TCP headerLengthPacket의 이진값
	 */
	private String TCPHeaderLengthBin(String headerLengthPacket) {
		String headerLength = "" + headerLengthPacket.charAt(0);
		String binHeadLength = binaryValue(headerLength);
		return binHeadLength;
	}

	private String TCPHeaderLength(String headerLengthPacket) {
		String headerLength = "" + headerLengthPacket.charAt(0);
		String decHeaderLength = decValue(headerLength);
		int decHeaderInt = Integer.parseInt(decHeaderLength);
		return Integer.toString(decHeaderInt * 4);
	}

	/**
	 * @param hexValue
	 * @return 한자리의 16진수 -> 2진수 변환
	 */
	private String binaryValue(String hexValue) {
		String binaryResult = "";
		int dec = Integer.parseInt(hexValue, 16);
		String binaryValue = Integer.toBinaryString(dec);
		if (hexValue.length() == 1) {
			binaryResult = String.format("%04d", Integer.parseInt(binaryValue));
		} else if (hexValue.length() == 2) {
			binaryResult = String.format("%08d", Integer.parseInt(binaryValue));
		}
		return binaryResult;
	}

	/**
	 * @param packet
	 * @return 16진수 한자리값을 byte값으로 변환
	 */
	private String calculateByte(char packet) {
		String packetStr = "" + packet;
		int hexValue = Integer.parseInt(packetStr);
		String byteResult = Integer.toString(hexValue * 4);
		return byteResult;
	}

	/**
	 * @param hexValue
	 * @return 16진수 -> 10진수
	 */
	private String decValue(String hexValue) {
		String decResult = "";
		int dec = new BigInteger(hexValue, 16).intValue();
		decResult = Integer.toString(Math.abs(dec));
		return decResult;
	}

	/**
	 * @param packet
	 * @return Fragment에 관한 정보 리턴
	 */
	private String distinguishFlags(String packet) {
		String fragment = "";
		if (packet.equals("4000"))
			fragment = "Don't fragment";
		else if (packet.equals("0000"))
			fragment = "";
		else if (packet.endsWith("2000"))
			fragment = "More fragment";
		else
			fragment = "";
		return fragment;
	}

	/**
	 * @param packet
	 * @return 프로토콜 구별
	 */
	private String distinguishProtocol(String packet) {
		String decValue = decValue(packet);
		String protocol = "";

		if (decValue.equals("6"))
			protocol = "TCP";
		else if (decValue.equals("17"))
			protocol = "UDP";
		else
			protocol = packet;
		return protocol;
	}

	/**
	 * @param packet
	 * @return 16진수의 IP정보를 10진수로 변환
	 */
	private String hexIPToDecIP(String packet) {
		String ipAddress = "";
		StringBuffer sb = new StringBuffer();

		String[] strArr = new String[4];
		strArr[0] = packet.substring(0, 2);
		strArr[1] = packet.substring(2, 4);
		strArr[2] = packet.substring(4, 6);
		strArr[3] = packet.substring(6, 8);

		for (int i = 0; i < strArr.length; i++) {
			sb.append(decValue(strArr[i]) + ".");
		}
		sb.deleteCharAt(sb.length() - 1);
		ipAddress = sb.toString();

		return ipAddress;
	}
}
