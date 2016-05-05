package com.example3;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;


/**
 * 2.船舶信息管理 Agent 发送难船基本信息  
 * 在setup（）中打开图形化界面
 * @author YHC
 *
 */
public class ShipInfoAgent extends Agent {

	@Override
	protected void setup() {
			
		Behaviour myBehaviour = new Behaviour() {
			
			
			@Override
			public boolean done() {
				
				return true;
			}
			
			@Override
			public void action() {
				ShipInfo shipinfo = new ShipInfo();
				shipinfo.setShipNo("123");
				shipinfo.setShipName("男神");

				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.addReceiver(new AID("maincontrol",AID.ISLOCALNAME));
				try{
					msg.setContentObject(shipinfo);//设置对象为消息内容
				}catch(Exception e){
					e.printStackTrace();
				}
				myAgent.send(msg);		
			}
		};
		
		this.addBehaviour(myBehaviour);
	
	}

	
}
