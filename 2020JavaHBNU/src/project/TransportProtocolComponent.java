package project;

import java.util.Iterator;

public abstract class TransportProtocolComponent {

	public void add(TransportProtocolComponent interpreterComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(TransportProtocolComponent interpreterComponent) {
		throw new UnsupportedOperationException();
	}

	public TransportProtocolComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	
	public int getID() {
		throw new UnsupportedOperationException();
	}
	
	public String getValue() {
		throw new UnsupportedOperationException();
	}
	
	public String display() {
		throw new UnsupportedOperationException();
	}
	
	public Iterator<NodePacket> createIterator() {
		throw new UnsupportedOperationException();
	}
}
