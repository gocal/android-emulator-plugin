package com.gocal.android.emulator.tasks

import com.gocal.android.emulator.AndroidEmulator
import com.gocal.android.emulator.config.PluginConfig
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.slf4j.LoggerFactory

import java.util.logging.Logger

class StartEmulatorTask extends DefaultTask {

    public static String NAME = "startEmulator"

    private static final Logger LOG = LoggerFactory.getLogger(StartEmulatorTask.class)

    /*
    public StartEmulatorTask() {
        super();
        setGroup(PluginConfig.GROUP_EMULATOR)
    }
    */

    @TaskAction
    def startEmulator() {
        /*
        def androidExtension = project.android;
        String androidHome = getAndroidHome(androidExtension)
        File emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def emulator = new AndroidEmulator(emulatorFile.getAbsolutePath())
        emulator.start()
        */
    }

    /*
    private static String getAndroidHome(androidExtension) {
        def androidHome
        if (androidExtension.hasProperty('sdkHandler')) {
            androidHome = "${androidExtension.sdkHandler.sdkFolder}"
        } else if (androidExtension.hasProperty('sdkDirectory')) {
            androidHome = "${androidExtension.sdkDirectory}"
        } else {
            throw new IllegalStateException('The android plugin is not exposing the SDK folder in an expected way.')
        }
        androidHome
    }
    */


}