package project;

import java.util.Iterator;

public class InterpretedTCP extends TransportProtocolComponent {
	private int ID;
	private String value;
	
	public InterpretedTCP(int ID, String value) {
		this.ID = ID;
		this.value = value;
	}

	public int getID() {
		return ID;
	}
	
	public String getValue() {
		return value;
	}
	
	public void display() {
		System.out.println("\n" + getValue());
	}
	
	
}
