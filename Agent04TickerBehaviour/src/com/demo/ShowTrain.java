package com.demo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.JTable;

/**
 * 显示时刻列表的窗口
 * @author YHC
 *
 */
public class ShowTrain extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTable jTable;

	/**
	 * Create the frame.
	 */
	public ShowTrain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		jTable = new JTable();
		scrollPane.setViewportView(jTable);
		
		
		
	}

}
