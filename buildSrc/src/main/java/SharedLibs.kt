object SharedLibs {
    //Common Libraries

    //Coroutines Core
    const val COROUINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${SharedVersions.COROUTINES_VERSION}"

    //Ktor features
    const val KTOR = "io.ktor:ktor-client-core:${SharedVersions.KTOR_VERSION}"
    const val KTOR_SERIALIZER = "io.ktor:ktor-client-serialization:${SharedVersions.KTOR_VERSION}"

    //Logger
    const val LOGGER = "ch.qos.logback:logback-classic:1.2.3"
    const val KTOR_LOGGING = "io.ktor:ktor-client-logging:${SharedVersions.KTOR_VERSION}"

    // KotlinX Serialization
    const val KOTLINX_SERIALIZATION= "org.jetbrains.kotlinx:kotlinx-serialization-core:" +
                        SharedVersions.SERIALIZATION_VERSION

    //Android Specific Libraries

    //Ktor and it's features
    const val KTOR_ANDROID = "io.ktor:ktor-client-android:${SharedVersions.KTOR_VERSION}"
    const val KTOR_LOGGING_ANDROID = "io.ktor:ktor-client-logging-jvm:${SharedVersions.KTOR_VERSION}"
    const val KTOR_JSON_ANDROID =  "io.ktor:ktor-client-json:${SharedVersions.KTOR_VERSION}"
    const val KTOR_SERIALIZER_ANDROID = "io.ktor:ktor-client-serialization-jvm:${SharedVersions.KTOR_VERSION}"

    //Kotlinx Serializer
    const val KOTLINX_SERIALIZER_ANDROID = "org.jetbrains.kotlinx:kotlinx-serialization-json:" +
            SharedVersions.KOTLINX_SERIALIZATION_VERSION

    //iOS Specific Libraries

    //Ktor for iOS
    const val KTOR_IOS = "io.ktor:ktor-client-ios:${SharedVersions.KTOR_VERSION}"
}