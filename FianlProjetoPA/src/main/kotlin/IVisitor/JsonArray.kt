package IVisitor

interface JsonArray : JsonStructure, List<JsonValue> {

    fun getJsonObject(obj : Int) : JsonObject

    fun getJsonArray(arr : Int) : JsonArray

    fun getJsonNumber(numb : Int) : JsonNumber

    fun getJsonString(numb : Int) : JsonString

}