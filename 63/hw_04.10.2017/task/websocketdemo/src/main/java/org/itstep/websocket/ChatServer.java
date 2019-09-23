package org.itstep.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/chat", encoders = {MessageEncode.class})
public class ChatServer {

    @OnOpen
    public void init(Session session, EndpointConfig config) {
        System.out.println("Session start: " + session.getId());
        System.out.println("Thread: " + Thread.currentThread().getId());
    }

    @OnMessage
    public void messageReceive(String message, Session session) throws IOException {
        System.out.println("Session: " + session.getId());
        System.out.println("Message receive: " + message);

        for(Session s: session.getOpenSessions()) {
            try {
                s.getBasicRemote().sendObject(new Message(1, message));
            } catch (EncodeException e) {
                e.printStackTrace();
            }
//            s.getBasicRemote().sendText("Server received message "+ message
//                    +" from client " + session.getId()
//                    +" at " + LocalDateTime.now().toString());
        }

        //return "Server response at " + LocalDateTime.now().toString();
    }

    @OnError
    public void error(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @OnClose
    public void close(CloseReason closeReason) {
        System.out.println(closeReason.toString());
    }
}
