package com.yhc.gateway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 2017/6/20.
 */
public interface Action {
    public void perform(HttpServlet servlet, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
