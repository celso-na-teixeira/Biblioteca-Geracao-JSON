package IVisitor

import JsonArray2

interface JsonObject : JsonStructure, Map<String, JsonValue> {

    fun getJsonArray(str : String) : JsonArray

    fun getJsonObject(str :String) : JsonObject

    fun getJsonNumber(str :String) : JsonNumber

    fun getJsonString(str :String) : JsonString


}