package com.logger.logAppender;

public class ConsoleAppender implements LogAppender{


    @Override
    public void appendMessage(String message) {
        System.out.println(message);
    }
}
