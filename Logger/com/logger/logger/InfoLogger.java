package com.logger.logger;

import com.logger.LogLevel;

public class InfoLogger extends Logger {

    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(String msg, LogLevel logLevel) {
        if(logLevel == LogLevel.INFO) {
            appendLog(msg, logLevel);
        } else {
            nextLogger(msg, logLevel);
        }
    }
}
