package com.gocal.android.emulator

import com.gocal.android.emulator.avd.Avd
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.Copy
import org.gradle.testfixtures.ProjectBuilder
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class EmulatorPluginTest {

    private Project project
    private static final PLUGIN_ID = 'android-emulator'

    @BeforeMethod
    public void setUp() throws Exception {
        project = ProjectBuilder.builder().build()
        project.buildscript {

            repositories {
                jcenter()
            }

            dependencies {
                classpath 'org.jacoco:org.jacoco.core:0.7.4.201502262128'
                classpath 'com.android.tools.build:gradle:2.0.0'
            }
        }

        project.apply plugin: 'com.android.application'

        def androidApplication = project.plugins.getPlugin('com.android.application')
        androidApplication.sdkHandler.sdkFolder = new File("C:\\Users\\marek\\dev\\tools\\android-sdk")

        project.apply plugin: 'android-emulator'
    }

    @Test
    public void testExtension() {
        def extension = project.emulator as EmulatorExtension
        def avd = new Avd()
        extension.avd = avd
    }
}
