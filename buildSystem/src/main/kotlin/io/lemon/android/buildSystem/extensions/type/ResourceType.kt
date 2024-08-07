package io.lemon.android.buildSystem.extensions.type


data class ResourceType(
    val type: Type,
    val name: String,
    val value: Any
) {
    enum class Type(val field: String) {
        StringType(field = "String"),
        IntType(field = "int"),
        BooleanType(field = "boolean")
    }

}