package com.example3;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * 主控制Agent接收难船信息
 * @author YHC
 *
 */
public class MyMainControl extends Agent {

	@Override
	protected void setup() {
		this.addBehaviour(new CyclicBehaviour() {
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg == null){
					block();
					return;
				}
				try{
					Object recontent = msg.getContentObject();//读取消息
					if(recontent instanceof ShipInfo){
						ShipInfo mydata = (ShipInfo) recontent;
						System.out.println(mydata);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
	}

}
