buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}")
        classpath("com.android.tools.build:gradle:${Version.ANDROID_GRADLE}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Version.KOTLIN_VERSION}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        jitpack()
    }
}