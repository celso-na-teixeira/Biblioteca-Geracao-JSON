package BuilderImpl

import IVisitor.JsonArrayBuilder
import IVisitor.JsonBuilderFactory
import IVisitor.JsonObjectBuilder

class JsonBuilderFactoryImpl : JsonBuilderFactory {

    private val config : Map<String, *> = mutableMapOf<String, Any?>()

    override fun createObjectBuilder(): JsonObjectBuilder {
        return JsonObjectBuilderImpl()
    }

    override fun createArrayBuilder(): JsonArrayBuilder {
        return JsonArrayBuilderImpl()
    }

    override fun getConfigInUse(): Map<String, *> {
        return this.config
    }
}