package interpretion;

import formula.PacketFormula;
import organization.SeparatedPacketNode;

public class IPHeaderStrategy implements InterpretableStrategy {

	@Override
	public String interpret(SeparatedPacketNode separatedPacketNode) {
		StringBuilder interpretedIPHeader = new StringBuilder();
		PacketFormula formula = PacketFormula.getInstance();

		int intFrame = Integer.parseInt(separatedPacketNode.getFrame());
		interpretedIPHeader.append("Frame " + separatedPacketNode.getID() + ": " + intFrame / 2 + " bytes on wire ("
				+ intFrame * 4 + " bits), " + intFrame / 2 + " bytes captured (" + intFrame * 4 + " bits)" + "\n");
		interpretedIPHeader.append("Destination Mac Address: " + "("
				+ formula.addColon(separatedPacketNode.getDestinationMacAddress()) + ")" + "\n");
		interpretedIPHeader.append("Source Mac Address: " + "("
				+ formula.addColon(separatedPacketNode.getSourceMacAddress()) + ")" + "\n");
		interpretedIPHeader.append("Type: " + formula.distinguishIPversion(separatedPacketNode.getiPVersion()) + " (0x"
				+ separatedPacketNode.getiPVersion() + ")" + "\n");
		interpretedIPHeader.append(formula.HeaderLengthFront(separatedPacketNode.getHeaderLength()) + ".... = Version: "
				+ separatedPacketNode.getHeaderLength().charAt(0) + "\n");
		interpretedIPHeader.append(".... " + formula.HeaderLengthRear(separatedPacketNode.getHeaderLength())
				+ " = Header Length: " + formula.calculateByte(separatedPacketNode.getHeaderLength().charAt(1))
				+ " bytes " + "(" + separatedPacketNode.getHeaderLength().charAt(1) + ")" + "\n");
		interpretedIPHeader
				.append("Type Of Service: " + formula.binaryValue(separatedPacketNode.getServiceType()) + "\n");
		interpretedIPHeader.append("Total Length: " + formula.decValue(separatedPacketNode.getTotalLength()) + "\n");
		interpretedIPHeader.append("Identification: " + "0x" + separatedPacketNode.getIdentification() + " ("
				+ formula.decValue(separatedPacketNode.getIdentification()) + ")" + "\n");
		interpretedIPHeader.append("Flags: " + "0x" + separatedPacketNode.getFlags() + " "
				+ formula.distinguishFlags(separatedPacketNode.getFlags()) + "\n");
		interpretedIPHeader.append("Time to live: " + formula.decValue(separatedPacketNode.getTimeToLive()) + "\n");
		interpretedIPHeader
				.append("Protocol: " + formula.distinguishProtocol(separatedPacketNode.getProcotolName()) + "\n");
		interpretedIPHeader.append("Header checksum: " + "0x" + separatedPacketNode.getHeaderChecksum() + "\n");
		interpretedIPHeader
				.append("Source IP address: " + formula.hexIPToDecIP(separatedPacketNode.getSourceIPAddress()) + "\n");
		interpretedIPHeader.append("Destination IP address :"
				+ formula.hexIPToDecIP(separatedPacketNode.getDestinationIPAddress()) + "\n");
		interpretedIPHeader.append("Source Port: " + formula.decValue(separatedPacketNode.getSourcePort()) + "\n");
		interpretedIPHeader
				.append("Destination Port: " + formula.decValue(separatedPacketNode.getDestinationPort()) + "\n");
		return interpretedIPHeader.toString();
	}

}
