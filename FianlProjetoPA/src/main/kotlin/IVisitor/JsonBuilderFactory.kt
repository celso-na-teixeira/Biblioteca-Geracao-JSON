package IVisitor

interface JsonBuilderFactory {
    fun createObjectBuilder() : JsonObjectBuilder

    fun createArrayBuilder() : JsonArrayBuilder

    fun getConfigInUse() : Map<String, *>
}