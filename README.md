Android Emulator Plugin
=======================

Usage
-----

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.gocal.emulator:android-emulator:0.1.0'
    }
}

apply plugin: 'com.android.application'
apply plugin: 'android-emulator'

android {
...
}

emulator {
    avdName 'nexus7'
}

```

Examples
--------

Start emulator

```groovy
gradle startEmulator
```

Stop emulator

```groovy
gradle stopEmulator
```

License
-------

    Copyright 2016 Marcin Marek Gocal

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.