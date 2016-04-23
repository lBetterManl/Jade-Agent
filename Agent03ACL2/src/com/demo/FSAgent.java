package com.demo;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames.InteractionProtocol;
import jade.lang.acl.ACLMessage;
import jade.proto.SimpleAchieveREInitiator;

/**
 * 实例名yhc  发送消息  接收来自hy 的回复
 * @author YHC
 *
 */
public class FSAgent extends Agent {

	private static final long serialVersionUID = 1L;
	
	static class MarriageProposer extends SimpleAchieveREInitiator{

		private static final long serialVersionUID = 1L;
		
			protected MarriageProposer(Agent agent, ACLMessage msg){
	            super(agent, msg);
	        }
	        protected void handleAgree(ACLMessage msg) {
	            System.out.println(myAgent.getLocalName() + ": 吼吼! " +
	            msg.getSender().getLocalName() +" 已经同意嫁给我了, I'm so excited!");
	        }
	        protected void handleRefuse(ACLMessage msg) {
	            System.out.println(myAgent.getLocalName() + ": Oh no! " +
	            msg.getSender().getLocalName() +" 拒绝了我, i feel sad.");
	        }
	        protected void handleInform(ACLMessage msg) {
	            System.out.println(myAgent.getLocalName() + ":" +
	            msg.getSender().getLocalName() +" has informed me of the status of my request." +
	            " They said : " + msg.getContent());
	        }
	        protected void handleNotUnderstood(ACLMessage msg){
	            System.out.println(myAgent.getLocalName() + ":"
	                + msg.getSender().getLocalName() +
	                " has indicated that they didn't understand.");
	        }
	        protected void handleOutOfSequence(ACLMessage msg) {
	            System.out.println(myAgent.getLocalName() + ":"
	                + msg.getSender().getLocalName() +
	                "has sent me a message which I wasn't" +
	                " expecting in this conversation");
	        }
	    }
	    protected void setup() {
	        System.out.println(getLocalName() +": about to propose marriage to hy ");
	        doWait(5000); //wait for bob to be started.
	        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	        AID to = new AID();
	       
	        to.setLocalName("hy");
	        msg.setSender(getAID());
	        msg.addReceiver(to);
	        msg.setContent("Marry Me!");
	        msg.setProtocol(InteractionProtocol.FIPA_REQUEST);
	        addBehaviour(new MarriageProposer(this, msg));
	    }
}
