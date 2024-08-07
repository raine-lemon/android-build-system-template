package io.lemon.android.buildSystem.plugin

import io.lemon.android.buildSystem.util.Extensions.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class NetworkPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", versionCatalog.findLibrary("okhttp-logging").get())
                add("implementation", versionCatalog.findLibrary("retrofit").get())
                add("implementation", versionCatalog.findLibrary("retrofit-converter-kotlin-serialization").get())
            }
        }
    }
}