package com.gocal.android.emulator

enum EmulatorParameter {

    LIST_AVDS("list-avds"),
    AVD("avd"),
    VERSION("version"),

    private String value;

    EmulatorParameter(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }
}
