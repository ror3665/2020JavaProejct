package project;

public class Help implements HelpInterface {

	@Override
	public void typeOfServiceGuide() {
		System.out.println("���� 0�� ��� ǥ�� �����Դϴ�");
		System.out.println("Precedence(����)�ʵ� :3bit");
		System.out.println("000 : Routin (Normal)");
		System.out.println("001 : Priority");
		System.out.println("010 : Immediate");
		System.out.println("011 : Flash");
		System.out.println("100 : Flash Override");
		System.out.println("101 : Critical");
		System.out.println("110 : Internetwork Control (OSPF���� ���õ�)");
		System.out.println("111 : Network Control");
		System.out.println();
		System.out.println("TOS(Type -Of - Service) �ʵ� : 4bit" );
		System.out.println("Bit 3 : Delay (�ּ� ����)");
		System.out.println("0 : ������ ����, 1: ���� ����");
		System.out.println("Bit 4 : Throughtput (�ִ� ó����");
		System.out.println("0 : ���� ó����, 1: ���� ó����");
		System.out.println("Bit 5: Reliability (�ִ� �ŷڼ�)");
		System.out.println("0 : ���� �ŷڼ�, 1: ���� �ŷڼ�");
		System.out.println("Bit 6 : Minimum Cost (�ּҺ��)");
		System.out.println("Bit 7�� ������� �ʰ� �׻� 0���� ���õ�");
	}

}
