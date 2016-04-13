package com.gocal.android.emulator.avd

import com.android.sdklib.SdkManager
import com.android.sdklib.internal.avd.AvdInfo
import com.android.sdklib.internal.avd.AvdManager
import com.android.utils.ILogger

public class AvdUtils {

    AvdManager avdManager

    public AvdUtils(String  androidHome) {
        ILogger sdkLog = null // todo
        SdkManager mSdkManager = SdkManager.createManager(androidHome, sdkLog)
        avdManager = AvdManager.getInstance(mSdkManager.getLocalSdk(), sdkLog)
    }

    public void createAvd(Avd avd) {
        AvdInfo[] avds = avdManager.getValidAvds();
        if(true) {

        }
    }
}
