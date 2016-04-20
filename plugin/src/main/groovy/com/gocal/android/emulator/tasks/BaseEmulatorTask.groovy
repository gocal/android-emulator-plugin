package com.gocal.android.emulator.tasks

import com.gocal.android.emulator.AndroidEmulator
import com.gocal.android.emulator.PluginConfig
import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask

abstract class BaseEmulatorTask extends DefaultTask {

    protected AndroidEmulator emulator;

    public BaseEmulatorTask() {
        super();
        setGroup(PluginConfig.GROUP_EMULATOR)

        def androidExtension = project.android;
        def androidHome = getAndroidHome(androidExtension)
        def emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def adbFile = FileUtils.getFile(androidHome, "platform-tools", "adb.exe")
        emulator = new AndroidEmulator(emulatorFile.absolutePath, adbFile.absolutePath)
    }

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
}
