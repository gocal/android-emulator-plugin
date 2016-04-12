Android Emulator Plugin
=======================

## Adding to your project

To start using this library, add following lines to the `build.gradle` of your project:

```groovy
apply plugin: 'com.android.application'
apply plugin: 'android-emulator'

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.gocal.emulator:android-emulator:0.1.0'
    }
}
