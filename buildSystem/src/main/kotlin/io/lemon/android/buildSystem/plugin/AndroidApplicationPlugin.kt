package io.lemon.android.buildSystem.plugin

import com.android.build.api.dsl.ApplicationExtension
import io.lemon.android.buildSystem.Config.COMPILE_SDK
import io.lemon.android.buildSystem.Config.MIN_SDK
import io.lemon.android.buildSystem.Config.TARGET_SDK
import io.lemon.android.buildSystem.Config.VERSION_CODE
import io.lemon.android.buildSystem.Config.VERSION_NAME
import io.lemon.android.buildSystem.Config.APPLICATION_ID
import io.lemon.android.buildSystem.Config.JVM_TARGET
import io.lemon.android.buildSystem.extensions.extensionAndroid
import io.lemon.android.buildSystem.util.Extensions.applicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import java.util.Properties

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-parcelize")
            }

            val localProperties = Properties().apply {
                load(rootProject.file("local.properties").inputStream())
            }

            applicationExtension.apply {

                extensions.getByType<KotlinAndroidProjectExtension>().apply {
                    compilerOptions {
                        jvmTarget.set(JVM_TARGET)
                    }
                }
            }

            extensions.configure<ApplicationExtension> {
                namespace = APPLICATION_ID

                extensionAndroid(this)
                defaultConfig {
                    applicationId = APPLICATION_ID

                    minSdk = MIN_SDK
                    targetSdk = TARGET_SDK
                    compileSdk = COMPILE_SDK
                    versionCode = VERSION_CODE
                    versionName = VERSION_NAME
                    vectorDrawables.useSupportLibrary = true
                }


                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }



                buildFeatures {
                    buildConfig = true
                }

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }
        }
    }
}