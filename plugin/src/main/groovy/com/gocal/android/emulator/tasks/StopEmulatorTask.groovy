package com.gocal.android.emulator.tasks

import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class StopEmulatorTask extends BaseEmulatorTask {

    public static String NAME = "stopEmulator"

    private Logger logger = LoggerFactory.getLogger(StopEmulatorTask.simpleName)

    @TaskAction
    void startEmulator() {
        logger.error("stopping emulator")
        emulator.stop()
    }
}