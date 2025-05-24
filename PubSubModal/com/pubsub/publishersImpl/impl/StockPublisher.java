package com.pubsub.publishersImpl.impl;

import com.pubsub.Message;
import com.pubsub.Observable;
import com.pubsub.Topic;
import com.pubsub.publishersImpl.Publisher;

public class StockPublisher implements Publisher {

    Observable observable;

    public StockPublisher(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void publishMessage(Message message) {
        observable.publishTopic(Topic.Stock, message);
    }
}
