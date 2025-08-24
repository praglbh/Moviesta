plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.moviesta"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.moviesta"
        minSdk = 26
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        // IMPORTANT: Match this to the Kotlin compiler version compatible with your Compose BOM
        kotlinCompilerExtensionVersion = "1.4.7" // Or the version recommended by your Compose BOM
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)

    // Compose BOM manages versions, so no explicit versions below!
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))

    // Compose dependencies without version numbers
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation(libs.google.firebase.database)
    implementation(libs.androidx.activity)


    // Debug only dependencies
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // UI testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0")

    // Firebase
    implementation(libs.firebase.database)

    // Image loading
    implementation("com.github.bumptech.glide:glide:4.13.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.coil-kt:coil:2.2.2")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("com.google.android.material:material:1.12.0")

     // or latest
    implementation (libs.coil.compose)


}
