package project;

import java.util.ArrayList;

public class InterpretedTCP extends PacketUnInterpreter {

	@Override
	ArrayList<NodeInterpretedPacket> createProtocolInterpreter() {
		return interpretedTCPList;

	}
}
