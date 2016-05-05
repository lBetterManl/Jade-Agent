package com.example2;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;

public class MySendAllReomote extends Agent {

	@Override
	protected void setup() {
		long i = 1000;
		AMSAgentDescription[] agents = null;	//将另一端的所有agent存在数组 agents[]中
		AID rams = new AID();	//设置远程 agent 的ams,在远程机器上搜索所有的 Agent
		rams.setName("ams@YHC-PC:1099/JADE");
		rams.addAddresses("http://YHC-PC:7778/acc");
		try{
			SearchConstraints constraints = new SearchConstraints();
			constraints.setMaxResults(i);
			agents = AMSService.search(this, rams,new AMSAgentDescription(),constraints);
		}catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("I am trying");
		for(int j=0;j<agents.length;j++){
			if(agents[j].getName().equals(getAID())){
				continue;
			}
			agents[j].getName().addAddresses("http://YHC-PC:7778/acc");
			msg.addReceiver(agents[j].getName());
			System.out.println(agents[j].getName());
		}
		
		send(msg);
	}

}
