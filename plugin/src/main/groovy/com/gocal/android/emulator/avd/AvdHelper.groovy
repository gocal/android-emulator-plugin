package com.gocal.android.emulator.avd

import com.android.sdklib.ISystemImage
import com.android.sdklib.internal.avd.AvdInfo
import com.android.sdklib.internal.avd.AvdManager
import com.android.sdklib.repositoryv2.AndroidSdkHandler
import com.android.sdklib.repositoryv2.targets.SystemImage
import com.android.utils.ILogger
import com.gocal.android.emulator.utils.DefaultAndroidLogger
import com.gocal.android.emulator.utils.LoggerProgressIndicator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

public class AvdHelper {

    Logger logger = LoggerFactory.getLogger(AvdHelper.simpleName)
    ILogger androidLogger = new DefaultAndroidLogger(logger)

    AvdManager avdManager
    AndroidSdkHandler sdkHandler

    public AvdHelper(String androidHome) {
        sdkHandler = AndroidSdkHandler.getInstance(new File(androidHome))
        avdManager = AvdManager.getInstance(sdkHandler, androidLogger)
    }

    public Collection<Avd> listAvdsImages() {
        def avds = new ArrayList<Avd>()
        def systemImageManager = sdkHandler.getSystemImageManager(new LoggerProgressIndicator(logger))
        def images = systemImageManager.getImages()
        for (SystemImage image : images) {
            avds.add(from(image))
        }
        return avds
    }

    public boolean createAvd(String directory, Avd avd) {

        def systemImageManager = sdkHandler.getSystemImageManager(new LoggerProgressIndicator(logger))
        def systemImage = findSystemImage(avd, systemImageManager.getImages())

        if (systemImage == null) {
            throw new IllegalStateException("System image not found")
        }

        String avdName = avd.name
        def avdFolder = new File(directory, avdName)

        File skinFolder = getSkinFile(systemImage, avd.skin)
        String skinName = AvdSkin.asAvdSkin(skinFolder).name
        String sdcard = avd.sdCard
        Map<String, String> hardwareConfig = avd.hardwareConfig
        Map<String, String> bootProps = avd.bootProperties
        boolean createSnapshot = avd.createSnapshot
        boolean removePrevious = avd.removePrevious
        boolean editExisting = avd.editExisting

        AvdInfo newAvd = avdManager.createAvd(
                avdFolder,
                avdName,
                systemImage,
                skinFolder,
                skinName,
                sdcard,
                hardwareConfig,
                bootProps,
                createSnapshot,
                removePrevious,
                editExisting,
                androidLogger
        )

        return newAvd != null;
    }

    private ISystemImage findSystemImage(Avd avd, Collection<ISystemImage> images) {
        for (def image : images) {
            if (matches(avd, image)) {
                return image;
            }
        }
        return null;

    }

    private boolean matches(Avd avd, ISystemImage image) {

        def abi = AvdAbi.asAvdAbi(image.abiType)
        def tag = AvdTag.asAvdTag(image.tag.id)
        def apiLevel = image.androidVersion.apiLevel

        if (avd.abi != abi) {
            return false;
        }

        if (avd.tag != tag) {
            return false;
        }

        if (avd.apiLevel != apiLevel) {
            return false;
        }

        return true;
    }


    private File getSkinFile(ISystemImage image, AvdSkin skin) {
        for(File skinFile : image.getSkins()) {
            def imageSkin = AvdSkin.asAvdSkin(skinFile)
            if(skin == imageSkin) {
                return skinFile
            }
        }
    }
}
