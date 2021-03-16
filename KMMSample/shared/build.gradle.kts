import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(SharedPlugins.SERIALIZATION)
    kotlin(SharedPlugins.MULTIPLATFORM)
    id(SharedPlugins.SHARED_MODULE)
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation(SharedLibs.COROUINES_CORE)
                //Ktor features
                implementation(SharedLibs.KTOR)
                implementation(SharedLibs.KTOR_SERIALIZER)
                //Logger
                implementation(SharedLibs.LOGGER)
                implementation(SharedLibs.KTOR_LOGGING)
                // KotlinX Serialization
                implementation(SharedLibs.KOTLINX_SERIALIZATION)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Ktor and it's features
                implementation(SharedLibs.KTOR_ANDROID)
                implementation(SharedLibs.KTOR_LOGGING_ANDROID)
                implementation(SharedLibs.KTOR_JSON_ANDROID)
                implementation(SharedLibs.KTOR_SERIALIZER_ANDROID)
                // Kotlinx serializer
                implementation(SharedLibs.KOTLINX_SERIALIZER_ANDROID)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting {
            dependencies {
                //Ktor
                implementation(SharedLibs.KTOR_IOS)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(Version.COMPILE_SDK)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(Version.MIN_SDK)
        targetSdkVersion(Version.TARGET_SDK)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)