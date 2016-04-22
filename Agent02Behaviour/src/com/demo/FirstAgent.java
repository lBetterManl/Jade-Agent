package com.demo;

import jade.core.Agent;

/**
 * 新建一个Agent 	FirstAgent
 * @author YHC
 *
 */
public class FirstAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		
		System.out.println("这是FirstAgent");
		
		//添加Behaviour	FirstBehaviour
		this.addBehaviour(new FirstBehaviour());
	}

}
