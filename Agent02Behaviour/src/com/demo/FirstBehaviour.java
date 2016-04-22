package com.demo;

import jade.core.behaviours.Behaviour;
/**
 * 新建一个 Behaviour
 * @author YHC
 */
public class FirstBehaviour extends Behaviour {

	private static final long serialVersionUID = 1L;

	// 一个Behaviour 可以嵌套另一个Behaviour
	
	private int numA = 5;
	
	// action() 定义Agent 需要实现的任务
	@Override
	public void action() {

		if((numA % 2)!=0){
			System.out.println("numA 是奇数");
		}else{
			System.out.println("numA 是偶数");
		}
		
	}

	// done() 返回一个boolean 来判断这个Behaviour 
	//     是否完成其任务，
	//     是否应该将其移出其所在Agent 所管理的行为队列，
	//     每个Agent 可以并行执行多个 Behaviour
	@Override
	public boolean done() {
		
		return true;
	}

}
