package BuilderImpl

import IVisitor.*

class JsonObjectBuilderImpl : JsonObjectBuilder {
    private val valueMap = mutableMapOf<String, JsonValue>()

    constructor()
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

    override fun add(str: String, number: Double): JsonObjectBuilder {
        this.valueMap.put(str, JsonNumberImpl(number))
        return this
    }

    override fun add(str: String, var1: Boolean): JsonObjectBuilder {
        this.valueMap.put(str, if (var1) JsonValue.TRUE else JsonValue.FALSE)
        return this
    }

    override fun add(str: String, enum: Enum<*>): JsonObjectBuilder {
        this.valueMap.put(str, JsonStringImpl(enum.toString()))
        return this
    }


    fun convert(map: MutableMap<*, *>) : Map<String, JsonValue>{
        val newMap = JsonObjectBuilderImpl()

        return newMap.valueMap
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

         class JsonObjectImpl : JsonObject {

             val valueMap : Map<String, JsonValue>


             constructor(map :  Map<String, JsonValue>){
                 this.valueMap = map
             }

             override fun getMap() : Map<String, JsonValue>{
                 return valueMap
             }


             override fun getJsonArray(var1: String): JsonArray {
                 return valueMap.get(var1) as JsonArray
             }


             override fun getJsonObject(var1: String): JsonObject {
                 return valueMap.get(var1) as JsonObject
             }

             override fun getJsonObject(): JsonObject {
                 return valueMap as JsonObject
             }

             override fun getJsonNumber(var1: String): JsonNumber {
                 return valueMap.get(var1) as JsonNumber
             }

             override fun getJsonString(var1: String): JsonString {
                 return valueMap.get(var1) as JsonString
             }

             override fun getValueType(): JsonValue.ValueType {
                 return JsonValue.ValueType.OBJECT
             }

             override fun accept(v: Visitor) {
                 //if(v.visit(this))
                     valueMap.forEach{
                         it.value.accept(v)
                     }
                 v.endVisit(this)
             }

         }
}