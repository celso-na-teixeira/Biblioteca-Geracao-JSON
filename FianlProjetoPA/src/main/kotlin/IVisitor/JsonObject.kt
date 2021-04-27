package IVisitor

import JsonArray2

interface JsonObject : JsonStructure, Map<String, JsonValue> {

    fun getJsonArray(var1 : String) : JsonArray

    fun getJsonObject(var1 :String) : JsonObject

    fun getJsonNumber(var1 :String) : JsonNumber

    fun getJsonString(var1 :String) : JsonString


}