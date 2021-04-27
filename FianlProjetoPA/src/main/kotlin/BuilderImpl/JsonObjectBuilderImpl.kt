package BuilderImpl

import IVisitor.*

class JsonObjectBuilderImpl : JsonObjectBuilder {
    private val valueMap = mutableMapOf<String, JsonValue>()

    override fun add(str: String, jsonValue: JsonValue): JsonObjectBuilder {
        this.valueMap.put(str, jsonValue)
        return this
    }

    override fun add(str: String, str2: String): JsonObjectBuilder {
        this.valueMap.put(str, JsonStringImpl(str2))
        return this
    }

    override fun add(str: String, number: Int): JsonObjectBuilder {
        this.valueMap.put(str, JsonNumberImpl(number))
        return this
    }

    override fun add(str: String, jsonObjectBuilder: JsonObjectBuilder): JsonObjectBuilder {
        this.valueMap.put(str, jsonObjectBuilder.build())
        return this
    }

    override fun add(str: String, jsonArrayBuilder: JsonArrayBuilder): JsonObjectBuilder {
        this.valueMap.put(str, jsonArrayBuilder.build())
        return this
    }

    override fun addNull(str: String): JsonObjectBuilder {
        this.valueMap.put(str, JsonValue.NULL)
        return this
    }

    override fun build(): JsonObject {
        val sp : Map<String, JsonValue> = HashMap(this.valueMap)
        return JsonObjectImpl(sp)
    }

         class JsonObjectImpl : AbstractMap<String, JsonValue>, JsonObject {

             private val valueMap : Map<String, JsonValue>

             constructor(map :  Map<String, JsonValue>){
                 this.valueMap = map
             }

             override fun getJsonArray(var1: String): JsonArray {
                 return this.get(var1) as JsonArray
             }


             override fun getJsonObject(var1: String): JsonObject {
                 return this.get(var1) as JsonObject
             }

             override fun getJsonNumber(var1: String): JsonNumber {
                 return this.get(var1) as JsonNumber
             }

             override fun getJsonString(var1: String): JsonString {
                 return this.get(var1) as JsonString
             }

             override fun getValueType(): JsonValue.ValueType {
                 return JsonValue.ValueType.OBJECT
             }

             override val entries: Set<Map.Entry<String, JsonValue>>
                 get() = this.valueMap.entries

         }

}