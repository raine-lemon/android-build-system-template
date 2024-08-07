package io.lemon.android.buildSystem.plugin

import io.lemon.android.buildSystem.util.Extensions.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


class MediaPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                    add("implementation", versionCatalog.findLibrary("media3-exoplayer").get())
                    add("implementation", versionCatalog.findLibrary("media3-ui").get())
            }
        }
    }
}
