/**
 * Contains all libraries.
 */
object Libs {

    //Shared
    const val shared = ":shared"

    // Kotlin
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Version.KOTLIN_VERSION}"

    // UI
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Version.APPCOMPAT}"

    // ViewModel
    const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel:${Version.ARCH_VERSION}"
    const val VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.ARCH_VERSION}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Version.APPCOMPAT}"

    // Coroutines
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINES}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINES}"

    // Glide
    const val GLIDE = "com.github.bumptech.glide:glide:${Version.GLIDE}"

    //SDP
    const val SDP = "com.intuit.sdp:sdp-android:${Version.SDP}"

    //SSP
    const val SSP = "com.intuit.ssp:ssp-android:${Version.SSP}"

    //MATERIAL
    const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
}