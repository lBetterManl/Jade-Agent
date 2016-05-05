package com.example1;


import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

/**
 * 发送消息给远程Agent
 * @author YHC
 * 在远程机器上写接收代码
 */
public class MyRemoteSend extends Agent {

	@Override
	protected void setup() {
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		AID dest = new AID("hy@YHC-PC:1099/JADE",true);
		dest.addAddresses("http://YHC-PC:7778/acc");
		msg.addReceiver(dest);
		msg.setContent("can you ....");
		send(msg);
	}
	
}
