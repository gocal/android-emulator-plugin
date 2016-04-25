package com.gocal.android.emulator

import com.gocal.android.emulator.avd.Avd
import org.gradle.api.Project

class EmulatorExtension {
    String avdName
    Avd avd = new Avd()

    private Project project

    EmulatorExtension(Project project) {
        this.project = project
    }

    void avd(Closure closure) {
        project.configure(avd, closure)
    }

}
