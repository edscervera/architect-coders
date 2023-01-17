plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id(Libs.Ktlin.kotlin)
}

android {
    namespace = "com.ecervera.cocktails"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ecervera.cocktails"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // ACCOMPANIST
    implementation(Libs.Accompanist.systemuicontroller)

    // ANDROIDX
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.annotation)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.runtime)

    // ARROW
    implementation(Libs.Arrow.core)

    // COIL
    implementation(Libs.Coil.compose)
    implementation(Libs.Coil.coilSvg)

    // COMPOSE
    implementation(Libs.AndroidX.Compose.activity)
    implementation(Libs.AndroidX.Compose.animation)
    implementation(Libs.AndroidX.Compose.constraintlayout)
    implementation(Libs.AndroidX.Compose.graphics)
    implementation(Libs.AndroidX.Compose.liveData)
    implementation(Libs.AndroidX.Compose.navigation)
    implementation(Libs.AndroidX.Compose.preview)
    implementation(Libs.AndroidX.Compose.ui)

    // COROUTINES
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.Kotlin.Coroutines.android)

    // DAGGER HILT
    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.compose)
    kapt(Libs.Hilt.compiler)
    kapt(Libs.Hilt.androidxCompiler)

    // LIFECYCLE
    implementation(Libs.AndroidX.Lifecycle.runtimeKtx)
    implementation(Libs.AndroidX.Lifecycle.viewmodelKtx)

    // MATERIAL 3
    implementation(Libs.AndroidX.Compose.Material.material)
    implementation(Libs.AndroidX.Compose.Material.material3)
    implementation(Libs.AndroidX.Compose.Material.icons)

    // MOSHI
    implementation(Libs.Moshi.setup)
    implementation(Libs.Moshi.adapter)
    implementation(Libs.Moshi.kotlin)
    kapt(Libs.Moshi.codegen)

    // OKHTTP 3
    implementation(Libs.OkHttp3.loginInterceptor)
    implementation(Libs.OkHttp3.urlConnection)

    // PROJECTS
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":usecases"))

    // RETROFIT
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterMoshi)

    // ROOM
    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.roomKtx)
    kapt(Libs.AndroidX.Room.compiler)

    // TESTS
    testImplementation(project(":testShared"))
    testImplementation(project(":appTestShared"))
    testImplementation(Libs.JUnit.junit)
    testImplementation(Libs.Mockito.kotlin)
    testImplementation(Libs.Mockito.inline)
    testImplementation(Libs.Kotlin.Coroutines.test)
    testImplementation(Libs.turbine)

    androidTestImplementation(project(":appTestShared"))
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.contrib)
    androidTestImplementation(Libs.AndroidX.Test.runner)
    androidTestImplementation(Libs.AndroidX.Test.rules)
    androidTestImplementation(Libs.Hilt.test)
    androidTestImplementation(Libs.Kotlin.Coroutines.test)
    androidTestImplementation(Libs.OkHttp3.mockWebServer)
    kaptAndroidTest(Libs.Hilt.compiler)

    // TIMBER
    implementation(Libs.timber)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}