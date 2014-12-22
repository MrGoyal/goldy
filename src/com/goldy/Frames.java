package com.goldy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Frames extends JFrame implements MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int a,b;
	
	public static void main(String[] args) {
		Frames frame = new Frames();
		frame.setVisible(true);
	}
	
	public Frames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		Menu menu=new Menu();
		setJMenuBar(menu);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		DrawPanel drawingPanel=new DrawPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		drawingPanel.addMouseMotionListener(this);
		//code here
		StatusPanel statusPanel = new StatusPanel();
		contentPane.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new BorderLayout(0,0));
		JLabel status=new JLabel(" ");
		statusPanel.add(status);
	}

	public void mouseDragged(MouseEvent e) {
		a=e.getX();
		b=e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		a=e.getX();
		b=e.getY();
		repaint();
	}
	
	class DrawPanel extends JPanel{
		
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			g.drawLine(0, 0, a, b);
		}
	}
	class StatusPanel extends JPanel{
		
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			g.drawString(a+","+b, 10, 10);
		}
	}
	class Menu extends JMenuBar{
		
		private static final long serialVersionUID = 1L;

		public Menu(){
			JMenu mnFile = new JMenu("File");
			this.add(mnFile);		
			JMenuItem New = new JMenu("New");
			mnFile.add(New);
			JMenuItem Open = new JMenu("Open");
			mnFile.add(Open);
			JMenu mnSetting = new JMenu("Settings");
			this.add(mnSetting);
			JMenuItem edit=new JMenuItem("Edit");
			mnSetting.add(edit);
		}
	}
}