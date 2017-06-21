package com.yhc.gateway;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.lang.acl.ACLMessage;

/**
 * Created by hp on 2017/6/20.
 *
 * 接收并输出网页发来的消息消息
 */
public class ReceiveAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg!=null){
                    System.out.println(msg.getContent());
                }
                block();
            }
        });
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (Exception e) {

        }
    }
}
