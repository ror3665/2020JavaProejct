package project;

import java.util.ArrayList;

public class InterpretedTCP extends PacketInterpreter {

	@Override
	ArrayList<NodeInterpretedPacket> createProtocolInterpreter() {
		return interpretedTCPList;

	}
}
