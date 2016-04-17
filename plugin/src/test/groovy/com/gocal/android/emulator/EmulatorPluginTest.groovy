package com.gocal.android.emulator

import com.gocal.android.emulator.avd.Avd
import com.gocal.android.emulator.utils.TestUtils
import org.apache.commons.io.FileUtils
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class EmulatorPluginTest {

    @Test
    public void startEmulator() {
        def projectDir = new File('..\\sample')
        Project project = ProjectBuilder.builder().withProjectDir(projectDir).build()
        project.getPlugins().apply 'com.android.application'
        def androidExtension = project.android;
        def androidHome = TestUtils.getAndroidHome(androidExtension)

        def emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def adbFile = FileUtils.getFile(androidHome, "platform-tools", "adb.exe")
        def emulator = new AndroidEmulator(emulatorFile.absolutePath, adbFile.absolutePath)

        Avd avd = new Avd()
        avd.name = "marek"

        emulator.setAvd(avd)

        emulator.start()
    }

    @Test
    public void stopEmulator() {
        def projectDir = new File('..\\sample')
        Project project = ProjectBuilder.builder().withProjectDir(projectDir).build()
        project.getPlugins().apply 'com.android.application'
        def androidExtension = project.android;
        def androidHome = TestUtils.getAndroidHome(androidExtension)

        def emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def adbFile = FileUtils.getFile(androidHome, "platform-tools", "adb.exe")
        def emulator = new AndroidEmulator(emulatorFile.absolutePath, adbFile.absolutePath)
        emulator.stop()
    }

    @Test
    public void testStartEmulator() {
        /*
        def projectDir = new File('..\\sample')

        def connector = GradleConnector.newConnector().forProjectDirectory(projectDir)
        def connection = connector.connect()
        try {

            BuildLauncher builder = connection.newBuild()
            def buildLaunch = builder.forTasks("startEmulator")
            buildLaunch.run()
            def model = connection.getModel(GradleProject)

        } finally {
            connection?.close()
        }
        */

        def projectDir = new File('..\\sample')
        Project project = ProjectBuilder.builder().withProjectDir(projectDir).build()
        project.getPlugins().apply 'com.android.application'
        def androidExtension = project.android;
        def androidHome = getAndroidHome(androidExtension)

        def emulatorFile = FileUtils.getFile(androidHome, "tools", "emulator.exe")
        def adbFile = FileUtils.getFile(androidHome, "platform-tools", "adb.exe")
        def emulator = new AndroidEmulator(emulatorFile.absolutePath, adbFile.absolutePath)
        def version = emulator.version
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
