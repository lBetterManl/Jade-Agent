package com.example4;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
/**
 * 消息发送者 t1
 * 设置MessageTemplate
 * @author YHC
 *
 */
public class Template extends Agent {

	MessageTemplate mt1 = MessageTemplate.and(
				MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
				MessageTemplate.MatchSender(new AID("a1",AID.ISLOCALNAME)));
	
	@Override
	protected void setup() {
		
		//发送消息给 a1 a2
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("Ping");
		for(int i=1;i<=2;i++){
			msg.addReceiver(new AID("a"+i,AID.ISLOCALNAME));
		}
		
		send(msg);
		
		
		//添加 Behaviour1
		addBehaviour(new CyclicBehaviour(this) {
			
			@Override
			public void action() {

				System.out.println("The Message: ");
				ACLMessage msg = receive(mt1);	//添加消息模板
				if(msg != null){
					System.out.println("gets "+msg.getPerformative()+" from "
							+msg.getSender().getLocalName()+" = "
							+msg.getContent());
				}else{
					System.out.println("gets NULL");
				}
				
				block();
				
			}
		});
		
		//添加 Behaviour2 测试时注释掉1或2
		/*
		addBehaviour(new CyclicBehaviour(this) {
			
			@Override
			public void action() {
				
				System.out.println("Behaviour TWO: ");
				ACLMessage msg = receive();
				if(msg != null){
					System.out.println("gets "+msg.getPerformative()+" from "
							+msg.getSender().getLocalName()+" = "
							+msg.getContent());
				}else{
					System.out.println("gets NULL");
				}
				
				block();
			}
		});
		*/
	}

}
