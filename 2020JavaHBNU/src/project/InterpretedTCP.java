package project;

import java.util.ArrayList;

public class InterpretedTCP extends PacketInterpreter {

	@Override
	ArrayList<NodePacket> createProtocolInterpreter() {
		return interpretedTCPList;
	}
}
