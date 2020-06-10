package project;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		hexFileInputStream.savePacketsfromFile();
		
		//HEX 바이너리 값 출력
		//DisplayPackets displayPackets = new DisplayPackets(hexFileInputStream);
		//displayPackets.displayAllPackets();
		
		//PacketInterpreter packetInterpreter = new PacketInterpreter();
		//packetInterpreter.trimSpacePacketList();
		//packetInterpreter.organizePacket();
		//packetInterpreter.createTransportProtocolInterpreter();
		//기본처리
		
		
		//템플릿 메소드 패턴
		InterpretedTCP tcp = new InterpretedTCP();
		InterpretedUDP udp = new InterpretedUDP();
		
		
		ArrayList<NodeInterpretedPacket> interpretedTCPList =   tcp.prepareInterpreter();
		ArrayList<NodeInterpretedPacket> interpretedUDPList = udp.prepareInterpreter();
		
		//컴포지트 패턴 사용
				TransportProtocolComponent tcpComponent = new TransportProtocol("TCP");
				TransportProtocolComponent udpCinoinent = new TransportProtocol("UDP");
				TransportProtocolComponent allInterpretedPackets = new TransportProtocol("모든 분석 정보");
				
				
				allInterpretedPackets.add(tcpComponent);
				allInterpretedPackets.add(udpCinoinent);
				
				ArrayList<NodeInterpretedPacket> list = interpretedTCPList;
				for(int i=0; i<list.size(); i++) {
					tcpComponent.add(new NodeInterpretedTCP(list.get(i).getID(), list.get(i).getValue()));
				}
				
				ArrayList<NodeInterpretedPacket> list2 = interpretedUDPList;
				for(int i=0; i<list2.size(); i++) {
					udpCinoinent.add(new NodeInterpretedUDP(list2.get(i).getID(), list2.get(i).getValue()));
				}
				
				TransportInterpreter interpreter = new TransportInterpreter(tcpComponent);
				//interpreter.display();
				
				TransportInterpreter interpreter2 = new TransportInterpreter(udpCinoinent);
				interpreter2.display();
				
				TransportInterpreter interpreter3 = new TransportInterpreter(allInterpretedPackets);
				//interpreter3.display();
	}

}
