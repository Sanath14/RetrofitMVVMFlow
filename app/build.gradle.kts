plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //alias(libs.plugins.kotlinAndroidKsp)
    //alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "com.appynitty.retrofitexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.appynitty.retrofitexample"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //dagger-hilt
    //implementation(libs.hilt.android)
    //ksp(libs.hilt.compiler)

    //retrofit
    implementation(libs.retrofit.android)
    implementation(libs.gson.android)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)

    //viewmodel
    implementation(libs.viewmodel.android)
    //picasso
    implementation(libs.picasso.android)

}