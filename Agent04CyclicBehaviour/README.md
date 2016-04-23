###CyclicBehaviour 
>'CyclicBehaviour'也是'SimpleBehaviour'的子类，可以被循环调用，
执行该行为的Agent一直保存活动状态，则该行为一直保持活动状态。
同'OneShotBehaviour'一样不需重写done()方法，不同的是其done()一直返回"false"

Agent04里面的都是组合行为 SimpleBehaviour