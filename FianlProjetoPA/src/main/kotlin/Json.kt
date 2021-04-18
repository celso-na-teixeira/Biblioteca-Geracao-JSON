import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType
import kotlin.reflect.jvm.isAccessible

class Json {

fun parse( o: Any): String {
    val clazz: KClass<Any> = o::class as KClass<Any>
    val json = mutableListOf<String>()
    var propertyKeyAndValue = ""

    clazz.declaredMemberProperties.forEach{
        if (it.hasAnnotation<JsonAnnotation.AttributeObject>())
            propertyKeyAndValue = getPropertyKey(it) + parse(it.call(o)!!)
        else if (it.hasAnnotation<JsonAnnotation.AttributeArray>()) {
            propertyKeyAndValue = getPropertyKey(it) + JsonConstants.parentesesRetoAbre
            (it.call(o)!! as MutableList<Any>).forEach { les ->
                propertyKeyAndValue += parse(les) + JsonConstants.virgula
            }
            propertyKeyAndValue = propertyKeyAndValue.dropLast(1)
            propertyKeyAndValue += JsonConstants.parentesesRetoFecha
        }
        else
        propertyKeyAndValue = getPropertyKey(it) + getPropertyValues(it, o)

        json.add(propertyKeyAndValue);
    }

    return JsonConstants.chavetaAbre +  json.joinToString(){ it.toString() } + JsonConstants.chavetaFecha
}
    fun getPropertyKey(p: KProperty1<Any, *>): String{
        var propertyKey = ""
        propertyKey = JsonConstants.aspas + p.name + JsonConstants.aspas + JsonConstants.doisPontos
        return propertyKey
    }

    fun getPropertyValues(c: KProperty1<Any, *>, s : Any): Any?{
        var myValue : Any? = Any()
            val value = c.call(s)
            if (value is Number || value is Boolean || value == null)
                myValue = value
            else
                myValue = JsonConstants.aspas + value.toString() + JsonConstants.aspas

        return myValue
    }

}