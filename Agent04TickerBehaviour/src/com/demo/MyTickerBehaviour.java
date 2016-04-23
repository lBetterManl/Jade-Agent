package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import jade.core.behaviours.TickerBehaviour;

/**
 * 连接查询MySQL 数据库，获取时刻列表，并添加到窗口
 * @author YHC
 *
 */
public class MyTickerBehaviour extends TickerBehaviour {

	private static final long serialVersionUID = 1L;

	ShowTrain showTrain = new ShowTrain();
	
	public MyTickerBehaviour(MyTickerAgent a) {
		super(a, 6000);
		// TODO Auto-generated constructor stub
	}
	
	public Object[][] QueryTrain() throws Exception{
		
		int trainCount = 0;//列车总记录数
		Object[][] trainList = null;//列车列表
		int i=0;//用于遍历列表
		
		Connection conn;
		Statement smt;
		ResultSet rst;
		try {
			String url = "jdbc:mysql://localhost:3306/agent04";
			String username = "root";	
			String password = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			smt = conn.createStatement();
			String sqlRow = "select count(*) from TrainList";
			rst = smt.executeQuery(sqlRow);
			while(rst.next()){
				trainCount = rst.getInt(1);
			}
			if(trainCount > 0){
				trainList =new Object[trainCount][4];
				String sqlList = "select * from TrainList";
				rst = smt.executeQuery(sqlList);
				while(rst.next()){
					trainList[i][0] = rst.getString(1);
					trainList[i][1] = rst.getString(2);
					trainList[i][2] = rst.getString(3);
					trainList[i][3] = rst.getString(4);
					i++;
				}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			
		return trainList;
		
	}

	@Override
	protected void onTick() {

		String[] name = {"车次", "车站", "始发站", "终点站"};
		DefaultTableModel dftm = null;
		try {
			dftm = new DefaultTableModel(QueryTrain(),name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showTrain.jTable.setModel(dftm);
		showTrain.jTable.repaint();
		showTrain.setVisible(true);
	}



}
