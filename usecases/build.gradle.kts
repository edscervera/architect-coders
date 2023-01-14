plugins {
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

    // PROJECT
    implementation(project(":domain"))
    implementation(project(":data"))

    // TEST
    testImplementation(project(":testShared"))
    testImplementation(Libs.JUnit.junit)
    testImplementation(Libs.Mockito.inline)
    testImplementation(Libs.Mockito.kotlin)
}