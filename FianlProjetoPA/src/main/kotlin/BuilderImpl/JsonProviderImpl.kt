package BuilderImpl

import ICom.JsonProvider
import IVisitor.Json
import IVisitor.JsonArrayBuilder
import IVisitor.JsonBuilderFactory
import IVisitor.JsonObjectBuilder
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation

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