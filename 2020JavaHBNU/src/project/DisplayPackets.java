package project;

import java.util.Iterator;

public class DisplayPackets implements DisplayInterface {

	PacketIteratorInterface packetIterator;

	public DisplayPackets(PacketIteratorInterface packetIterator) {
		this.packetIterator = packetIterator;
	}

	@Override
	public String display() {
		Iterator displayAllPacaketsIterator = packetIterator.listofPackets();
		return displayPackets(displayAllPacaketsIterator);
	}

	/**
	 * @param iterator
	 * @return 순서가 붙어있는 Hex binary
	 */
	private String displayPackets(Iterator iterator) {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (iterator.hasNext()) {
			NodePacket node = (NodePacket)iterator.next();
			sb.append("[" + i + "]" + ": " + node.getPacket() +"\n");
			i++;
		}
		i = 1;
		return sb.toString();
	}
}
