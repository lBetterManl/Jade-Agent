package com.demo;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * 接收请求的代理
 * @author YHC
 *
 */
public class MyReceiverAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		this.addBehaviour(new CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {

				ACLMessage msg = receive();
				if(msg != null){
					System.out.println(myAgent.getLocalName()+"收到如下消息： "+msg.getContent()+" 此消息来自： "+msg.getSender().getLocalName());
				}
				
			}
		});
	}
	
	

}
