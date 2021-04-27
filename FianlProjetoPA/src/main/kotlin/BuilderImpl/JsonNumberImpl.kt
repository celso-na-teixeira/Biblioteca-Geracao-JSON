package BuilderImpl

import IVisitor.JsonNumber
import IVisitor.JsonValue

class JsonNumberImpl : JsonNumber {
    private val number : Int


    constructor(numb : Int){
        this.number = numb
    }
    constructor(numb2 : Double){
        this.number = numb2.toInt()
    }

    override fun intValue(): Int {
        return this.number
    }

    override fun doubleValue(): Double {
        return this.number.toDouble()
    }

    override fun toString(): String {
        return this.number.toString()
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