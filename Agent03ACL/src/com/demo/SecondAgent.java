package com.demo;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * 新建一个Agent 	SecondAgent 消息接收者
 * @author YHC
 *
 */
public class SecondAgent extends Agent {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		
		//添加行为   CyclicBehaviour	一直执行
		Behaviour loop = new CyclicBehaviour(){

			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				
				ACLMessage msg = receive();
				if(msg != null){
					System.out.println("SecondAgent 收到如下消息： "+msg.getContent());
				}
			}
			
		};		
		this.addBehaviour(loop);
		
		
		//添加行为    另一种方法
		/*
		this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg != null){
					System.out.println("SecondAgent 收到如下消息： "+msg.getContent());
				}
				
			}
		});
		*/
	}

}
