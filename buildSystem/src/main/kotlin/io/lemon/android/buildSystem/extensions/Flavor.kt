package io.lemon.android.buildSystem.extensions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import io.lemon.android.buildSystem.Config
import io.lemon.android.buildSystem.extensions.type.FlavorType


fun configureFlavor(
    commonExtension: CommonExtension<*, *, *, *, *>,
    flavorList :List<FlavorType>,
    flavorDimension : Config.Flavor.FlavorDimension
) {
    commonExtension.apply {
        flavorDimensions += flavorDimension.name
        productFlavors {
            flavorList.forEach {
                create(it.name) {
                    dimension = it.dimension.name

                    it.buildConfigField.forEach { field ->
                        buildConfigField(
                            type = field.type.field,
                            name = field.name,
                            value = "${field.value}"
                        )
                    }

                    it.resourceValue.forEach { res ->
                        resValue(
                            type = res.type.toString(),
                            name = res.name,
                            value = "${res.value}"
                        )
                    }
                    addManifestPlaceholders(it.manifestPlaceholder)

                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.suffix != null) applicationIdSuffix = it.suffix
                        versionCode = it.versionCode
                        versionName = it.versionName
                    }
                }
            }
        }
    }
}