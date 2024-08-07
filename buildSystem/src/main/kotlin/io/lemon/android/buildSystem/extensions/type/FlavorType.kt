package io.lemon.android.buildSystem.extensions.type

import io.lemon.android.buildSystem.Config
import io.lemon.android.buildSystem.Config.VERSION_CODE
import io.lemon.android.buildSystem.Config.VERSION_NAME

data class FlavorType(
    val name: String,
    val dimension: Config.Flavor.FlavorDimension,
    val suffix: String? = null,
    val versionCode: Int = VERSION_CODE,
    val versionName: String = VERSION_NAME,
    val buildConfigField: List<BuildConfigField> = emptyList(),
    val resourceValue: List<ResourceType> = emptyList(),
    val manifestPlaceholder: Map<String, Any> = emptyMap()
)
