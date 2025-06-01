package com.logger.logger;

import com.logger.LogLevel;

public class DebugLogger extends Logger {

    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(String msg, LogLevel logLevel) {
        if(logLevel == LogLevel.DEBUG) {
            appendLog(msg, LogLevel.DEBUG);
        } else {
            nextLogger(msg, logLevel);
        }
    }
}
