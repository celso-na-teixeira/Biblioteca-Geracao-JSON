package IVisitor

interface JsonObjectBuilder {
    fun add(str : String, jsonValue: JsonValue) : JsonObjectBuilder

    fun add(str : String, str2 : String) : JsonObjectBuilder

    fun add(str : String, number : Int) : JsonObjectBuilder

    fun addNull(str : String) : JsonObjectBuilder

    fun build() : JsonObject

    fun add(str : String, jsonObjectBuilder: JsonObjectBuilder) : JsonObjectBuilder

    fun add(str : String, jsonArrayBuilder: JsonArrayBuilder) : JsonObjectBuilder
}