package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HexFileInputStream {
	private static HexFileInputStream uniqueInstance = new HexFileInputStream(); // Singleton
	private ArrayList<String> packetList;

	private HexFileInputStream() {
		packetList = new ArrayList<>();
	}

	public static HexFileInputStream getInstance() {
		return uniqueInstance;
	}

	public void openHexFile(String path) throws IOException {

		String sLine = null;
		StringBuilder sb = new StringBuilder();

		File file = new File(path);
		if (file.exists()) {
			BufferedReader inFile = new BufferedReader(new FileReader(file));
			while ((sLine = inFile.readLine()) != null) {
				try {
					if (sLine.equals("")) {
						addPacket(sb);
						sb.delete(0, sb.length());
					} else
						sb.append(trimUpPacket(sLine));
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
			addPacket(sb);
			inFile.close();
		}
	}

	private void addPacket(StringBuilder sb) {
		String newLine = sb.toString();
		packetList.add(newLine);

	}

	private String trimUpPacket(String sLine) {
		int indexOfEnd = sLine.indexOf("   ");
		return sLine.substring(6, indexOfEnd) + " ";
	}

	public ArrayList<String> getPacketList() {
		return packetList;
	}
}
