import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// Read the Google Maps API key from local.properties (never commit it to GitHub)
val localProps = Properties().apply {
    val f = rootProject.file("local.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}

android {
    namespace = "com.shubham.mapsdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.shubham.mapsdemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        manifestPlaceholders["MAPS_API_KEY"] =
            localProps.getProperty("MAPS_API_KEY", "YOUR_API_KEY_HERE")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    // Google Maps
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.maps.android:maps-compose:4.4.1")
}
