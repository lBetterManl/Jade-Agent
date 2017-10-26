## 一次性行为(OneShotBehaviour)

> 'OneShotBehaviour'是'Simple Behaviour'的子类，其action() 方法只执行一次，
因为其done() 方法永远返回 "true",所以编程时不需要对done() 方法进行重写。

### 除'OneShotBehaviour'外还有一个特殊一次性行为'WakerBehaviour'
> 类似闹钟，在指定时间后执行一次的Behaviour.执行其抽象方法onWake().
补充：  handElapsedTimeout()已过时，用onWake() 代替


Agent04里面的都是组合行为 SimpleBehaviour
