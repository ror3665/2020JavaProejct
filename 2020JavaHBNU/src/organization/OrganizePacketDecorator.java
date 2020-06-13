package organization;

import java.util.ArrayList;

public abstract class OrganizePacketDecorator extends OrganizePacket{
	private OrganizePacket decoratedOrganizePacket;
	 
	  public OrganizePacketDecorator(OrganizePacket decoratedOrganizePacket) {
	      this.decoratedOrganizePacket = decoratedOrganizePacket;
	  }
	 
	  @Override
	  public  ArrayList<?> organize() {
		  return decoratedOrganizePacket.organize();
	  };
}
