package com.gocal.android.emulator.avd

public class Avd {
    AvdAbi abi
    AvdTag tag
    String sdCard
    String name
    AvdSkin skin
    int apiLevel
    Map<String, String> hardwareConfig
    Map<String, String> bootProperties
    boolean createSnapshot
    boolean removePrevious
    boolean editExisting
}
