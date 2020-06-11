package project;

import java.util.ArrayList;

public class InterpretedUDP extends PacketInterpreter {

	@Override
	ArrayList<NodePacket> createProtocolInterpreter() {
		return interpretedUDPList;
	}
}
