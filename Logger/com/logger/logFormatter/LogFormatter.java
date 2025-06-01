package com.logger.logFormatter;

import com.logger.LogLevel;

public interface LogFormatter {

    String formatMessage(String msg, LogLevel logLevel);

}
