package com.yhc.gateway;

import jade.wrapper.ControllerException;
import jade.wrapper.gateway.JadeGateway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 2017/6/20.
 */
public class SendMsgAction implements Action {
    @Override
    public void perform(HttpServlet servlet, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = req.getParameter("param1");
        String message = new String(msg.getBytes("ISO-8859-1"), "UTF-8");
        DataChannel dataChannel = new DataChannel(message, "receiver");
        try {
            JadeGateway.execute(dataChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
