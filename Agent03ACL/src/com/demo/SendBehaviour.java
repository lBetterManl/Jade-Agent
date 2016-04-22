package com.demo;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

/**
 * 编写一个Behaviour 供FirstAgent 发送消息
 * @author YHC
 *
 */
public class SendBehaviour extends Behaviour {

	private static final long serialVersionUID = 1L;
	
	FirstAgent sendAgent = null;

	//供sendAgent 发送消息
	@Override
	public void action() {

		//1.新建ACLMessage 对象
		ACLMessage msg =new ACLMessage(ACLMessage.INFORM);
		//2.添加接收者  接收代理应该命名为Alice
		msg.addReceiver(new AID("Alice", AID.ISLOCALNAME));
		//3.设置消息语言
		msg.setLanguage("English");
		//4.设置消息内容
		msg.setContent("I Love U");
		//5.发送消息
		sendAgent.send(msg);
	}

	@Override
	public boolean done() {
		
		return true;
	}
	
	//构造函数
	public SendBehaviour(FirstAgent a){
		sendAgent = a;
	}

}
