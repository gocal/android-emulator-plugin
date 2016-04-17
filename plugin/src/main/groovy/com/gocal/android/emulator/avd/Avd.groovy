package com.gocal.android.emulator.avd

public class Avd {
    AvdTarget target
    boolean snapshot
    AvdAbi abi
    String device // TODO cheeck
    String name
    AvdSkin skin
    AvdTag tag
    int apiLevel


    @Override
    public String toString() {
        return "Avd{" +
                "target=" + target +
                ", snapshot=" + snapshot +
                ", abi=" + abi +
                ", device='" + device + '\'' +
                ", name='" + name + '\'' +
                ", skin=" + skin +
                ", tag=" + tag +
                ", apiLevel=" + apiLevel +
                '}';
    }
}
