package com.huli;

import com.huli.logger.AbstractLogger;
import com.huli.logger.ChainOfLoggers;

public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎来到责任链模式");

        AbstractLogger loggerChain = ChainOfLoggers.getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO,"info");

        loggerChain.logMessage(AbstractLogger.DEBUG,"debug");

        loggerChain.logMessage(AbstractLogger.ERROR,"error");


    }
}