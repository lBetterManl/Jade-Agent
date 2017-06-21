package com.yhc.gateway;


import jade.core.Profile;
import jade.util.leap.Properties;
import jade.wrapper.gateway.JadeGateway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by hp on 2017/6/20.
 */
public class MyGatewayServlet extends HttpServlet {
    private Hashtable actions = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("action");
        Action action = (Action)actions.get(actionName);
        action.perform(this, req, resp);
    }

    @Override
    public void init() throws ServletException {
        actions = new Hashtable<>();
        actions.put("sendmsg", new SendMsgAction());
        Properties pp = new Properties();
        pp.setProperty(Profile.MAIN, "false");
        JadeGateway.init("com.yhc.gateway.MyGatewayAgent", pp);
    }
}
