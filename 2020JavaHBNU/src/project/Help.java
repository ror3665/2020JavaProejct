package project;

public class Help implements HelpInterface {

	@Override
	public void typeOfServiceGuide() {
		System.out.println("전부 0인 경우 표준 서비스입니다");
		System.out.println("Precedence(선행)필드 :3bit");
		System.out.println("000 : Routin (Normal)");
		System.out.println("001 : Priority");
		System.out.println("010 : Immediate");
		System.out.println("011 : Flash");
		System.out.println("100 : Flash Override");
		System.out.println("101 : Critical");
		System.out.println("110 : Internetwork Control (OSPF에서 셋팅됨)");
		System.out.println("111 : Network Control");
		System.out.println();
		System.out.println("TOS(Type -Of - Service) 필드 : 4bit" );
		System.out.println("Bit 3 : Delay (최소 지연)");
		System.out.println("0 : 보통의 지연, 1: 높은 지연");
		System.out.println("Bit 4 : Throughtput (최대 처리율");
		System.out.println("0 : 보통 처리율, 1: 높은 처리율");
		System.out.println("Bit 5: Reliability (최대 신뢰성)");
		System.out.println("0 : 보통 신뢰성, 1: 높은 신뢰성");
		System.out.println("Bit 6 : Minimum Cost (최소비용)");
		System.out.println("Bit 7은 사용하지 않고 항상 0으로 세팅됨");
	}

}
