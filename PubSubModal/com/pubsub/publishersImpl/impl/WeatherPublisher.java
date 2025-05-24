package com.pubsub.publishersImpl.impl;

import com.pubsub.Message;
import com.pubsub.Observable;
import com.pubsub.Topic;
import com.pubsub.publishersImpl.Publisher;

public class WeatherPublisher implements Publisher {

    Observable observable;

    public WeatherPublisher(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void publishMessage(Message message) {
        observable.publishTopic(Topic.Weather, message);
    }
}
