package interpretion;

import formula.PacketFormula;
import organization.SeparatedPacketNode;

public class UDPStrategy implements InterpretableStrategy {

	@Override
	public String interpret(SeparatedPacketNode separatedPacketNode) {
		StringBuilder interpretedUDPpacket = new StringBuilder();
		PacketFormula formula = PacketFormula.getInstance();
		
		interpretedUDPpacket.append("Length: " + formula.decValue(separatedPacketNode.getLength()) + "\n");
		interpretedUDPpacket.append("Checksum: 0x" + separatedPacketNode.getChecksum() + "\n");
		interpretedUDPpacket.append("Data (" + (separatedPacketNode.getData().length() / 2) + " bytes): "
				+ separatedPacketNode.getData() + "\n");
		return interpretedUDPpacket.toString();
	}

}
