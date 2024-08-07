package io.lemon.android.buildSystem

import io.lemon.android.buildSystem.extensions.type.FlavorType
import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object Config {

    const val COMPILE_SDK = 34
    const val MIN_SDK = 24
    const val TARGET_SDK = 34
    const val VERSION_NAME = "0.0.1"
    val VERSION_CODE: Int =
        ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH")).toInt()

    const val APPLICATION_ID = "io.lemon.android"

    val JAVA_VERSION = JavaVersion.VERSION_17
    val JVM_TARGET = JvmTarget.JVM_17


    object Flavor {

        enum class FlavorDimension { Version }

        val FLAVOR_LIST = listOf(
            FlavorType(
                name = "dev",
                dimension = FlavorDimension.Version,
                suffix = ".dev"
            ),
            FlavorType(
                name = "qa",
                dimension = FlavorDimension.Version,
                suffix = ".qa"
            ),
            FlavorType(
                name = "pro",
                dimension = FlavorDimension.Version,
            )
        )
    }
}
