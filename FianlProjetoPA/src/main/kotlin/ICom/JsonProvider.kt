package ICom

import BuilderImpl.JsonProviderImpl
import IVisitor.JsonArrayBuilder
import IVisitor.JsonBuilderFactory
import IVisitor.JsonObjectBuilder
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass

abstract class JsonProvider {

    companion object{
        fun provider() : JsonProvider{
            val clazz = JsonProviderImpl::class
            return clazz.createInstance()
        }
    }

    abstract fun createObjectBuilder() : JsonObjectBuilder

    abstract fun JsonArrayBuilder() : JsonArrayBuilder

    abstract fun createBuilderFactory(map : Map<String, Any?>) : JsonBuilderFactory

}