package project;

public interface ProtocolInterface {
	
	public void organizePacket();
	public void createTransportProtocolInterpreter();
	public String createTCPInterpreter(int index);
	public String createUDPInterpreter(int index);
}

