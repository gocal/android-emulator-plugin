package com.gocal.android.emulator.avd

public enum AvdAbi {

    X86("x86"),
    X86_64("x86_64"),
    ARMEABI_V7A("armeabi-v7a");

    String name

    AvdAbi(String name) {
        this.name = name
    }
}
