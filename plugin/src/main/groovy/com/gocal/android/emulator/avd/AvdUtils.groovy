package com.gocal.android.emulator.avd

import com.android.sdklib.IAndroidTarget
import com.android.sdklib.SdkManager
import com.android.sdklib.SystemImage
import com.android.sdklib.internal.androidTarget.PlatformTarget
import com.android.sdklib.internal.avd.AvdInfo
import com.android.sdklib.internal.avd.AvdManager
import com.android.sdklib.repository.descriptors.IdDisplay
import com.android.utils.ILogger
import com.android.utils.NullLogger

public class AvdUtils implements ILogger {

    AvdManager avdManager
    SdkManager sdkManager
    ILogger sdkLog

    public AvdUtils(String androidHome) {
        sdkLog = NullLogger.getLogger() // todo
        sdkManager = SdkManager.createManager(androidHome, sdkLog)
        avdManager = AvdManager.getInstance(sdkManager.getLocalSdk(), sdkLog)
    }

    public void createAvd(String directory, Avd avd) {

        IAndroidTarget[] targets = sdkManager.getTargets();

        def target = targets[2]

        def image = target.getSystemImages()[0]

        def avdFolder = new File(directory)


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
