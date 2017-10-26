## 有限状态机行为(FSMBehaviour)
> FSMBehaviour也是一种组合行为 CompositeBehaviour  
根据用户定义的有限状态机制执行它的子行为  
每个子类描述了一个FSM状态中要完成的动作，用户可以定义在FSM状态之间的转换  

### 流程
> 当一个对应于状态S1的子类完成后，它的终止值（由onEnd()方法返回）用来选择到活动状态的转换， 
这样就可以达到一个新的状态S2.在下一个循环中，将会执行对应于S2的子类。 

可以将某些FSMBehaviour类的子类注册为终止状态，任意一个代表终止状态的子类完成，FSMBehaviour行为就会终止。

## 调用FSMBehaviour至少需要以下步骤
1.调用 registerFirstState() 方法注册一个单一的行为作为有限状态机模型的初始状态；  
2.调用 registerLastState() 方法注册一个或多个行为作为有限状态机模型的终止状态；  
3.调用 registerState() 方法注册一个或多个行为作为有限状态机模型的中间状态；  
4.杜宇有限状态机的每一个状态，调用 registerTransition() 方法，注册该状态到另一个状态的变迁  
5.调用 registerDefaultTransition() 方法注册从一个状态到另一个状态的无条件的变迁  

## 本例实现内容：
包括3个子行为，行为1是初始状态，执行操作X（生成一个随机数若为偶数，终止，执行行为2（操作Y）；若是奇数，执行行为3（操作Z），并由3重新激活初始状态）

即：随机数为奇数会继续生成，直到偶数为止


Agent05里面的都是组合行为 CompositeBehaviour
