package com.pubsub.subscribersImpl;

import com.pubsub.Message;

public interface Observer {

    void update(Message message);

}
