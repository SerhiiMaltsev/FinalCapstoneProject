plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    kotlin("plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.example.littlelemon"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.littlelemon"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

//    //Room dependencies
//    implementation("androidx.room:room-runtime:2.6.1")
//    implementation(libs.androidx.navigation.compose.jvmstubs)
//    implementation(libs.androidx.runtime.livedata)
//    kapt("androidx.room:room-compiler:2.7.2")
//    implementation("androidx.room:room-ktx:2.6.1") // optional, for coroutines
//
//    implementation("io.ktor:ktor-client-core:2.3.10")
//    implementation("io.ktor:ktor-client-cio:2.3.10")
//    implementation("io.ktor:ktor-client-content-negotiation:2.3.10")
//    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.10")
//    implementation("io.ktor:ktor-client-logging:2.3.10")
//    implementation("io.ktor:ktor-client-android:2.3.10")
//
//    implementation("androidx.compose.material:material-icons-extended:1.6.1")
//
//    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
//
//    //LiveData
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    implementation("androidx.navigation:navigation-compose:2.5.3")

    implementation("io.ktor:ktor-client-android:2.1.3")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.3")

    implementation("androidx.room:room-runtime:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")

    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")

    implementation("androidx.compose.runtime:runtime-livedata:1.3.2")

    implementation("androidx.compose.material:material-icons-extended")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}