package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View {

	public static void main(String[] args) {

		test_Frame tf = new test_Frame();

	}
}

class test_Frame extends JFrame implements ActionListener {

	private JFileChooser chooseHexTextFile = new JFileChooser();
	private JButton btnOpen = new JButton("열기");
	private JLabel label = new JLabel(" ");
	private JButton btnHexBinary = new JButton("Hex binary");
	private JButton btnInterpretedPacket = new JButton("Interpreted Packet");
	private JButton btnTCPPacket = new JButton("TCP Packet");
	private JButton btnUDPPacket = new JButton("UDP Packet");
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	MenuItem menuItem = new MenuItem();
	
	public test_Frame() {
		super();
		this.init();
		this.start();
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void init() {
		getContentPane().setLayout(null);
		btnOpen.setBounds(12, 10, 100, 40);
		label.setBounds(120, 20, 580, 20);
		btnHexBinary.setBounds(36, 78, 129, 43);
		btnInterpretedPacket.setBounds(203, 78, 149, 43);
		btnTCPPacket.setBounds(422, 78, 129, 43);
		btnUDPPacket.setBounds(592, 78, 129, 43);
		textArea.setBounds(12, 139, 760, 612);
		scrollPane.setBounds(12, 139, 760, 612);
		add(btnOpen);
		add(label);
		add(btnHexBinary);
		add(btnInterpretedPacket);
		add(btnTCPPacket);
		add(btnUDPPacket);
		add(scrollPane);
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
				menuItem = new MenuItem();
				Interpreter interpreter = new Interpreter(chooseHexTextFile.getSelectedFile().toString());
				
				DisplayHexBinaryOnCommand displayHexBinaryOnCommand = new DisplayHexBinaryOnCommand(interpreter);
				DisplayTCPnUDPonCommand displayTCPnUDPonCommand = new DisplayTCPnUDPonCommand(interpreter);
				DisplayTCPonCommand displayTCPonCommand = new DisplayTCPonCommand(interpreter);
				DisplayUDPonCommand displayUDPonCommand = new DisplayUDPonCommand(interpreter);
				
				menuItem.setCommand(0, displayHexBinaryOnCommand);
				menuItem.setCommand(1, displayTCPnUDPonCommand);
				menuItem.setCommand(2, displayTCPonCommand);
				menuItem.setCommand(3, displayUDPonCommand);
				label.setText("파일 경로 : " + chooseHexTextFile.getSelectedFile().toString());	
			}
		} else if(e.getSource() == btnHexBinary) {
			String list = menuItem.onButtonWasPushed(0);
			textArea.setText("");
			textArea.append(list);
		} else if(e.getSource() == btnInterpretedPacket) {
			String list = menuItem.onButtonWasPushed(1);
			textArea.setText("");
			textArea.append(list);
		} else if(e.getSource() == btnTCPPacket) {
			String list = menuItem.onButtonWasPushed(2);
			textArea.setText("");
			textArea.append(list);
		} else if(e.getSource() == btnUDPPacket) {
			String list = menuItem.onButtonWasPushed(3);
			textArea.setText("");
			textArea.append(list);
		}
	}
}
