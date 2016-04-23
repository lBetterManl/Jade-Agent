###一个特殊的循环行为（TickerBehaviour）
>Agent 周期性地执行某项动作，如：每隔一段时间对数据库更新
'TickerBehaviour'也派生自SampleBehaviour
不需要重写action() 和 done()
任何一个子类都要实现onTick()方法

##本例实现对MySQL数据库的查询

Agent04里面的都是组合行为 SimpleBehaviour