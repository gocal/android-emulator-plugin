package com.gocal.android.emulator

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * Created by marek on 06.04.2016.
 */
class SampleTest {

    @Test
    public void aaa() {
        Project project = ProjectBuilder.builder().build()
        project.getPlugins().apply 'com.android.application'
        if(project != null) {

        }
    }
}
