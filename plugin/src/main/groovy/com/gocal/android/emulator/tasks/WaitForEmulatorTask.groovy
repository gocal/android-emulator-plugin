package com.gocal.android.emulator.tasks

import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class WaitForEmulatorTask extends BaseEmulatorTask {

    public static String NAME = "waitForEmulator"

    private Logger logger = LoggerFactory.getLogger(WaitForEmulatorTask.simpleName)

    @TaskAction
    void waitForEmulator() {
        throw new IllegalStateException("Not implemented")
    }
}