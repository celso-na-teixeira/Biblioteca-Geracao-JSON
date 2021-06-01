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
        return  JsonObjectImpl()
    }

    override fun JsonArrayBuilder(): JsonArrayBuilder {
        return JsonArrayBuilderImpl()
    }

}