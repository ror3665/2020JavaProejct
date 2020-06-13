package organization;
/* 패킷사이의 공백 제거*/

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveSpace extends OrganizePacketDecorator {

	private ArrayList<PacketNode> packetList;
	
	public RemoveSpace(OrganizePacket decoratedOrganizePacket) {
		super(decoratedOrganizePacket);
	}

	@Override
	public ArrayList<String> organize() {
		packetList = (ArrayList<PacketNode>) super.organize();
		return removeSpace();
	}

	private ArrayList<String> removeSpace() {
		ArrayList<String> spaceRemovedList;
	
		spaceRemovedList = new ArrayList<>();
		int size = packetList.size();
		for (int i = 0; i < size; i++) {
			String packet = packetList.get(i).getValue();
			packet = packet.replaceAll(" ", "");
			spaceRemovedList.add(packet);
		}
		return spaceRemovedList;
	}

	@Override
	public Iterator createIterator() {
		return null;
	}
}
