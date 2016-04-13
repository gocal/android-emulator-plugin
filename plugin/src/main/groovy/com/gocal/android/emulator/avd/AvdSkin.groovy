package com.gocal.android.emulator.avd

public enum AvdSkin {

    HVGA("HVGA"),
    QVGA("QVGA"),
    WQVGA400("WQVGA400"),
    WQVGA432("WQVGA432"),
    WSVGA("WSVGA"),
    WVGA800("WVGA800"),
    WVGA854("WVGA854"),
    WXGA720("WXGA720"),
    WXGA800("WXGA800"),
    WXGA800_7in("WXGA800_7in");

    String name

    AvdSkin(String name) {
        this.name = name
    }
}
