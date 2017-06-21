package com.yhc.gateway;

import jade.Boot;

/**
 * Created by hp on 2017/6/20.
 */
public class RunReceiveAgent {
    public static void main(String[] args) {
        String[] str = {"-gui", "receiver:com.yhc.gateway.ReceiveAgent"};
        Boot.main(str);
    }
}
