package com.gocal.android.emulator.avd

import com.gocal.android.emulator.AndroidEmulator
import com.gocal.android.emulator.utils.TestUtils
import org.apache.commons.io.FileUtils
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class AvdHelperTest {

    @Test
    public void testCreateAvd() {
        def projectDir = new File('..\\sample')
        Project project = ProjectBuilder.builder().withProjectDir(projectDir).build()
        project.getPlugins().apply 'com.android.application'
        def androidExtension = project.android;
        def androidHome = TestUtils.getAndroidHome(androidExtension)

        def avdHelper = new AvdHelper(androidHome)

        def avdDir = projectDir.absolutePath + "\\build\\avd"
        def avd = new Avd()
        avd.name = "marek"
        avd.abi = AvdAbi.X86_64
        avd.tag = AvdTag.GOOGLE_APIS
        avd.apiLevel = 22
        avd.skin = AvdSkin.WVGA800

        avdHelper.createAvd(avdDir, avd)
    }
}
