package com.demo;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.WakerBehaviour;
/**
 * 顺序行为(SequentialBehaviour) 属于组合行为
 * @author YHC
 *
 */
public class MysequentialAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {

		//建立顺序行为
		SequentialBehaviour sBehaviour = new SequentialBehaviour(this);
		
		//添加一个 OneShotBehaviour 一次性行为
		sBehaviour.addSubBehaviour(new OneShotBehaviour(this) {

			@Override
			public void action() {

				System.out.println("第1个 子行为    OneShotBehaviour");
				
			}
		});
		
		//添加 WakerBehaviour 定时行为
		sBehaviour.addSubBehaviour(new WakerBehaviour(this, 6000){

			@Override
			protected void onWake() {

				System.out.println("第2个 子行为    WakerBehaviour");
			}
			
		});
		
		//添加 SimpleBehaviour 简单行为
		sBehaviour.addSubBehaviour(new SimpleBehaviour(this) {
			
			boolean finished = false;
			
			@Override
			public boolean done() {
				
				return finished;
			}
			
			@Override
			public void action() {
				
				System.out.println("第3个 子行为  SimpleBehaviour");
				finished = true;
			}
		});
		
		//添加以上顺序行为
		this.addBehaviour(sBehaviour);
		
		
		
	}
	
}
