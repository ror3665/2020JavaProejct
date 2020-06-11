package project;

import java.util.ArrayList;

public class HexBinary extends PacketInterpreter{

	@Override
	ArrayList<NodePacket> createProtocolInterpreter() {
		return hexBinaryList;
	}

}
