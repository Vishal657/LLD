package com.logger.logFormatter;

import com.logger.LogLevel;

public class DefaultFormatter implements LogFormatter {

    @Override
    public String formatMessage(String msg, LogLevel logLevel) {
        return logLevel.toString() + ": " + msg;
    }

}
