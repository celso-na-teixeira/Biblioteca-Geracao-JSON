package IVisitor

interface JsonObject : JsonStructure{

    fun getJsonArray(str : String) : JsonArray

    fun getJsonObject(str :String) : JsonObject

    fun getJsonObject() : JsonObject

    fun getJsonNumber(str :String) : JsonNumber

    fun getJsonString(str :String) : JsonString

    fun getMap() : Map<String, JsonValue>

    fun acceptJson(visitor :VisitorTree)


}