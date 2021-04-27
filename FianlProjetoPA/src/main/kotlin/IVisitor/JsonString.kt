package IVisitor

interface JsonString : JsonValue {
     fun getString(): String

     fun getChars() : CharSequence

    override fun hashCode(): Int

    override fun equals(other: Any?): Boolean
}