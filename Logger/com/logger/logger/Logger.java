package com.logger.logger;

import com.logger.LogLevel;
import com.logger.logAppender.ConsoleAppender;
import com.logger.logAppender.LogAppender;
import com.logger.logFormatter.DefaultFormatter;
import com.logger.logFormatter.LogFormatter;

public abstract class Logger {

    Logger nextLogger;

    static LogFormatter logFormatter;
    static LogAppender logAppender;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;

        logFormatter = new DefaultFormatter();
        logAppender = new ConsoleAppender();
    }

    public void setLogAppender(LogAppender logAppender) {
        Logger.logAppender = logAppender;
    }

    public void setLogFormatter(LogFormatter logFormatter) {
        Logger.logFormatter = logFormatter;
    }

    protected synchronized void appendLog(String msg, LogLevel logLevel) {
        logAppender.appendMessage(logFormatter.formatMessage(msg, logLevel));
    }

    public abstract void log(String msg, LogLevel logLevel);

    protected void nextLogger(String msg, LogLevel logLevel) {
        nextLogger.log(msg, logLevel);
    }

}
