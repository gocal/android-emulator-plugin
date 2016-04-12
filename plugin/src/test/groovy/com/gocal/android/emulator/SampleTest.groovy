package com.gocal.android.emulator

import org.apache.commons.io.FileUtils
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class SampleTest {

    @Test
    public void testStartEmulator() {

        def projectDir = new File('..\\sample')

        Project project = ProjectBuilder.builder().withProjectDir(projectDir).build()
        project.getPlugins().apply 'com.android.application'
        def androidExtension = project.android;
        String androidHome = getAndroidHome(androidExtension)

        File emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def emulator = new AndroidEmulator(emulatorFile.getAbsolutePath())
        def version = emulator.getVersion()
        if(version != null) {

        }
    }

    private static String getAndroidHome(androidExtension) {
        def androidHome
        if (androidExtension.hasProperty('sdkHandler')) {
            androidHome = "${androidExtension.sdkHandler.sdkFolder}"
        } else if (androidExtension.hasProperty('sdkDirectory')) {
            androidHome = "${androidExtension.sdkDirectory}"
        } else {
            throw new IllegalStateException('The android plugin is not exposing the SDK folder in an expected way.')
        }
        androidHome
    }
}
