package com.pubsub;

import com.pubsub.subscribersImpl.Observer;

public interface Observable {

    void addObserver(Topic topic, Observer observer);

    void removeObserver(Topic topic, Observer observer);

    void publishTopic(Topic topic, Message message);

}
