package com.pubsub.subscribersImpl.impl;

import com.pubsub.Message;
import com.pubsub.subscribersImpl.Observer;

public class IPhone implements Observer {

    @Override
    public void update(Message message) {
        System.out.println(IPhone.class.getName() + "  Message received " + message.message);
    }
}
