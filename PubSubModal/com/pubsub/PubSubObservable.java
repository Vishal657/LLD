package com.pubsub;

import com.pubsub.MessageDeliveryStrategy.MessageDeliveryStrategy;
import com.pubsub.subscribersImpl.Observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PubSubObservable implements Observable {

    // it's fine for this example if observer does not implements equals method. Because by default, reference comparison will be done by the set.
    // same object will never be added twice. But it's always good idea in real world application to implement equals method.
    Map<Topic, Set<Observer>> topicObserversMap;
    MessageDeliveryStrategy messageDeliveryStrategy;

    public PubSubObservable(MessageDeliveryStrategy messageDeliveryStrategy) {
        this.messageDeliveryStrategy = messageDeliveryStrategy;
        topicObserversMap = new HashMap<>();
    }


    @Override
    public void addObserver(Topic topic, Observer observer) {
        Set<Observer> observers = topicObserversMap.getOrDefault(topic, new HashSet<>());
        observers.add(observer);
        topicObserversMap.put(topic, observers);
    }

    @Override
    public void removeObserver(Topic topic, Observer observer) {
        Set<Observer> observers = topicObserversMap.getOrDefault(topic, new HashSet<>());
        observers.remove(observer);
        topicObserversMap.put(topic, observers);
    }

    @Override
    public void publishTopic(Topic topic, Message message) {
        for (Observer observer : topicObserversMap.get(topic)) {
            messageDeliveryStrategy.scheduleDelivery(observer, message);
        }
    }

}
