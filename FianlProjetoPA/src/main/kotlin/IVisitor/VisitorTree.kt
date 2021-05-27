package IVisitor

interface VisitorTree {
    fun visit(var1 : JsonObject) : Boolean = true

    fun endVisit(c: JsonObject)

    fun visit(key : String, value : JsonString)
    fun visit(key : String, value : JsonNumber)
    fun visit(key : String, value : JsonValue)

    fun visit(key : String, value : JsonObject)
}