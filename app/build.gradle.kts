plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.jetbrains.kotlin.safeargs)
}

android {
    namespace = "com.link.edulinker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.link.edulinker"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    flavorDimensions += "env"
    productFlavors {
        create("dev") {
            buildConfigField("String", "BASE_URL", "\"https://api.inopenapp.com/\"")
            dimension = "env"
        }
        create("prod") {
            buildConfigField("String", "BASE_URL", "\"https://api.inopenapp.com/\"")
            dimension = "env"
        }
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //livedata
    implementation(libs.androidx.lifecycle.livedata.ktx)
    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    //coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    //retrofit
    implementation(libs.sqaureup.retrofit)
    implementation(libs.sqaureup.retrofit.gson.converter)
    implementation(libs.sqaureup.okhttp)
    implementation(libs.sqaureup.okhttp.logging.interceptor)
    //glide
    implementation(libs.bumptech.glide)
    kapt(libs.bumptech.glide.compiler)
    //shimmer
    implementation(libs.facebook.shimmer)
    //mpAndroidChart
    implementation(libs.mpAndroidChart)
}