import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}

dependencies {
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.android.gradle)
    compileOnly(libs.compose.gradle)
    compileOnly(libs.ksp.gradle)
}

gradlePlugin {
    plugins {
        register("lemon.android.application") {
            id = "lemon.android.application"
            implementationClass = "io.lemon.android.buildSystem.plugin.AndroidApplicationPlugin"
        }
        register("lemon.android.library") {
            id = "lemon.android.library"
            implementationClass = "io.lemon.android.buildSystem.plugin.AndroidLibraryPlugin"
        }
        register("lemon.android.feature") {
            id = "lemon.android.feature"
            implementationClass = "io.lemon.android.buildSystem.plugin.AndroidFeaturePlugin"
        }
        register("lemon.android.application.compose") {
            id = "lemon.android.application.compose"
            implementationClass = "io.lemon.android.buildSystem.plugin.AndroidApplicationComposePlugin"
        }
        register("lemon.android.compose.ext") {
            id = "lemon.android.compose.ext"
            implementationClass = "io.lemon.android.buildSystem.plugin.AndroidComposeExtPlugin"
        }
        register("lemon.android.library.compose") {
            id = "lemon.android.library.compose"
            implementationClass = "io.lemon.android.buildSystem.plugin.AndroidLibraryComposePlugin"
        }
        register("lemon.android.datastore") {
            id = "lemon.android.datastore"
            implementationClass = "io.lemon.android.buildSystem.plugin.DataStorePlugin"
        }
        register("lemon.android.network") {
            id = "lemon.android.network"
            implementationClass = "io.lemon.android.buildSystem.plugin.NetworkPlugin"
        }
        register("lemon.android.room") {
            id = "lemon.android.room"
            implementationClass = "io.lemon.android.buildSystem.plugin.RoomPlugin"
        }
        register("lemon.android.hilt") {
            id = "lemon.android.hilt"
            implementationClass = "io.lemon.android.buildSystem.plugin.HiltPlugin"
        }
        register("lemon.android.image") {
            id = "lemon.android.image"
            implementationClass = "io.lemon.android.buildSystem.plugin.ImagePlugin"
        }
        register("lemon.android.kotlin") {
            id = "lemon.android.kotlin"
            implementationClass = "io.lemon.android.buildSystem.plugin.KotlinPlugin"
        }
    }
}