package com.gocal.android.emulator.tasks

import com.gocal.android.emulator.EmulatorExtension
import com.gocal.android.emulator.avd.Avd
import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class StartEmulatorTask extends BaseEmulatorTask {

    public static String NAME = "startEmulator"

    private Logger logger = LoggerFactory.getLogger(StartEmulatorTask.class)

    @TaskAction
    void startEmulator() {
        logger.error("starting emulator")

        EmulatorExtension emulatorExtension = project.emulator
        def avd = project.emulator.avd
        avd.name = emulatorExtension.avdName
        emulator.avd = avd

        logger.error("Start avd " + avd)

        emulator.start()
    }
}