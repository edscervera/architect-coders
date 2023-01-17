plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ecervera.cocktails.apptestshared"
    compileSdk = 32

    defaultConfig {
        minSdk = 28
        targetSdk = 32
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // COROUTINES
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.Kotlin.Coroutines.android)

    // RETROFIT
    implementation(Libs.Retrofit.retrofit)

    // PROJECT
    implementation(project(":app"))
    implementation(project(":data"))

    implementation(Libs.OkHttp3.mockWebServer)
}