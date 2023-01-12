import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Hilt.gradlePlugin)
        classpath(Libs.Ktlin.gradlePlugin)
    }
}

plugins {

    id(Libs.GradleVersionPlugin.pluginId).version(Libs.GradleVersionPlugin.version)
    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
    id("com.android.library") version "7.3.1" apply false
    // id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    // optional parameters
    checkForGradleUpdate = true
    outputFormatter = "json"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
}

// https://github.com/ben-manes/gradle-versions-plugin
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}


tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}