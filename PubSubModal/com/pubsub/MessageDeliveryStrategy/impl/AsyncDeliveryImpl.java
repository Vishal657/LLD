package com.pubsub.MessageDeliveryStrategy.impl;

import com.pubsub.Message;
import com.pubsub.MessageDeliveryStrategy.MessageDeliveryStrategy;
import com.pubsub.subscribersImpl.Observer;

import java.util.LinkedList;
import java.util.Queue;

public class AsyncDeliveryImpl implements MessageDeliveryStrategy {

    class Pair {
        Observer observer;
        Message message;

        Pair(Observer observer, Message message) {
            this.observer = observer;
            this.message = message;
        }
    }

    Queue<Pair> messageQueue;

    public AsyncDeliveryImpl() {
        messageQueue = new LinkedList<>();
    }

    @Override
    public void scheduleDelivery(Observer observer, Message message) {
        messageQueue.add(new Pair(observer, message));
        deliverMessage();
    }

    public void deliverMessage() {
        // kind of scheduler takes the message from Q and delivers it one by one
        Pair pair = messageQueue.poll();
        pair.observer.update(pair.message);
    }
}
