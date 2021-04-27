package IVisitor

interface JsonNumber : JsonValue {

    fun intValue() : Int

    fun doubleValue() : Double

    override fun toString(): String

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int
}