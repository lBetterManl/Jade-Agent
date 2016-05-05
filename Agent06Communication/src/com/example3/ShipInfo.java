package com.example3;

import java.io.Serializable;

/**
 * 1.消息内容类 ShipInfo 的定义
 * 构建传递对象  必须实现 java.io.Serializable 接口
 * @author YHC
 *
 */
public class ShipInfo implements Serializable {

	private String shipNo;
	private String shipName;
	
	
	public ShipInfo() {
		super();
	}
		
	
	public ShipInfo(String shipNo, String shipName) {
		super();
		this.shipNo = shipNo;
		this.shipName = shipName;
	}


	public String getShipNo() {
		return shipNo;
	}
	public void setShipNo(String shipNo) {
		this.shipNo = shipNo;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	@Override
	public String toString() {
		return "ShipInfo [shipNo=" + shipNo + ", shipName=" + shipName + "]";
	}
	
	

}
