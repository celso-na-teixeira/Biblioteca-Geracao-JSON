package IVisitor

interface JsonVisitor {

    fun visit(var1 : JsonObject) : Boolean = true
    fun endVisit(c: JsonObject)

    fun visit(var1 : JsonArray) : Boolean = true
    fun endVisit(c: JsonArray)

    fun visit(var1 : JsonString)
    fun visit(var1 : JsonNumber)
    fun visit(var1 : JsonValue)

    fun visit(key :String, var1: JsonString)
    fun visit(key :String, var1: JsonValue)
    fun visit(key :String, var1: JsonNumber)

    fun visit(key :String, var1: JsonObject) : Boolean = true
    fun visit(key :String, var1: JsonArray) : Boolean = true
}