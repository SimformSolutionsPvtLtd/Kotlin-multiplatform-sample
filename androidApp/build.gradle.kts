plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.ANDROID)
    id(Plugins.KOTLIN_KAPT)
}

dependencies {
    implementation(defaultFileTree())

    // Shared module
    implementation(project(Libs.shared))

    //Material Design
    implementation(Libs.MATERIAL)

    //SDP SSP
    implementation(Libs.SDP)
    implementation(Libs.SSP)

    // UI
    implementation(Libs.APPCOMPAT)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.RECYCLERVIEW)

    // View model
    implementation(Libs.VIEW_MODEL)
    implementation(Libs.VIEW_MODEL_KTX)

    // Coroutines
    implementation(Libs.COROUTINES_CORE)
    implementation(Libs.COROUTINES_ANDROID)

    // Glide
    implementation(Libs.GLIDE)
}

android {
    compileSdkVersion(Version.COMPILE_SDK)
    defaultConfig {
        applicationId = App.ID
        minSdkVersion(Version.MIN_SDK)
        targetSdkVersion(Version.TARGET_SDK)
        versionCode = App.Version.CODE
        versionName = App.Version.NAME
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        dataBinding = true
    }
}