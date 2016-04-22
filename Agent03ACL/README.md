###与其他Agent通信
1.JADE中Agent之间的通信基于异步通信模式
2.每个JADE Agent都有一个邮箱，Agent之间通过邮箱互通消息
3.遵循FIPA规范，JADE Agent之间交换的是ACL消息（ACLMessage类的一个对象）

####主要消息域
1.消息的发送者；
2.消息接收者列表；
3.消息原语，如REQUEST 原语表示发送方请求接收方执行某种操作
4.消息的具体内容
5.用来表达消息内容的语言，如English
6.用来说明消息内容中某些词汇或短语的本体Ontology
7.其他

####流程
发送方（Agent）-》新建ACLMessage对象-》调用Agent.send()方法发送消息
接收方（Agent）-》调用receive() 或者blockingReceive() 方法接收消息


运行方法
java jade.Boot -gui
alice:com.demo.SecondAgent;tom:com.demo.FirstAgent