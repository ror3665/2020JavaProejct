package project;

import java.util.ArrayList;

public class InterpretedUDP extends PacketInterpreter {

	@Override
	ArrayList<NodeInterpretedPacket> createProtocolInterpreter() {
		return interpretedUDPList;
	}
}
