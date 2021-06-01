package BuilderImpl

import IVisitor.*

 class JsonObjectImpl :  JsonObject, JsonObjectBuilder {
     val valueMap = mutableMapOf<String, JsonValue>()

     override fun getMap() : Map<String, JsonValue>{
         return valueMap
     }
     override fun acceptJson(visitor: VisitorTree) {
         if(visitor.visit(this))
             this.valueMap.forEach{
                 visitor.visit(it.key, it.value)
             }
         visitor.endVisit(this)
     }
     override fun getJsonArray(str: String): JsonArray {
         return valueMap.get(str) as JsonArray
     }
     override fun getJsonObject(str: String): JsonObject {
         return valueMap.get(str) as JsonObject
     }
     override fun getJsonObject(): JsonObject {
         return this.valueMap as JsonObject
     }
     override fun getJsonNumber(str: String): JsonNumber {
         return valueMap.get(str) as JsonNumber
     }
     override fun getJsonString(str: String): JsonString {
         return valueMap.get(str) as JsonString
     }
     override fun getValueType(): JsonValue.ValueType {
         return JsonValue.ValueType.OBJECT
     }


     override fun accept(v: Visitor) {
         if(v.visit(this))
             this.valueMap.forEach{
                 it.value.accept(v)
             }
         v.endVisit(this)
     }

     override fun accept(v: JsonVisitor) {
         if(v.visit(this))
             this.valueMap.forEach{
                 it.value.accept(it.key,v)
             }
        v.endVisit(this)
     }

     override fun accept(key: String, v: JsonVisitor) {
         if(v.visit(key,this))
             this.valueMap.forEach{
                 it.value.accept(it.key,v)
             }
         v.endVisit(this)
     }

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
         return this
     }
 }
