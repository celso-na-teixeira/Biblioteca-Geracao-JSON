package ImplVisitor

import IVisitor.Visitor
import JsonParse
import JsonAnnotation
import JsonConstants
import school.Lesson
import school.Student
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation

class ImplVisitor() : Visitor {
    val myjson = JsonParse()

    //return strings
    override fun getStrings(st: Student): String {
        val clazz: KClass<Any> = st::class as KClass<Any>
        var propertyKeyAndValue = ""
        val json = mutableListOf<String>()

        clazz.declaredMemberProperties.forEach {
            if (it.call(st) is String) {
                propertyKeyAndValue = myjson.getPropertyKey(it) + myjson.getPropertyValues(it, st)
                json.add(propertyKeyAndValue);
            } else if (it.hasAnnotation<JsonAnnotation.AttributeObject>()) {
                propertyKeyAndValue = myjson.getPropertyKey(it) + getStrings(it.call(st) as Lesson)
            } else if (it.hasAnnotation<JsonAnnotation.AttributeArray>()) {
                propertyKeyAndValue = myjson.getPropertyKey(it) + JsonConstants.parentesesRetoAbre
                (it.call(st)!! as MutableList<Any>).forEach { les ->
                    propertyKeyAndValue += getStrings(les as Lesson) + JsonConstants.virgula
                }
                propertyKeyAndValue = propertyKeyAndValue.dropLast(1)
                propertyKeyAndValue += JsonConstants.parentesesRetoFecha
                json.add(propertyKeyAndValue);
            }

        }
        return JsonConstants.chavetaAbre + json.joinToString() { it.toString() } + JsonConstants.chavetaFecha
    }


    override fun getStrings(les: Lesson): String {
        val clazz: KClass<Any> = les::class as KClass<Any>
        var propertyKeyAndValue = ""
        val json = mutableListOf<String>()

        clazz.declaredMemberProperties.forEach {
            if (it.call(les) is String) {
                propertyKeyAndValue = myjson.getPropertyKey(it) + myjson.getPropertyValues(it, les)
                json.add(propertyKeyAndValue);
            } else if (it.hasAnnotation<JsonAnnotation.AttributeObject>())
                propertyKeyAndValue = myjson.getPropertyKey(it) + getStrings(it.call(les) as Lesson)
            else if (it.hasAnnotation<JsonAnnotation.AttributeArray>()) {
                propertyKeyAndValue = myjson.getPropertyKey(it) + JsonConstants.parentesesRetoAbre
                (it.call(les)!! as MutableList<Any>).forEach { les ->
                    propertyKeyAndValue += getStrings(les as Lesson) + JsonConstants.virgula
                }
                propertyKeyAndValue = propertyKeyAndValue.dropLast(1)
                propertyKeyAndValue += JsonConstants.parentesesRetoFecha
                json.add(propertyKeyAndValue);
            }
        }
        return JsonConstants.chavetaAbre + json.joinToString() { it.toString() } + JsonConstants.chavetaFecha
    }

    override fun getObjetsByProperties(les: Lesson, propertie: String): String {
        val clazz: KClass<Any> = les::class as KClass<Any>
        var propertyKeyAndValue = ""
        val json = mutableListOf<String>()
        val propValues = clazz.declaredMemberProperties.map { it.name }
        if (propertie != null && propValues.contains(propertie))
            propertyKeyAndValue = myjson.parse(les)

        return propertyKeyAndValue
    }

    /* override fun createModelJson(any: Any): JsonObject {
         return JsonObject()
     }*/

    override fun getObjetsByProperties(st: Student, propertie: String): String {
        val clazz: KClass<Any> = st::class as KClass<Any>
        var propertyKeyAndValue = ""
        val json = mutableListOf<String>()
        val propValues = clazz.declaredMemberProperties.map { it.name }
        if (propertie != null && propValues.contains(propertie))
            propertyKeyAndValue = JsonParse().parse(st)

        return propertyKeyAndValue
    }

}