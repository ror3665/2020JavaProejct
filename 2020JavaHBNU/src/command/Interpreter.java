package command;

import java.util.Iterator;
import organization.PacketNode;
import organization.PacketIterator;

public class Interpreter {

	private PacketIterator rawPacket;
	private PacketIterator interpretedPacket;

	public Interpreter(PacketIterator rawPacket, PacketIterator interpretedPacket) {
		this.rawPacket = rawPacket;
		this.interpretedPacket = interpretedPacket;
	}
	

	public String getRawPacket() {
		Iterator rawPacketIterator = rawPacket.createIterator();
		return getRawPacket(rawPacketIterator);
	}

	public String getTCPPacket() {
		Iterator interpretedPacketIterator = interpretedPacket.createIterator();
		return getTCPPacket(interpretedPacketIterator);
	}

	public String getUDPPacket() {
		Iterator interpretedPacketIterator = interpretedPacket.createIterator();
		return getUDPPacket(interpretedPacketIterator);
	}

	public String getAllInterpretedPacket() {
		Iterator interpretedPacketIterator = interpretedPacket.createIterator();
		return getAllInterpretedPacket(interpretedPacketIterator);
	}

	/* private */
	private String getRawPacket(Iterator iterator) {
		StringBuilder sb = new StringBuilder();

		while (iterator.hasNext()) {
			PacketNode packetNode = (PacketNode) iterator.next();
			sb.append(packetNode.getValue() + "\n");
		}

		return sb.toString();
	}

	private String getTCPPacket(Iterator iterator) {
		StringBuilder sb = new StringBuilder();

		while (iterator.hasNext()) {
			PacketNode packetNode = (PacketNode) iterator.next();
			if (packetNode.getProtocolType().equals("TCP"))
				sb.append(packetNode.getValue() + "\n");
		}

		return sb.toString();
	}

	private String getUDPPacket(Iterator iterator) {
		StringBuilder sb = new StringBuilder();

		while (iterator.hasNext()) {
			PacketNode packetNode = (PacketNode) iterator.next();
			if (packetNode.getProtocolType().equals("UDP"))
				sb.append(packetNode.getValue() + "\n");
		}

		return sb.toString();
	}

	private String getAllInterpretedPacket(Iterator iterator) {
		StringBuilder sb = new StringBuilder();

		while (iterator.hasNext()) {
			PacketNode packetNode = (PacketNode) iterator.next();
			sb.append(packetNode.getValue() + "\n");
		}

		return sb.toString();
	}
}
