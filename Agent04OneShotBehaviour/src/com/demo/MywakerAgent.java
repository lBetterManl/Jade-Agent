package com.demo;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 * 执行WakerBehaviour ：类似闹钟，定时执行
 * @author YHC
 *
 */
public class MywakerAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		
		System.out.println("添加WakerBehaviour 行为 ");
		
		//定时执行
		addBehaviour(new WakerBehaviour(this, 10000){

			private static final long serialVersionUID = 1L;

			//定时执行的动作
			@Override
			protected void onWake() {
				
				System.out.println("执行操作！");
			}
			
		});
	}
		
}
