package com.demo;

import jade.core.Agent;

/**
 * 执行MyFSMBehaviour的Agent
 * @author YHC
 *
 */
public class MyFSMAgent extends Agent {

	@Override
	protected void setup() {
		this.addBehaviour(new MyFSMBehaviour(this));
	}

	
}
