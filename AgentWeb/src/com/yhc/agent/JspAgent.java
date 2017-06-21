package com.yhc.agent;

import jade.core.Agent;

/**
 * Created by hp on 2017/6/20.
 */
public class JspAgent extends Agent {

    private String Mystr;   //私有变量

    public String getMystr() {
        return Mystr;
    }

    public void setMystr(String mystr) {
        Mystr = mystr;
    }

    @Override
    protected void setup() {
        super.setup();
    }
}
