package com.demo;

import jade.core.Agent;

/**
 * 显示时刻列表的代理
 * @author YHC
 *
 */
public class MyTickerAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {

		this.addBehaviour(new MyTickerBehaviour(this));
	}

}
