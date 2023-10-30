package com.huli.logger;

import com.huli.logger.impl.ConsoleLogger;
import com.huli.logger.impl.ErrorLogger;
import com.huli.logger.impl.FileLogger;

public  class ChainOfLoggers {

    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);

        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;

    }

}
