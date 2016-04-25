package com.gocal.android.emulator.avd

public enum AvdTag {

    DEFAULT("default"),
    ANDROID_TV("android-tv"),
    ANDROID_WEAR("android-wear"),
    GOOGLE_APIS("google_apis"),
    GOOGLE_APIS_X86("google_apis_x86");
    String name

    AvdTag(String name) {
        this.name = name
    }

    public static AvdTag asAvdTag(String value) {
        for (AvdTag tag : values()) {
            if(tag.name.equals(value)) {
                return tag
            }
        }
        return null
    }
}