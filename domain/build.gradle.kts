plugins {
    kotlin("kapt")
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    // ARROW
    implementation(Libs.Arrow.core)

    // COROUTINES
    implementation(Libs.Kotlin.Coroutines.core)

    // JAVAX
    implementation(Libs.JavaX.inject)

    // MOSHI
    implementation(Libs.Moshi.setup)
    kapt(Libs.Moshi.codegen)
}