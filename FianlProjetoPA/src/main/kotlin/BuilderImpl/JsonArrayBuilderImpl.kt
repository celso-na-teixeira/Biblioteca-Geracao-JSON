package BuilderImpl

import IVisitor.JsonArray
import IVisitor.JsonArrayBuilder
import IVisitor.JsonObjectBuilder
import IVisitor.JsonValue

class JsonArrayBuilderImpl : JsonArrayBuilder {

    val listValue = mutableListOf<JsonValue>()

    override fun add(jsonValue: JsonValue): JsonArrayBuilder {
        this.listValue.add(jsonValue)
        return this
    }

    override fun add(str: String): JsonArrayBuilder {
        //this.listValue.add()
        return this
    }

    override fun add(numb: Int): JsonArrayBuilder {
        TODO("Not yet implemented")
    }

    override fun add(jsonObjectBuilder: JsonObjectBuilder): JsonArrayBuilder {
        TODO("Not yet implemented")
    }

    override fun add(jsonArrayBuilder: JsonArrayBuilder): JsonArrayBuilder {
        TODO("Not yet implemented")
    }

    override fun addNull(): JsonArrayBuilder {
        TODO("Not yet implemented")
    }

    override fun build(): JsonArray {
        TODO("Not yet implemented")
    }
}