package io.lemon.android.buildSystem.plugin

import com.android.build.gradle.LibraryExtension
import io.lemon.android.buildSystem.extensions.configureFlavor
import io.lemon.android.buildSystem.util.Extensions.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class NetworkPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                configureFlavor(this)
            }
            dependencies {
                add("implementation", versionCatalog.findLibrary("okhttp-logging").get())
                add("implementation", versionCatalog.findLibrary("retrofit").get())
                add(
                    "implementation",
                    versionCatalog.findLibrary("retrofit-converter-gson").get()
                )
                add(
                    "implementation",
                    versionCatalog.findLibrary("retrofit-converter-kotlin-serialization").get()
                )
            }
        }
    }
}