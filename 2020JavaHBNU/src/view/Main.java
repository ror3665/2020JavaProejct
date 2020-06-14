package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import command.InterpretedPacketonCommand;
import command.Interpreter;
import command.MenuItem;
import command.RawPacketOnCommand;
import command.TCPonCommand;
import command.UDPonCommand;
import io.HexFileInputStream;
import organization.HexFile;
import organization.OrganizePacket;
import organization.PacketInterpreter;
import organization.PacketSeparation;
import organization.RemoveSpace;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Main.ViewGUI viewGUI = main.new ViewGUI();
	}

	@SuppressWarnings("serial")
	final class ViewGUI extends JFrame implements ActionListener {

		private JFileChooser chooseHexTextFile = new JFileChooser();
		private JButton btnOpen = new JButton("파일 열기");
		private JLabel activeLabel = new JLabel("파일을 가져와 주세요");
		private JLabel label = new JLabel("");
		private JButton btnHexBinary = new JButton("Hex binary");
		private JButton btnInterpretedPacket = new JButton("Interpreter");
		private JButton btnTCPPacket = new JButton("TCP Packet");
		private JButton btnUDPPacket = new JButton("UDP Packet");
		private JTextArea textArea = new JTextArea();
		private JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		private MenuItem menuItem = new MenuItem();

		public ViewGUI() {
			super("패킷 분석 프로그램");
			this.init();
			this.start();
			this.setSize(800, 800);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
		}

		public void init() {
			getContentPane().setLayout(null);
			btnOpen.setBounds(12, 10, 100, 40);
			activeLabel.setBounds(18, 35, 300, 60);
			label.setBounds(120, 20, 580, 20);
			btnHexBinary.setBounds(36, 78, 130, 50);
			btnInterpretedPacket.setBounds(203, 78, 130, 50);
			btnTCPPacket.setBounds(422, 78, 130, 50);
			btnUDPPacket.setBounds(592, 78, 130, 50);
			textArea.setBounds(12, 139, 760, 612);
			scrollPane.setBounds(12, 139, 760, 612);
			add(btnOpen);
			add(activeLabel);
			add(label);
			add(btnHexBinary);
			add(btnInterpretedPacket);
			add(btnTCPPacket);
			add(btnUDPPacket);
			add(scrollPane);

			btnHexBinary.setEnabled(false);
			btnInterpretedPacket.setEnabled(false);
			btnTCPPacket.setEnabled(false);
			btnUDPPacket.setEnabled(false);
			scrollPane.setVisible(true);
		}

		public void start() {
			btnOpen.addActionListener(this);
			btnHexBinary.addActionListener(this);
			btnInterpretedPacket.addActionListener(this);
			btnTCPPacket.addActionListener(this);
			btnUDPPacket.addActionListener(this);
			chooseHexTextFile.setFileFilter(new FileNameExtensionFilter("txt", "txt")); // 파일 필터
			chooseHexTextFile.setMultiSelectionEnabled(false);// 다중 선택 불가
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOpen) {
				if (chooseHexTextFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
					HexFileInputStream hexFileInputStream = HexFileInputStream.getInstance();
					try {
						hexFileInputStream.openHexFile(chooseHexTextFile.getSelectedFile().toString());
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					btnHexBinary.setEnabled(true);
					btnInterpretedPacket.setEnabled(true);
					btnTCPPacket.setEnabled(true);
					btnUDPPacket.setEnabled(true);

					menuItem = new MenuItem();
					OrganizePacket organize = new HexFile();
					organize.organize();
					OrganizePacket organize2 = new PacketInterpreter(
							new PacketSeparation(new RemoveSpace(new HexFile())));
					organize2.organize();
					Interpreter interpreter = new Interpreter(organize, organize2);

					RawPacketOnCommand rawPacketOnCommand = new RawPacketOnCommand(interpreter);
					InterpretedPacketonCommand interpretedPacketonCommand = new InterpretedPacketonCommand(interpreter);
					TCPonCommand tcPonCommand = new TCPonCommand(interpreter);
					UDPonCommand udPonCommand = new UDPonCommand(interpreter);
					menuItem.setCommand(0, rawPacketOnCommand);
					menuItem.setCommand(1, interpretedPacketonCommand);
					menuItem.setCommand(2, tcPonCommand);
					menuItem.setCommand(3, udPonCommand);

					label.setText("파일 경로 : " + chooseHexTextFile.getSelectedFile().toString());
					activeLabel.setText("파일이 선택되었습니다.");
				}
			} else if (e.getSource() == btnHexBinary) {
				btnCliked(0, "Hex Binary : 16진수의 이진값 패킷");
			} else if (e.getSource() == btnInterpretedPacket) {
				btnCliked(1, "Interpreted Packet : 해당 패킷 해석");
			} else if (e.getSource() == btnTCPPacket) {
				btnCliked(2, "TCP Packet : TCP로 통신중인 패킷 정보");
			} else if (e.getSource() == btnUDPPacket) {
				btnCliked(3, "UDP Packet : UDP로 통신중인 패킷 정보");
			}
		}

		private void btnCliked(int i, String str) {
			String list = menuItem.onButtonWasPushed(i);
			textArea.setText("");
			textArea.append(list);
			activeLabel.setText(str);
			textArea.setCaretPosition(1);
		}
	}
}