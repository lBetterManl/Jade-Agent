package com.demo;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames.InteractionProtocol;
import jade.lang.acl.ACLMessage;
import jade.proto.SimpleAchieveREResponder;

/**
 * 实例名hy  接收消息  接收来自yhc 的请求
 * @author YHC
 *
 */
public class JSAgent extends Agent {

	private static final long serialVersionUID = 1L;
	
	 static class MarriageResponder extends SimpleAchieveREResponder{

		private static final long serialVersionUID = 1L;
		
			public MarriageResponder(Agent agent){
	            super(agent,createMessageTemplate(InteractionProtocol.FIPA_REQUEST));
	        }
	        protected ACLMessage prepareResponse(ACLMessage msg) {
	            ACLMessage response = msg.createReply();
	            if(msg.getContent()!=null && msg.getContent().equals("Marry Me!")){
	                System.out.println(myAgent.getLocalName() + ":" +
	                        msg.getSender().getLocalName() +
	                        " has asked me to marry him!");
	            AID sender;
	            sender = msg.getSender();
	            if(sender.getLocalName().equals("yhc")){
	                response.setPerformative(ACLMessage.AGREE);
	                System.out.println(myAgent.getLocalName() +
	                    ":I'm going to agree.");
	            }else{
	                response.setPerformative(ACLMessage.REFUSE);
	                System.out.println(myAgent.getLocalName() +
	                    ":I'm going to turn him down.");
	            }
	            }else{
	                response.setPerformative(ACLMessage.NOT_UNDERSTOOD);
	                System.out.println(myAgent.getLocalName() +
	                    ":I didn't understand what " +
	                msg.getSender().getLocalName() +
	                    " just said to me.");
	            }
	            return response;
	        }
	        protected ACLMessage prepareResultNotification(ACLMessage inmsg,
	                                                            ACLMessage outmsg) {
	 
	        //what they have asked is now complete (or if it failed)
	            ACLMessage msg = inmsg.createReply();
	            msg.setPerformative(ACLMessage.INFORM);
	            msg.setContent("I Do!");
	            return msg;
	        }
	 
	    }
	    protected void setup() {
	        System.out.println(getLocalName() +
	                ": I wonder if anybody wants to marry me?");
	        addBehaviour(new MarriageResponder(this));
	     }//

}
