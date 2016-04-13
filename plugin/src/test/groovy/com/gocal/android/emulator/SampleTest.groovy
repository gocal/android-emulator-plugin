package com.gocal.android.emulator

import com.android.ddmlib.AndroidDebugBridge
import org.apache.commons.io.FileUtils
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.tooling.BuildLauncher
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.model.GradleProject
import org.junit.Test

class SampleTest {

    @Test
    public void testStartEmulator() {

        /*
        def projectDir = new File('..\\sample')

        def connector = GradleConnector.newConnector().forProjectDirectory(projectDir)
        def connection = connector.connect()

        try {

            BuildLauncher builder = connection.newBuild()
            builder.forTasks("startEmulator").run()
            def model = connection.getModel(GradleProject)

        } finally {
            connection?.close()
        }
        */

        /*
        Project project = ProjectBuilder.builder().withProjectDir(projectDir).build()

        def androidExtension = project.android;
        def androidHome = getAndroidHome(androidExtension)

        def emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def adbFile = FileUtils.getFile(androidHome, "platform-tools", "adb.exe")
        def emulator = new AndroidEmulator(emulatorFile.absolutePath, adbFile.absolutePath)
        def version = emulator.version
        if(version != null) {

        }
        */
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
