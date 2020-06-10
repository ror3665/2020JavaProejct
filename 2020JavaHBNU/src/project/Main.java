package project;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException{
		
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		hexFileInputStream.savePacketsfromFile();
		
		//DisplayPackets displayPackets = new DisplayPackets(hexFileInputStream);
		//displayPackets.displayAllPackets();
		
		PacketInterpreter packetInterpreter = new PacketInterpreter();
		packetInterpreter.trimSpacePacketList();
		packetInterpreter.organizePacket();
		packetInterpreter.createTransportProtocolInterpreter();
		
		/*
		ArrayList<InterpretedPacketNode> list = packetInterpreter.getInterpretedTCPList();
		for(int i=0; i<list.size(); i++) {
			System.out.println("ID: "+  list.get(i).getID() +"\n" +list.get(i).getValue());
		}
		
		ArrayList<InterpretedPacketNode> list2 = packetInterpreter.getInterpretedUDPList();
		for(int i=0; i<list2.size(); i++) {
			System.out.println("ID: "+  list2.get(i).getID() +"\n" + list2.get(i).getValue());
		}
		*/
		

		TransportProtocolComponent tcp = new TransportProtocol("TCP");
		TransportProtocolComponent udp = new TransportProtocol("UDP");
		TransportProtocolComponent allInterpretedPackets = new TransportProtocol("모든 분석 정보");
		
		
		allInterpretedPackets.add(tcp);
		allInterpretedPackets.add(udp);
		
		ArrayList<InterpretedPacketNode> list = packetInterpreter.getInterpretedTCPList();
		for(int i=0; i<list.size(); i++) {
			tcp.add(new InterpretedTCP(list.get(i).getID(), list.get(i).getValue()));
		}
		
		ArrayList<InterpretedPacketNode> list2 = packetInterpreter.getInterpretedUDPList();
		for(int i=0; i<list2.size(); i++) {
			udp.add(new InterpretedUDP(list2.get(i).getID(), list2.get(i).getValue()));
		}
		
		Interpreter interpreter = new Interpreter(tcp);
		//interpreter.display();
		
		Interpreter interpreter2 = new Interpreter(udp);
		//interpreter2.display();
		
		Interpreter interpreter3 = new Interpreter(allInterpretedPackets);
		interpreter3.display();
		
	}

}
