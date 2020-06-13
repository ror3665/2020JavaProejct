package organization;

import java.util.ArrayList;
import java.util.Iterator;

import io.HexFileInputStream;

public class HexFile extends OrganizePacket{
	private ArrayList<PacketNode> packetList;
	
	@Override
	public ArrayList<PacketNode> organize() {
		packetList = new ArrayList<>();
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		
//		try {
//			hexFileInputStream.openHexFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	
		hexFileInputStream.getPacketList().size();
		for(int i=0; i<hexFileInputStream.getPacketList().size(); i++) {
			packetList.add(new PacketNode("RAW", hexFileInputStream.getPacketList().get(i)));
		}
		return packetList;
	}
	
	@Override
	public Iterator createIterator() {
		return packetList.iterator();
	}
}
