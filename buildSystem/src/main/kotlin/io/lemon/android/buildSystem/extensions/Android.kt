package io.lemon.android.buildSystem.extensions

import com.android.build.api.dsl.CommonExtension
import io.lemon.android.buildSystem.Config.JAVA_VERSION


internal fun extensionAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {

        defaultConfig {
            buildFeatures { buildConfig = true }
        }


        compileOptions {
            sourceCompatibility = JAVA_VERSION
            targetCompatibility = JAVA_VERSION
        }

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

    }
}