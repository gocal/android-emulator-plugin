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
        def extension = project.emulator as EmulatorExtension
        def avd = extension.avd
        emulator.avd = avd
        emulator.start()
    }
}