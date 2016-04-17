package com.gocal.android.emulator.avd

import com.android.sdklib.IAndroidTarget


import com.android.sdklib.internal.avd.AvdInfo
import com.android.sdklib.internal.avd.AvdManager
import com.android.sdklib.repositoryv2.AndroidSdkHandler
import com.android.utils.ILogger
import com.android.utils.NullLogger

public class AvdUtils implements ILogger {

    AvdManager avdManager
    ILogger sdkLog

    public AvdUtils(String androidHome) {
        def sdkHandler = AndroidSdkHandler.getInstance(new File(androidHome))
        sdkLog = NullLogger.getLogger() // todo
        avdManager = AvdManager.getInstance(sdkHandler, sdkLog)
    }

    public void createAvd(String directory, Avd avd) {

        avdManager.getValidAvds()

        /*
        IAndroidTarget[] targets = sdkManager.getTargets();

        def target = targets[2]

        def image = target.getSystemImages()[0]

        def avdFolder = new File(directory)
        */

        AvdInfo newAvd = avdManager.createAvd(
                avdFolder,
                "treste",
                target,
                SystemImage.DEFAULT_TAG,
                image.getAbiType(),
                null,
                null,
                null,
                null,
                null,
                false,
                false,
                false,
                sdkLog
        )

        AvdInfo[] avds = avdManager.getValidAvds();
        if(true) {

        }
    }

    @Override
    void error(Throwable t, String msgFormat, Object... args) {
        System.out.printf("Warning: " + msgFormat, args);
    }

    @Override
    void warning(String msgFormat, Object... args) {
        System.out.printf("Warning: " + msgFormat, args);
    }

    @Override
    void info(String msgFormat, Object... args) {
        System.out.printf("Warning: " + msgFormat, args);
    }

    @Override
    void verbose(String msgFormat, Object... args) {
        System.out.printf("Warning: " + msgFormat, args);
    }
}
