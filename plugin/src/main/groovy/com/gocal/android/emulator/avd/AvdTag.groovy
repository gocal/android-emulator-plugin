package com.gocal.android.emulator.avd

public enum AvdTag {

    DEFAULT("default"),
    ANDROID_TV("android_tv"),
    ANDROID_WEAR("android_wear"),
    GOOGLE_APIS("google_apis");

    String name

    AvdTag(String name) {
        this.name = name
    }
}