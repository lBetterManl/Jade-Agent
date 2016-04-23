package com.demo;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.WakerBehaviour;

/**
 * 
 * @author YHC
 *
 */
public class MyparallelBehaviour extends Agent {

	@Override
	protected void setup() {

		//endCondition 表示行为个数
		//	可以是整数 n，即 n 个行为运行完毕，程序结束
		//	也可以是ParallelBehaviour.WHEN_ALL 表示所有行为运行结束，程序结束
		//	也可以是ParallelBehaviour.WHEN_ANY 表示任意一个行为运行结束，程序结束
		//  程序结束后其他行为不执行
		ParallelBehaviour pBehaviour = new ParallelBehaviour(this, ParallelBehaviour.WHEN_ALL);
		
		
		//添加一个 OneShotBehaviour 子行为 
		pBehaviour.addSubBehaviour(new OneShotBehaviour(this) {
			
			@Override
			public void action() {
				
				System.out.println("我是第1个子行为  OneShotBehaviour");
			}
		});
		
		//添加一个 WakerBehaviour 子行为 
		pBehaviour.addSubBehaviour(new WakerBehaviour(this, 6000) {

			@Override
			protected void onWake() {
			
				System.out.println("我是第2个子行为  WakerBehaviour");
			}

		});
		
		//添加一个SimpleBehaviour 子行为
		pBehaviour.addSubBehaviour(new SimpleBehaviour(this) {
			
			boolean finished = false;
			@Override
			public boolean done() {
				
				return finished;
			}
			
			@Override
			public void action() {
				
				System.out.println("我是第3个子行为  SimpleBehaviour");
				finished = true;
			}
		});
		
		this.addBehaviour(pBehaviour);
		
	}
	
}
