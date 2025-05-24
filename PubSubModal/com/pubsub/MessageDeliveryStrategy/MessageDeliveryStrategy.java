package com.pubsub.MessageDeliveryStrategy;

import com.pubsub.Message;
import com.pubsub.subscribersImpl.Observer;

public interface MessageDeliveryStrategy {

    void scheduleDelivery(Observer observer, Message message);

}

