package project;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		hexFileInputStream.savePacketsfromFile();
		
		//HEX ���̳ʸ� �� ���
		//DisplayPackets displayPackets = new DisplayPackets(hexFileInputStream);
		//displayPackets.displayAllPackets();
		
		//PacketInterpreter packetInterpreter = new PacketInterpreter();
		//packetInterpreter.trimSpacePacketList();
		//packetInterpreter.organizePacket();
		//packetInterpreter.createTransportProtocolInterpreter();
		//�⺻ó��
		
		
		//���ø� �޼ҵ� ����
		InterpretedTCP tcp = new InterpretedTCP();
		InterpretedUDP udp = new InterpretedUDP();
		
		
		ArrayList<NodeInterpretedPacket> interpretedTCPList =   tcp.prepareInterpreter();
		ArrayList<NodeInterpretedPacket> interpretedUDPList = udp.prepareInterpreter();
		
		//������Ʈ ���� ���
				TransportProtocolComponent tcpComponent = new TransportProtocol("TCP");
				TransportProtocolComponent udpCinoinent = new TransportProtocol("UDP");
				TransportProtocolComponent allInterpretedPackets = new TransportProtocol("��� �м� ����");
				
				
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
