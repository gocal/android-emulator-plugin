package com.gocal.android.emulator.tasks

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class StartEmulatorTaskTest {

    @Test
    public void testStartEmulatorTask() {
        Project project = ProjectBuilder.builder().build()

        project.properties.put("sdk.dir", "C\\:\\Users\\marek\\dev\\tools\\android-sdk")

        project.getPlugins().apply 'com.android.application'
        project.getPlugins().apply 'android-emulator'

        project.buildscript {

        }

        if(true) {

        }
    }
}
