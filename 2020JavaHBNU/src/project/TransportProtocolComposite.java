package project;

import java.util.ArrayList;
import java.util.Iterator;

public class TransportProtocolComposite extends TransportProtocolComponent{
	ArrayList<TransportProtocolComponent> transportProtocolComponets = new ArrayList<>();
	String value;
	
	public TransportProtocolComposite(String value) {
		this.value = value;
	}
	
	public void add(TransportProtocolComponent transportProtocolComponent) {
		transportProtocolComponets.add(transportProtocolComponent);
	}
	
	public void remove(TransportProtocolComponent transportProtocolComponent) {
		transportProtocolComponets.remove(transportProtocolComponent);
	}
	
	public TransportProtocolComponent getChild(int i) {
		return (TransportProtocolComponent)transportProtocolComponets.get(i);
	}
	
	public String getValue() {
		return value;
	}
	
	public String display() {
		StringBuilder sb = new StringBuilder();
	
		Iterator<TransportProtocolComponent> iterator = transportProtocolComponets.iterator();
		while(iterator.hasNext()) {
			TransportProtocolComponent transportProtocolComponent = (TransportProtocolComponent)iterator.next();
			sb.append(transportProtocolComponent.display());
			
		}
	
		return sb.toString();
	}
	

}
