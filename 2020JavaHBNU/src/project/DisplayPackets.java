package project;

import java.util.Iterator;

public class DisplayPackets implements DisplayInterface {

	PacketIteratorInterface packetIterator;

	public DisplayPackets(PacketIteratorInterface packetIterator) {
		this.packetIterator = packetIterator;
	}

	@Override
	public void display() {
		Iterator displayAllPacaketsIterator = packetIterator.listofPackets();
		displayPackets(displayAllPacaketsIterator);
	}

	private void displayPackets(Iterator iterator) {
		int i = 1;
		while (iterator.hasNext()) {
			NodePacket node = (NodePacket)iterator.next();
			System.out.println("[" + i + "]" + ": " + node.getPacket());
			i++;
		}
		i = 1;
	}
}
