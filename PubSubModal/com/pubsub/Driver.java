package com.pubsub;

import com.pubsub.MessageDeliveryStrategy.impl.AsyncDeliveryImpl;
import com.pubsub.publishersImpl.Publisher;
import com.pubsub.publishersImpl.impl.StockPublisher;
import com.pubsub.publishersImpl.impl.WeatherPublisher;
import com.pubsub.subscribersImpl.Observer;
import com.pubsub.subscribersImpl.impl.Laptop;
import com.pubsub.subscribersImpl.impl.IPhone;
import com.pubsub.subscribersImpl.impl.AndroidPhone;

public class Driver {

    public static void main(String[] args) {
        // observables
        Observable pubSubObservable = new PubSubObservable(new AsyncDeliveryImpl());

        // subscribers
        Observer laptop = new Laptop();
        Observer iPhone = new IPhone();
        Observer androidPhone = new AndroidPhone();

        // publishers
        Publisher stockPublisher = new StockPublisher(pubSubObservable);
        Publisher weatherPublisher = new WeatherPublisher(pubSubObservable);

        pubSubObservable.addObserver(Topic.Stock, laptop);
        pubSubObservable.addObserver(Topic.Weather, iPhone);
        pubSubObservable.addObserver(Topic.Weather, androidPhone);
        pubSubObservable.addObserver(Topic.Weather, androidPhone);

        stockPublisher.publishMessage(new Message("stock price fall time to buy!!", null));
        weatherPublisher.publishMessage(new Message("snow fall don't go out", null));

        System.out.println("---");
        System.out.println("Iphone Unsubscribing weather update");
        System.out.println("---");

        pubSubObservable.removeObserver(Topic.Weather, iPhone);
        weatherPublisher.publishMessage(new Message("snow fall stop you can go out", null));

    }

}
