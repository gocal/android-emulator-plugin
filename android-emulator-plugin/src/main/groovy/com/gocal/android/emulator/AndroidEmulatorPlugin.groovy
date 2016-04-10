package com.gocal.android.emulator

import com.gocal.android.emulator.tasks.StartEmulatorTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.StopExecutionException

class AndroidEmulatorPlugin implements Plugin<Project> {

    public final static String EXTENSION_NAME = "emulator"

    @Override
    void apply(Project project) {
        if (!project.plugins.hasPlugin('android')) {
            throw new StopExecutionException("'android' plugin is missing.")
        }

        project.extensions.create(EXTENSION_NAME, AndroidEmulatorExtension)
        project.task(StartEmulatorTask.NAME, type: StartEmulatorTask)
    }
}
