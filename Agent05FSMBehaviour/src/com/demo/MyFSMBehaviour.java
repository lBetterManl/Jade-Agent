package com.demo;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class MyFSMBehaviour extends FSMBehaviour {

	public  MyFSMBehaviour(Agent a){
		super(a);
		
		//初始状态,XYZ分别为状态的别名，为自己定义的
		this.registerFirstState(new OperationXBehaviour(), "X");
		//终止状态
		this.registerLastState(new OperationYBehaviour(), "Y");
		//中间状态，可多个
		this.registerState(new OperationZBehaviour(), "Z");
		
		//根据onEnd() 返回的整数，确定操作
		//onEnd() 返回1 时，由状态X切换到状态Y
		registerTransition("X", "Y", 1);
		//onEnd() 返回0 时，由状态X切换到状态Z
		registerTransition("X", "Z", 0);
		//无条件跳转，从状态Z切换回状态X,并重置X，Z的状态
		registerDefaultTransition("Z", "X", new String[]{"X","Z"});
		
		this.scheduleFirst();

	}
	
	
	//行为1  操作X  结束标志在X中给出
	class OperationXBehaviour extends OneShotBehaviour {

		private int numX;
		@Override
		public void action() {

			numX = (int) (Math.random()*100+1);
			System.out.println("产生随机数，这是操作X");
			System.out.println("本次 产生了随机数： "+numX);
			
		}
		
		@Override
		public int onEnd() {

			return ((numX % 2 == 0) ? 1:0);
		}

	}
	
	//行为2    操作Y
	class OperationYBehaviour extends OneShotBehaviour {

		@Override
		public void action() {
			
			System.out.println("产生偶数，执行操作Y");
		}
		
	}
	
	
	//行为3	操作Z
	class OperationZBehaviour extends OneShotBehaviour {

		@Override
		public void action() {
			
			System.out.println("产生奇数，执行操作Z");
		}
	}
	
}
