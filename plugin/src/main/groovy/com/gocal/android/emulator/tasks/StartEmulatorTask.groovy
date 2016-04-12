package com.gocal.android.emulator.tasks

import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class StartEmulatorTask extends BaseEmulatorTask {

    public static String NAME = "startEmulator"

    private Logger LOG = LoggerFactory.getLogger(StartEmulatorTask.class)

    @TaskAction
    void startEmulator() {
        LOG.error("starting emulator")
        emulator.start()
    }
}