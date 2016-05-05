package com.example4;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
/**
 * 消息接收者 a1 a2
 * @author YHC
 *
 */
public class Responder extends Agent {

	@Override
	protected void setup() {
		
		addBehaviour(new CyclicBehaviour(this) {
			
			@Override
			public void action() {

				ACLMessage msg = receive();
				if(msg != null){
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Yes, I am here.");
					send(reply);
					
					reply.setPerformative(ACLMessage.PROPOSE);
					String msgcontent = "Tell me your opinion about "+reply.getSender().getLocalName();
					reply.setContent(msgcontent);
					send(reply);
				}
				
				block();
				
			}
		});
	}

}
