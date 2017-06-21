package com.yhc.gateway;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.gateway.GatewayAgent;

/**
 * Created by hp on 2017/6/20.
 *
 * 在JADE Agent 和 网页文件之间起中间件的作用，将从Servlet中传入的信息发送给Agent
 */
public class MyGatewayAgent extends GatewayAgent {
    private DataChannel dataChannel = null;

    @Override
    protected void processCommand(Object command) {
        if (command instanceof DataChannel){
            dataChannel = (DataChannel) command;
            addBehaviour(new OneShotBehaviour(this) {
                @Override
                public void action() {
                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                    msg.addReceiver(new AID(dataChannel.getRecevier(), AID.ISLOCALNAME));
                    msg.setContent(dataChannel.getMessage());
                    myAgent.send(msg);
                }
            });
        }
    }

    @Override
    protected void setup() {
        super.setup();
    }
}
