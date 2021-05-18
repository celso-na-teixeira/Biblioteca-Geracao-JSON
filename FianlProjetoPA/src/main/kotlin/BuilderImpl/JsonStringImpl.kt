package BuilderImpl

import IVisitor.JsonString
import IVisitor.JsonValue
import IVisitor.Visitor

class JsonStringImpl : JsonString {

    private val str : String

    constructor(str2 : String){
        this.str = str2
    }

    override fun getString(): String {
        return this.str
    }

    override fun getChars(): CharSequence {
        return this.str
    }

    override fun hashCode(): Int {
       return this.getString().hashCode()
    }

    override fun accept(v: Visitor) {
        v.visit(this)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is JsonString)
            this.getString().equals(other.getString())
        else
            false
    }

    override fun getValueType(): JsonValue.ValueType {
        return JsonValue.ValueType.STRING
    }

    override fun toString(): String {
        return this.str
    }
}