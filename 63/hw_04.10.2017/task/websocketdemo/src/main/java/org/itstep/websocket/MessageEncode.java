package org.itstep.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncode implements Encoder.Text<Message> {
    @Override
    public String encode(Message message) throws EncodeException {
        return "[" + message.getLocalDateTime() + "] " + message.getId() + " : " + message.getMessage();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
