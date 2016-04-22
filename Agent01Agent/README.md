##基于JADE的多Agent开发

###先安装jdk

>配置jade环境变量（`jade.jar`   `commons-codec-1.3.jar`）
新建`JADE_HOME`  值为文件夹路径
`CALSSPATH`配置    `%JADE_HOME%\jade.jar`   `%JADE_HOME%\commons-codec-1.3.jar`

检查安装   运行 `java jade.Boot -gui` 弹出窗口就成功

###MyEclipse运行
>右键项目》 run as》Run Configuration》java application》Main class（jade.Boot)》Arguments(-gui hello:my.first.FirstAgent)

#此项目新建一个Agent

参考书：
基于JADE平台的多Agent系统开发技术   于卫红、陈燕