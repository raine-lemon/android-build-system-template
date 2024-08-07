package io.lemon.android.buildSystem.extensions.type


data class ResourceType(
    val type: Type,
    val name: String,
    val value: Any
) {
    enum class Type(val field: kotlin.String = "") {
        String(field = "String"),
        Int(field = "int"),
        Boolean(field = "boolean")
    }

}