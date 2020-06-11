package project;

import java.io.IOException;
import java.util.ArrayList;

public class Interpreter {
	private HexFileInputStream hexFileInputStream;
	DisplayPackets displayPackets;
	private ArrayList<NodeInterpretedPacket> interpretedTCPList;
	private ArrayList<NodeInterpretedPacket> interpretedUDPList;
	TransportProtocolComponent tcpComponent;
	TransportProtocolComponent udpCinoinent;
	String path;

	public Interpreter(String path) {
		hexFileInputStream = HexFileInputStream.getInstance();
		try {
			hexFileInputStream.setPath(path);
			hexFileInputStream.savePacketsfromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		displayPackets = new DisplayPackets(hexFileInputStream);
		InterpretedTCP tcp = new InterpretedTCP();
		InterpretedUDP udp = new InterpretedUDP();
		interpretedTCPList = tcp.prepareInterpreter();
		interpretedUDPList = udp.prepareInterpreter();
		
		tcpComponent = new TransportProtocol("TCP");
		ArrayList<NodeInterpretedPacket> tcpList = interpretedTCPList;
		for(int i=0; i<tcpList.size(); i++) {
			tcpComponent.add(new NodeInterpretedTCP(tcpList.get(i).getID(), tcpList.get(i).getValue()));
		}
		udpCinoinent = new TransportProtocol("UDP");
		ArrayList<NodeInterpretedPacket> udpList = interpretedUDPList;
		for(int i=0; i<udpList.size(); i++) {
			udpCinoinent.add(new NodeInterpretedUDP(udpList.get(i).getID(), udpList.get(i).getValue()));
		}
	}
	

	/**
	 * HEX ���̳ʸ� �� ���
	 * @throws IOException
	 */
	public String displayHexBinary()  {
		return displayPackets.display();
	}
	
	/**
	 * �ؼ��� TCP & UDP ��Ŷ ���
	 * @return 
	 */
	public String displayTCPnUDP() {
		TransportProtocolComponent allInterpretedPackets = new TransportProtocol("��� �м� ����");
		allInterpretedPackets.add(tcpComponent);
		allInterpretedPackets.add(udpCinoinent);
		TransportInterpreter interpreter = new TransportInterpreter(allInterpretedPackets);
		return interpreter.display();
	}

	/**
	 * �ؼ��� TCP ��Ŷ ���
	 */
	public String displayTCP() {
		TransportInterpreter interpreter = new TransportInterpreter(tcpComponent);
		return interpreter.display();
	}

	/**
	 * �ؼ��� UDP ��Ŷ ���
	 * @return 
	 */
	public String displayUDP() {
		TransportInterpreter interpreter = new TransportInterpreter(udpCinoinent);
		return interpreter.display();

	}
}
