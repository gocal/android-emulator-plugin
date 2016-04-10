package com.gocal.android.emulator

import org.gradle.api.tasks.Exec

class AndroidEmulator {

    File executable;

    AndroidEmulator(File executable) {
        this.executable = executable;
    }

    void start() {
        def canExecute = executable.canExecute()
        executable.toString().execute()
    }
}
