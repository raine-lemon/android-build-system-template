package io.lemon.android.buildSystem.plugin

import com.android.build.gradle.LibraryExtension
import io.lemon.android.buildSystem.Config.COMPILE_SDK
import io.lemon.android.buildSystem.Config.MIN_SDK
import io.lemon.android.buildSystem.extensions.extensionAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("kotlin-parcelize")
            }

            extensions.configure<LibraryExtension> {
                extensionAndroid(this)
                defaultConfig {
                    compileSdk = COMPILE_SDK
                    minSdk = MIN_SDK
                }

            }
        }
    }
}