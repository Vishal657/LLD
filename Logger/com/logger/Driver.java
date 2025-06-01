package com.logger;

import com.logger.logger.DebugLogger;
import com.logger.logger.ErrorLogger;
import com.logger.logger.InfoLogger;
import com.logger.logger.Logger;

public class Driver {

    public static void main(String[] args) {
        Logger logger = new ErrorLogger(new DebugLogger(new InfoLogger(null)));         // we can use factory or builder


        logger.log("ERROR Log", LogLevel.ERROR);
        logger.log("DEBUG Log", LogLevel.DEBUG);
        logger.log("INFO Log", LogLevel.INFO);
    }


}
