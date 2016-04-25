package com.gocal.android.emulator.utils

import com.android.utils.ILogger
import org.slf4j.Logger

class DefaultAndroidLogger implements ILogger {

    Logger logger

    DefaultAndroidLogger(Logger logger) {
        this.logger = logger
    }

    @Override
    void error(Throwable t, String msgFormat, Object... args) {
        logger.error(String.format(msgFormat, args), t)
    }

    @Override
    void warning(String msgFormat, Object... args) {
        logger.warn(String.format(msgFormat, args))
    }

    @Override
    void info(String msgFormat, Object... args) {
        logger.info(String.format(msgFormat, args))
    }

    @Override
    void verbose(String msgFormat, Object... args) {
        logger.debug(String.format(msgFormat, args))
    }
}
