package com.gocal.android.emulator.utils

class TestUtils {

    public static String getAndroidHome(androidExtension) {
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
