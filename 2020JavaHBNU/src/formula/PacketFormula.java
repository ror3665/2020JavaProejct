package formula;

import java.math.BigInteger;

public class PacketFormula {
	
	private static PacketFormula uniqueInstance = new PacketFormula(); //Singleton

	private PacketFormula() {
	}
	
	public static PacketFormula getInstance() {
		return uniqueInstance;
	}
	
	/**
	 * @param macAddress
	 * @return ���ּ� ���̿� �ݷ�(:)�� �߰���
	 */
	public String addColon(String macAddress) {
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
	 * @return 0x600 �̻��� Type ��
	 */
	public String distinguishIPversion(String typePacket) {
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
	 * @return ��������� ���ڸ� 16���� �� �� ù° �ڸ� (IP����)
	 */
	public String HeaderLengthFront(String headerLengthPacket) {
		String ipVersion = "" + headerLengthPacket.charAt(0);
		String binIPversion = binaryValue(ipVersion);
		return binIPversion;
	}

	/**
	 * @param headerLengthPacket
	 * @return ��������� ���ڸ� 16���� �� �� �ι�° �ڸ� (�������)
	 */
	public String HeaderLengthRear(String headerLengthPacket) {
		String headerLength = "" + headerLengthPacket.charAt(1);
		String binHeadLength = binaryValue(headerLength);
		return binHeadLength;
	}



	/**
	 * @param hexValue
	 * @return ���ڸ��� 16���� -> 2���� ��ȯ
	 */
	public String binaryValue(String hexValue) {
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
	 * @return 16���� ���ڸ����� byte������ ��ȯ
	 */
	public String calculateByte(char packet) {
		String packetStr = "" + packet;
		int hexValue = Integer.parseInt(packetStr);
		String byteResult = Integer.toString(hexValue * 4);
		return byteResult;
	}

	/**
	 * @param hexValue
	 * @return 16���� -> 10����
	 */
	public String decValue(String hexValue) {
		String decResult = "";
		int dec = new BigInteger(hexValue, 16).intValue();
		decResult = Integer.toString(Math.abs(dec));
		return decResult;
	}

	/**
	 * @param packet
	 * @return Fragment�� ���� ���� ����
	 */
	public String distinguishFlags(String packet) {
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
	 * @return �������� ����
	 */
	public String distinguishProtocol(String packet) {
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
	 * @return 16������ IP������ 10������ ��ȯ
	 */
	public String hexIPToDecIP(String packet) {
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
	
	/**
	 * @param headerLengthPacket
	 * @return TCP headerLengthPacket�� ������
	 */
	public String TCPHeaderLengthBin(String headerLengthPacket) {
		String headerLength = "" + headerLengthPacket.charAt(0);
		String binHeadLength = binaryValue(headerLength);
		return binHeadLength;
	}

	/**
	 * @param headerLengthPacket
	 * @return TCP ����� ����
	 */
	public String TCPHeaderLength(String headerLengthPacket) {
		String headerLength = "" + headerLengthPacket.charAt(0);
		String decHeaderLength = decValue(headerLength);
		int decHeaderInt = Integer.parseInt(decHeaderLength);
		return Integer.toString(decHeaderInt * 4);
	}

}
