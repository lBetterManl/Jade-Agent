package com.demo;

import jade.core.behaviours.OneShotBehaviour;

/**
 * SimpleBehaviour 中的OneShotBehaviour 只执行一次
 * @author YHC
 *
 */
public class MyshotBehaviour extends OneShotBehaviour {

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		
		System.out.println("I am a oneshot Behaviour");
	}

}
