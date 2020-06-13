package interpretion;

import formula.PacketFormula;
import organization.SeparatedPacketNode;

public class TCPStrategy implements InterpretableStrategy {

	@Override
	public String interpret(SeparatedPacketNode separatedPacketNode) {
		StringBuilder interpretedTCPpacket = new StringBuilder();
		PacketFormula formula = PacketFormula.getInstance();

		interpretedTCPpacket
				.append("Sequence number (raw): " + formula.decValue(separatedPacketNode.getSequenceNumber()) + "\n");
		interpretedTCPpacket.append(
				"Acknowledgment number (raw): " + formula.decValue(separatedPacketNode.getAcknowledgmentNumber()) + "\n");
		interpretedTCPpacket.append(formula.TCPHeaderLengthBin(separatedPacketNode.getSequenceNumber())
				+ " .... = Header Length:" + formula.TCPHeaderLength(separatedPacketNode.getSequenceNumber()) + "bytes" + "\n");
		interpretedTCPpacket.append("Flags: 0x" + separatedPacketNode.gettCPflags() + "\n");
		interpretedTCPpacket.append("Window size value: " + formula.decValue(separatedPacketNode.getWindowSizeValue()) + "\n");
		interpretedTCPpacket.append("Checksum: 0x" + separatedPacketNode.getChecksum() + "\n");
		interpretedTCPpacket.append("Urgent pointer: " + formula.decValue(separatedPacketNode.getUrgentPointer()) + "\n");

		if (separatedPacketNode.getOptionOrData() != null)
			interpretedTCPpacket.append("Option|data: " + separatedPacketNode.getOptionOrData() + "\n");

		return interpretedTCPpacket.toString();
	}

}
