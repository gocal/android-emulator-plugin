package com.gocal.android.emulator

import com.gocal.android.emulator.tasks.StartEmulatorTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.StopExecutionException

class AndroidEmulatorPlugin implements Plugin<Project> {

    public final static String TASK_GROUP = "emulator"

    @Override
    void apply(Project project) {
        if (!project.plugins.hasPlugin('android')) {
            throw new StopExecutionException("'android' plugin is missing.")
        }

        def extension = project.extensions.create(TASK_GROUP, AndroidEmulatorExtension)

        project.task(StartEmulatorTask.NAME, type: StartEmulatorTask)
    }
}
