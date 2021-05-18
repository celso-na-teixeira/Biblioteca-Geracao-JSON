package BuilderImpl

import IVisitor.JsonNumber
import IVisitor.JsonValue
import IVisitor.Visitor

class JsonNumberImpl : JsonNumber {
    private val number : Double


    constructor(numb : Int){
        this.number = numb.toDouble()
    }
    constructor(numb2 : Double){
        this.number = numb2
    }

    override fun intValue(): Int {
        return this.number.toInt()
    }

    override fun doubleValue(): Double {
        return this.number
    }

    override fun toString(): String {
        return this.number.toString()
    }

    override fun accept(v: Visitor) {
        v.visit(this)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is JsonNumber)
            this.number.equals((other as JsonNumber).intValue())
        else
            false
    }

    override fun hashCode(): Int {
        return this.number.hashCode()
    }

    override fun getValueType(): JsonValue.ValueType {
        return JsonValue.ValueType.NUMBER
    }
}