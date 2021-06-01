package ICom

import BuilderImpl.JsonProviderImpl
import IVisitor.JsonArrayBuilder
import IVisitor.JsonBuilderFactory
import IVisitor.JsonObjectBuilder
import java.util.*
import kotlin.reflect.full.createInstance

abstract class JsonProvider {

    companion object{
        fun provider() : JsonProvider{
            val clazz = JsonProviderImpl::class
            return clazz.createInstance()
        }
    }

    abstract fun createObjectBuilder() : JsonObjectBuilder

    abstract fun JsonArrayBuilder() : JsonArrayBuilder


}