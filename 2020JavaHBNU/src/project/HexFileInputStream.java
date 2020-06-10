package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HexFileInputStream implements PacketIteratorInterface {
	private static HexFileInputStream uniqueInstance = new HexFileInputStream(); //Singleton
	private ArrayList<NodePacket> packetList;
	
	private HexFileInputStream() {
		packetList = new ArrayList<>();
	}
	
	public static HexFileInputStream getInstance() {
		return uniqueInstance;
	}

	/** Import Hex text file from local drive
	 * @throws IOException
	 */
	public void savePacketsfromFile() throws IOException {

		String sLine = null;
		StringBuilder sb = new StringBuilder();
		
		File file = new File("C:/wireshark/sample.txt");
		if (file.exists()) {
			BufferedReader inFile = new BufferedReader(new FileReader(file));
			while ((sLine = inFile.readLine()) != null) {
				if (sLine.equals("")) {
					addPacket(sb);
					sb.delete(0, sb.length());
				} else
					sb.append(trimUpPacket(sLine));
			}
			addPacket(sb);
			inFile.close();
		}
	}

	/**
	 * @param 하나의 패킷라인을 컬렉션에 저장
	 */
	private void addPacket(StringBuilder sb) {
		String newLine = sb.toString();
		packetList.add(new NodePacket(newLine));
	}

	/**
	 * @param sLine
	 * @return 정리된 newLine
	 */
	private String trimUpPacket(String sLine) {
		int indexOfEnd = sLine.indexOf("   ");
		return sLine.substring(6, indexOfEnd) + " ";
	}

	public ArrayList<NodePacket> getPacketList() {
		return packetList;
	}
	
	@Override
	public Iterator listofPackets() {
		return packetList.iterator();
	}

}
