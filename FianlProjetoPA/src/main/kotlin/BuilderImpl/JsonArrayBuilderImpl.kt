package BuilderImpl

import IVisitor.*

class JsonArrayBuilderImpl : JsonArrayBuilder {

    val listValue = mutableListOf<JsonValue>()

    override fun add(jsonValue: JsonValue): JsonArrayBuilder {
        this.listValue.add(jsonValue)
        return this
    }

    override fun add(str: String): JsonArrayBuilder {
        this.listValue.add(JsonStringImpl(str))
        return this
    }

    override fun add(numb: Int): JsonArrayBuilder {
        this.listValue.add(JsonNumberImpl(numb))
        return this
    }

    override fun add(value: Boolean): JsonArrayBuilder {
        if (value)
            this.listValue.add(JsonValue.TRUE)
        else
            this.listValue.add(JsonValue.FALSE)
        return this
    }

    override fun add(jsonObjectBuilder: JsonObjectBuilder): JsonArrayBuilder {
        this.listValue.add(jsonObjectBuilder.build())
        return this
    }

    override fun add(jsonArrayBuilder: JsonArrayBuilder): JsonArrayBuilder {
        this.listValue.add(jsonArrayBuilder.build())
        return this
    }

    override fun addNull(): JsonArrayBuilder {
        this.listValue.add(JsonValue.NULL)
        return this
    }

    override fun build(): JsonArray {
            val sp = ArrayList(this.listValue)
            return JsonArrayImpl(sp)

    }

    private class JsonArrayImpl : AbstractList<JsonValue>, JsonArray{

        private val valueList : List<JsonValue>

        constructor(valueList : List<JsonValue>){
            this.valueList = valueList
        }

        override fun getJsonObject(obj: Int): JsonObject {
            return this.valueList.get(obj) as JsonObject
        }

        override fun getJsonArray(arr: Int): JsonArray {
            return this.valueList.get(arr) as JsonArray
        }

        override fun getJsonNumber(numb: Int): JsonNumber {
            return this.valueList.get(numb) as JsonNumber
        }

        override fun getJsonString(numb: Int): JsonString {
            return this.valueList.get(numb) as JsonString
        }

        override fun getValueType(): JsonValue.ValueType {
            return JsonValue.ValueType.ARRAY
        }

        override fun get(index: Int): JsonValue {
            return this.valueList.get(index) as JsonValue
        }

        override val size: Int
            get() = this.valueList.size
    }
}