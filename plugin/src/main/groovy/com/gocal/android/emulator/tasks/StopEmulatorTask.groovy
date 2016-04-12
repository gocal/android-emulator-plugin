package com.gocal.android.emulator.tasks

import com.gocal.android.emulator.EmulatorExtension
import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class StopEmulatorTask extends BaseEmulatorTask {

    public static String NAME = "stopEmulator"

    private Logger logger = LoggerFactory.getLogger(StopEmulatorTask.simpleName)

    @TaskAction
    void stopEmulator() {
        logger.error("stopping emulator")

        EmulatorExtension emulatorExtension = project.emulator
        logger.error("avdName " + emulatorExtension.avdName)

        emulator.stop()
    }
}