package com.gocal.android.emulator.utils

import com.android.annotations.NonNull
import com.android.annotations.Nullable
import com.android.repository.api.ProgressIndicatorAdapter
import org.slf4j.Logger

class LoggerProgressIndicator extends ProgressIndicatorAdapter {

    Logger logger

    LoggerProgressIndicator(Logger logger) {
        this.logger = logger
    }

    @Override
    public void logWarning(@NonNull String s, @Nullable Throwable e) {
        logger.warn(s, e)
    }

    @Override
    public void logError(@NonNull String s, @Nullable Throwable e) {
        logger.error(s, e)

    }

    @Override
    public void logInfo(@NonNull String s) {
        logger.info(s)
    }
}
