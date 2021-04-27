package BuilderImpl

import ICom.JsonProvider
import IVisitor.JsonArrayBuilder
import IVisitor.JsonBuilderFactory
import IVisitor.JsonObjectBuilder

class JsonProviderImpl : JsonProvider {

    constructor()

    override fun createObjectBuilder(): JsonObjectBuilder {
        return  JsonObjectBuilderImpl()
    }

    override fun JsonArrayBuilder(): JsonArrayBuilder {
        return JsonArrayBuilderImpl()
    }

    override fun createBuilderFactory(map: Map<String, Any?>): JsonBuilderFactory {
        return JsonBuilderFactoryImpl()
    }
}