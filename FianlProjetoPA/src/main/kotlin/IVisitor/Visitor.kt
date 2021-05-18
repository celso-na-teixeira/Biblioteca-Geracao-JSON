package IVisitor

import BuilderImpl.JsonArrayBuilderImpl
import BuilderImpl.JsonObjectBuilderImpl
import school.Lesson
import school.Student

interface Visitor {
    fun visit(var1 : JsonObject) : Boolean = true
    fun endVisit(c: JsonObject)

    fun visit(var1 : JsonArray) : Boolean = true
    fun endVisit(c: JsonArray)

    fun visit(var1 : JsonString)
    fun visit(var1 : JsonNumber)
    fun visit(var1 : JsonValue)
}