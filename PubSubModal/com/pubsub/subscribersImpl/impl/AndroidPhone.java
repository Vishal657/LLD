package com.pubsub.subscribersImpl.impl;

import com.pubsub.Message;
import com.pubsub.subscribersImpl.Observer;

public class AndroidPhone implements Observer {

    @Override
    public void update(Message message) {
        System.out.println(AndroidPhone.class.getName() + "  Message received " + message.message);
    }
}
