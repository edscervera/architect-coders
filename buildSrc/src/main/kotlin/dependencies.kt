object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.3.1"

    object Kotlin {
        private const val version = "1.7.0"
        const val android = "org.jetbrains.kotlin.android:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.4"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }

    }

    object Accompanist {
        const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
        const val webview = "com.google.accompanist:accompanist-webview:0.25.0"
    }

    object AndroidX {

        const val annotation = "androidx.annotation:annotation:1.5.0"
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val compose = "1.3.1"
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0"
        const val runtime = "androidx.startup:startup-runtime:1.1.1"

        object Compose {
            const val activity = "androidx.activity:activity-compose:1.6.1"
            const val animation = "androidx.compose.animation:animation:$compose"
            const val constraintlayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
            const val graphics = "androidx.compose.animation:animation-graphics:$compose"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$compose"
            const val navigation = "androidx.navigation:navigation-compose:2.5.3"
            const val preview = "androidx.compose.ui:ui-tooling-preview:$compose"
            const val ui = "androidx.compose.ui:ui:$compose"

            //MATERIAL3
            object Material {
                private const val version = "1.0.1"
                const val material = "androidx.compose.material:material:$compose"
                const val material3 = "androidx.compose.material3:material3:$version"
                const val icons = "androidx.compose.material:material-icons-extended:$compose"
            }
        }

        object Lifecycle {
            private const val version = "2.5.1"
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Room {
            private const val version = "2.4.3"
            const val runtime = "androidx.room:room-runtime:$version"
            const val roomKtx = "androidx.room:room-ktx:$version"
            const val compiler = "androidx.room:room-compiler:$version"
        }

        object Test {
            private const val version = "1.4.0"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"


            object Compose {
                const val junit = "androidx.compose.ui:ui-test-junit4:$compose"
                const val manifest = "androidx.compose.ui:ui-test-manifest:$compose"
                const val tooling = "androidx.compose.ui:ui-tooling:$compose"
            }

            object Espresso{
                private const val version="3.4.0"
                const val contrib = "androidx.test.espresso:espresso-contrib:$version"
            }

            object Ext {
                private const val version = "1.1.4"
                const val junit = "androidx.test.ext:junit:$version"
            }
        }

    }

    object Arrow {
        private const val version = "1.0.1"
        const val core = "io.arrow-kt:arrow-core:$version"
    }

    object Coil {
        const val compose = "io.coil-kt:coil-compose:2.2.2"
        const val coilSvg = "io.coil-kt:coil-svg:2.2.2"
    }

    object Detekt {
        const val version = "1.22.0"
        const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
        const val plugin = "io.gitlab.arturbosch.detekt"
    }

    object GradleVersionPlugin {
        const val version = "0.44.0"
        const val pluginId = "com.github.ben-manes.versions"
    }

    object Hilt {
        private const val version = "2.42"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val androidxCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val test = "com.google.dagger:hilt-android-testing:$version"
    }

    object JavaX {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Ktlin {
        const val version = "11.0.0"
        const val gradlePlugin = "org.jlleitschuh.gradle:ktlint-gradle:$version"
        const val kotlin = "org.jlleitschuh.gradle.ktlint"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object Mockito {
        const val kotlin = "org.mockito.kotlin:mockito-kotlin:4.1.0"
        const val inline = "org.mockito:mockito-inline:4.4.0"
    }

    object Moshi {
        private const val version = "1.14.0"
        const val setup = "com.squareup.moshi:moshi:$version"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val adapter = "com.squareup.moshi:moshi-adapters:$version"
    }

    object OkHttp3 {
        private const val version = "4.10.0"
        const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
        const val urlConnection = "com.squareup.okhttp3:okhttp-urlconnection:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
    }


    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val turbine = "app.cash.turbine:turbine:0.7.0"
}