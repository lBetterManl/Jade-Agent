
## 远程计算机上Agent间的通信

步骤：  
1.弄清Agent的名称和地址  
2.在两台机器上分别编写任意简单的Agent程序并运行  
3.在发送方Agent的运行平台(AgentPlatform)上添加与它通信的远端Agent(接收方)的平台  
操作如下：  
1.右键单击AgentPlatforms,在弹出的菜单上选中“Add Platform via AMS AID”;  
2.在弹出的对话窗口中填写NAME和Address。（这里有坑！将鼠标移到Address下的方框上右键添加）
例子： NAME:ams@YHC-PC:1099/JADE  Address:http://YHC-PC:7778/acc  

#### 构造方法设置接收方

AID dest = new AID("hy@YHC-PC:1099/JADE");
dest.addAddress("http://YHC-PC:7778/acc");

`com.example1`一个完整的远程发送方  

`com.example2`给远程机器上所有Agent发送消息  

说明：  
1.AMSAgentDescription类
	使用该类获取 AMS 上所有 Agent 的列表，常用方法是 getName()  
2.SearchConstraints类  
	用来设置约束条件，如 setMaxResults() 设置查询的最大结果集  
3.AMSService类  
	负责对 agent 中的管理，如使用该类的 search() 方法搜索 AMS 中的所有 Agent
	
---
 
## 基于对象序列化机制的 Agent 间的通信

> Agent间发送的消息从形式上说可以分为三类：  
1.原子消息：指以字符串形式发送的简单消息；  
2.Java对象：如包含图书信息的Book类；  
3.Ontology对象：即本体对象。用户定义自己的词汇或语义。  

消息内容的类型 | 读消息内容的方法 | 写消息内容的方法
----------  | ------------------ | -----------
字符串      | getContent()       | SetContent()
Java对象    | getContentObject() | SetContentObject()
Ontology对象| extractContent()   | fillContent()

本例主要讲述如何利用序列化（又称串行化机制）将Java对象作为消息内容在Agent间发送，使用的是SetContentObject()方法和getContentObject()方法

` com.example3 ` 海上轮船搜救案例
> 
1.消息内容类 ShipInfo 的定义  
2.船舶信息管理 Agent ` ShipInfoAgent ` 发送难船基本信息  
3.消息管理控制平台 ` MyMainControl `  

---

## 消息模板  

MessageTemplate类用于过滤消息，设置消息的的通信行为，消息接收者等。  
` com.example4 ` A1,A2接收来自T1de消息，并回复消息；但T1只接收来自A1的消息。
