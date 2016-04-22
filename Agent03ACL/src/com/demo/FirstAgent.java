package com.demo;

import jade.core.Agent;

/**
 * 新建一个Agent 	FirstAgent 消息发送者
 * @author YHC
 *
 */
public class FirstAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		
		//添加Behaviour	FirstBehaviour
		this.addBehaviour(new SendBehaviour(this));
	}

}
