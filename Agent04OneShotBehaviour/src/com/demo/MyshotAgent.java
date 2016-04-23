package com.demo;

import jade.core.Agent;

/**
 * 执行MyshotBehaviour
 * @author YHC
 *
 */
public class MyshotAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		this.addBehaviour(new MyshotBehaviour());
	}
	
}
