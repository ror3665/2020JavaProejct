package project;

import java.util.Iterator;

public class DisplayPackets {

	PacketIteratorInterface packetIterator;

	public DisplayPackets(PacketIteratorInterface packetIterator) {
		this.packetIterator = packetIterator;
	}

	public void displayAllPackets() {
		Iterator displayAllPacaketsIterator = packetIterator.listofPackets();
		displayPackets(displayAllPacaketsIterator);
	}

	private void displayPackets(Iterator iterator) {
		while (iterator.hasNext()) {
			NodePacket node = (NodePacket)iterator.next();
			System.out.println(node.getPacket());
		}
	}
}
