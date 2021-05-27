package IVisitor


interface JsonArrayBuilder {
    fun add(jsonValue: JsonValue) : JsonArrayBuilder

    fun add(str: String) : JsonArrayBuilder

    fun add(numb: Int) : JsonArrayBuilder

    fun add(value: Boolean) : JsonArrayBuilder

    fun addNull() : JsonArrayBuilder

    fun build() : JsonArray

    fun add(jsonObjectBuilder: JsonObjectBuilder) : JsonArrayBuilder

    fun add(jsonArrayBuilder: JsonArrayBuilder) : JsonArrayBuilder
}