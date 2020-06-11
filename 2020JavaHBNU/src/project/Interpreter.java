package project;

import java.io.IOException;
import java.util.ArrayList;

public class Interpreter {

	private ArrayList<NodePacket> jhexBinaryList;
	private ArrayList<NodePacket> interpretedTCPList;
	private ArrayList<NodePacket> interpretedUDPList;
	
	TransportProtocolComponent HexBinaryComponent;
	TransportProtocolComponent tcpComponent;
	TransportProtocolComponent udpComponent;
	
	String path;

	public Interpreter(String path) {
		HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
		try {
			hexFileInputStream.setPath(path);
			hexFileInputStream.savePacketsfromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HexBinary hexBinary = new HexBinary();
		InterpretedTCP tcp = new InterpretedTCP();
		InterpretedUDP udp = new InterpretedUDP();
		
		jhexBinaryList = hexBinary.prepareInterpreter();
		interpretedTCPList = tcp.prepareInterpreter();
		interpretedUDPList = udp.prepareInterpreter();
		
		HexBinaryComponent = new TransportProtocolComposite("HexBinary");
		ArrayList<NodePacket> hexBinaryList = jhexBinaryList;
		for(int i=0; i<hexBinaryList.size(); i++) {
			HexBinaryComponent.add(new NodePacket(hexBinaryList.get(i).getID(), hexBinaryList.get(i).getValue()));
		}
		
		tcpComponent = new TransportProtocolComposite("TCP");
		ArrayList<NodePacket> tcpList = interpretedTCPList;
		for(int i=0; i<tcpList.size(); i++) {
			tcpComponent.add(new NodePacket(tcpList.get(i).getID(), tcpList.get(i).getValue()));
		}
		
		udpComponent = new TransportProtocolComposite("UDP");
		ArrayList<NodePacket> udpList = interpretedUDPList;
		for(int i=0; i<udpList.size(); i++) {
			udpComponent.add(new NodePacket(udpList.get(i).getID(), udpList.get(i).getValue()));
		}
	}
	

	/**
	 * HEX ���̳ʸ� �� ���
	 */
	public String displayHexBinary()  {
		TransportInterpreterItem interpreter = new TransportInterpreterItem(HexBinaryComponent);
		return interpreter.display();
	}
	
	/**
	 * �ؼ��� TCP & UDP ��Ŷ ���
	 */
	public String displayTCPnUDP() {
		TransportProtocolComponent allInterpretedPackets = new TransportProtocolComposite("��� �м� ����");
		allInterpretedPackets.add(tcpComponent);
		allInterpretedPackets.add(udpComponent);
		TransportInterpreterItem interpreter = new TransportInterpreterItem(allInterpretedPackets);
		return interpreter.display();
	}

	/**
	 * �ؼ��� TCP ��Ŷ ���
	 */
	public String displayTCP() {
		TransportInterpreterItem interpreter = new TransportInterpreterItem(tcpComponent);
		return interpreter.display();
	}

	/**
	 * �ؼ��� UDP ��Ŷ ���
	 */
	public String displayUDP() {
		TransportInterpreterItem interpreter = new TransportInterpreterItem(udpComponent);
		return interpreter.display();

	}
}
