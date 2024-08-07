import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.lemon.android.application)
    alias(libs.plugins.lemon.android.application.compose)
    alias(libs.plugins.lemon.android.kotlin)
    alias(libs.plugins.lemon.android.feature)
    alias(libs.plugins.kotlin.android)
}
android {
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}
