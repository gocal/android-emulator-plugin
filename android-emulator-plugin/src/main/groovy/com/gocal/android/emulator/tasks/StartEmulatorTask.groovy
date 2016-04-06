package com.gocal.android.emulator.tasks

import com.android.ddmlib.AndroidDebugBridge
import com.gocal.android.emulator.config.PluginConfig
import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.slf4j.LoggerFactory

import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class StartEmulatorTask extends DefaultTask {

    public static String NAME = 'startEmulator'

    private static final Logger LOG = LoggerFactory.getLogger(StartEmulatorTask.class)

    public StartEmulatorTask() {
        setGroup(PluginConfig.GROUP_EMULATOR)
    }

    // TODO - spoon sample

    @TaskAction
    def startEmulator() {
        com.android.builder
        def sdkDirectory = project.android.sdkDirectory
    }

    static AndroidDebugBridge initAdb(File sdk) {
        AndroidDebugBridge.initIfNeeded(false);
        File adbPath = FileUtils.getFile(sdk, "platform-tools", "adb");
        AndroidDebugBridge adb = AndroidDebugBridge.createBridge(adbPath.getAbsolutePath(), false);
        waitForAdb(adb);
        return adb;
    }

    private static void waitForAdb(AndroidDebugBridge adb) {
        long timeOutMs = TimeUnit.SECONDS.toMillis(30);
        long sleepTimeMs = TimeUnit.SECONDS.toMillis(1);
        while (!adb.hasInitialDeviceList() && timeOutMs > 0) {
            try {
                Thread.sleep(sleepTimeMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timeOutMs -= sleepTimeMs;
        }
        if (timeOutMs <= 0 && !adb.hasInitialDeviceList()) {
            throw new RuntimeException("Timeout getting device list.", null);
        }
    }

}