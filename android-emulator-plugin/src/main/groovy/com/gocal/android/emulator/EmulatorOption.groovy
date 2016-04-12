package com.gocal.android.emulator

public class EmulatorOption {

    private EmulatorParameter parameter;
    private String[] values;

    public EmulatorOption(EmulatorParameter parameter, String... values) {
        this.parameter = parameter
        this.values = values
    }

    EmulatorParameter getParameter() {
        return parameter
    }

    String[] getValues() {
        return values
    }

    boolean hasValues() {
        return values != null && values.length > 0
    }
}
