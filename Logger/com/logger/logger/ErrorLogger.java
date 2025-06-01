package com.logger.logger;

import com.logger.LogLevel;

public class ErrorLogger extends Logger {

    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(String msg, LogLevel logLevel) {
        if(logLevel == LogLevel.ERROR) {
            appendLog(msg, LogLevel.ERROR);
        } else {
            nextLogger(msg, logLevel);
        }
    }
}
