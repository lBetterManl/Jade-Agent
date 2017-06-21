<%@ page import="jade.wrapper.AgentContainer" %>
<%@ page import="jade.core.Runtime" %>
<%@ page import="jade.core.Profile" %>
<%@ page import="jade.core.ProfileImpl" %>
<%@ page import="com.yhc.agent.JspAgent" %>
<%@ page import="static jade.core.Runtime.*" %>
<%@ page import="jade.wrapper.AgentController" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/20
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Agent Web</title>
  </head>
  <body>
    <%
      try {
          String[] args = {"-gui"};
          jade.Boot.main(args);
      } catch (Exception e) {
          out.println(e);
      }
      try {
        Runtime runtime;
        AgentContainer container;
        runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl(false);
        container = runtime.createAgentContainer(profile);
        Object reference = new Object();
        Object[] args = new Object[1];
        args[0] = reference;
        container.createNewAgent("jspagent", "com.yhc.agent.JspAgent", args);
        AgentController controller = container.getAgent("jspagent");
        controller.start();
      } catch (Exception ex) {
        out.println(ex);
      }

      JspAgent jsp = new JspAgent();
      jsp.setMystr("Hello World!");

    %>

    <%=jsp.getMystr()%>

  </body>
</html>
