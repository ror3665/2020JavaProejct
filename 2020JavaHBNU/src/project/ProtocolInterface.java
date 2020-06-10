package project;

public interface ProtocolInterface {
	
	public void organizePacket();
	public void packetBasicInterpreter();
	public void packetTCPInterpreter(int index);
	public void packetUDPInterpreter(int index);
}

