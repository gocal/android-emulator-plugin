package com.gocal.android.emulator

import com.gocal.android.emulator.tasks.StartEmulatorTask
import com.gocal.android.emulator.tasks.StopEmulatorTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.StopExecutionException

class EmulatorPlugin implements Plugin<Project> {

    public final static String EXTENSION_NAME = "emulator"

    @Override
    void apply(Project project) {
        if (!project.plugins.hasPlugin('android')) {
            throw new StopExecutionException("'android' plugin is missing.")
        }

        // project.extensions.add EXTENSION_NAME, EmulatorExtension
        project.extensions.create(EXTENSION_NAME, EmulatorExtension)
        project.tasks.create(name: StartEmulatorTask.NAME, type: StartEmulatorTask) {}
        project.tasks.create(name: StopEmulatorTask.NAME, type: StopEmulatorTask) {}
    }

}
