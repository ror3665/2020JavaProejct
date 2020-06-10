package project;

import java.util.ArrayList;

public class InterpretedUDP extends PacketUnInterpreter {

	@Override
	ArrayList<NodeInterpretedPacket> createProtocolInterpreter() {
		return interpretedUDPList;
	}
}
