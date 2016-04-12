package com.gocal.android.emulator.tasks

import com.gocal.android.emulator.AndroidVirtualDevice
import com.gocal.android.emulator.EmulatorExtension
import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class StartEmulatorTask extends BaseEmulatorTask {

    public static String NAME = "startEmulator"

    private Logger LOG = LoggerFactory.getLogger(StartEmulatorTask.class)

    @TaskAction
    void startEmulator() {
        LOG.error("starting emulator")

        EmulatorExtension emulatorExtension = project.emulator
        def avd = new AndroidVirtualDevice()
        avd.name = emulatorExtension.avdName

        emulator.avd = avd
        emulator.start()
    }
}