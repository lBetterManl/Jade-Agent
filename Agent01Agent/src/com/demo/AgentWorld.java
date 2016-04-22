package com.demo;

import java.util.Iterator;

import jade.core.Agent;

/**
 * 新建一个Agent
 * @author YHC
 *
 */
public class AgentWorld extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {

		System.out.println("这是一个Agent");
		
		// getAID() 用来获取本地Agent的标识符，标识符由全局唯一标识符（GUID）和平台地址组成
		
		//1). getLocalName() 本地名称
		System.out.println("LocalName is: "+getAID().getLocalName());
		
		//2). getName() 标识符  命名形式： <local-name>@<platform-name>
		System.out.println("GUID is: "+getAID().getName());
		
		//3). getAllAddresses() 地址
		System.out.println("Addresses are: ");
		Iterator<?> iterator = getAID().getAllAddresses();
		while(iterator.hasNext()){
			System.out.println("- "+iterator.next());
		}

	}

	
}
