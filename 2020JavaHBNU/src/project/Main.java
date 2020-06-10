package project;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		hexFileInputStream.savePacketsfromFile();
		
		//DisplayPackets displayPackets = new DisplayPackets(hexFileInputStream);
		//displayPackets.displayAllPackets();
		
		PacketInterpreter packetInterpreter = new PacketInterpreter();
		packetInterpreter.trimSpacePacketList();
		packetInterpreter.organizePacket();
		packetInterpreter.packetBasicInterpreter();

	}

}
