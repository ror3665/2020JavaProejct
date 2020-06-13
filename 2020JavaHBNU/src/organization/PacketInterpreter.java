package organization;

import java.util.ArrayList;
import java.util.Iterator;
import interpretion.IPHeaderStrategy;
import interpretion.InterpretableStrategy;
import interpretion.TCPStrategy;
import interpretion.UDPStrategy;

public class PacketInterpreter extends OrganizePacketDecorator {
	private InterpretableStrategy interpretableStrategy;
	private ArrayList<SeparatedPacketNode> separatedPacketList;
	private ArrayList<PacketNode> interpretedPacketList;

	public PacketInterpreter(OrganizePacket decoratedOrganizePacket) {
		super(decoratedOrganizePacket);

	}

	@Override
	public ArrayList<PacketNode> organize() {
		separatedPacketList = (ArrayList<SeparatedPacketNode>) super.organize();
		return interpretPacket();
	}

	private ArrayList<PacketNode> interpretPacket() {
	 interpretedPacketList = new ArrayList<>();
		StringBuilder interpretedPacket = new StringBuilder();

		for (int i = 0; i < separatedPacketList.size(); i++) {

			interpretableStrategy = new IPHeaderStrategy();
			interpretedPacket.append(interpretableStrategy.interpret(separatedPacketList.get(i)));

			if (separatedPacketList.get(i).getProcotolName().equals("06")) {
				interpretableStrategy = new TCPStrategy();
				interpretedPacket.append(interpretableStrategy.interpret(separatedPacketList.get(i)));
				interpretedPacketList.add(new PacketNode("TCP", interpretedPacket.toString()));
			} else if (separatedPacketList.get(i).getProcotolName().equals("11")) {
				interpretableStrategy = new UDPStrategy();
				interpretedPacket.append(interpretableStrategy.interpret(separatedPacketList.get(i)));
				interpretedPacketList.add(new PacketNode("UDP", interpretedPacket.toString()));
			}

			interpretedPacket.setLength(0); // set a stringBuffer size to '0' size

		}

		return interpretedPacketList;
	}

	@Override
	public Iterator createIterator() {
		return interpretedPacketList.iterator();
	}
}
