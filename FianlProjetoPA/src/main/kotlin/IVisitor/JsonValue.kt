package IVisitor

interface JsonValue  {
    companion object {
        val NULL: JsonValue = object : JsonValue {
            override fun accept(v: Visitor) {
                v.visit(this)
            }

            override fun accept(v: JsonVisitor) {
                v.visit(this)
            }

            override fun accept(key: String, v: JsonVisitor) {
                v.visit(key,this)
            }

            override fun getValueType(): ValueType = JsonValue.ValueType.NULL

            override fun toString(): String {
                return "null"
            }

            override fun hashCode(): Int {
                return JsonValue.ValueType.NULL.hashCode()
            }

            override fun equals(other: Any?): Boolean {
                return if (other is JsonValue) this.getValueType()
                    .equals((other).getValueType()) else false
            }
        }

        val TRUE: JsonValue = object : JsonValue {
            override fun accept(v: Visitor) {
                v.visit(this)
            }

            override fun accept(v: JsonVisitor) {
                v.visit(this)
            }

            override fun accept(key: String, v: JsonVisitor) {
                v.visit(key,this)
            }

            override fun getValueType(): ValueType = JsonValue.ValueType.TRUE

            override fun toString(): String {
                return "true"
            }

            override fun hashCode(): Int {
                return JsonValue.ValueType.TRUE.hashCode()
            }

            override fun equals(other: Any?): Boolean {
                return if (other is JsonValue) this.getValueType()
                    .equals(other.getValueType()) else false
            }
        }

        val FALSE: JsonValue = object : JsonValue {
            override fun accept(v: Visitor) {
                v.visit(this)
            }

            override fun accept(v: JsonVisitor) {
                v.visit(this)
            }

            override fun accept(key: String, v: JsonVisitor) {
                v.visit(key,this)
            }

            override fun getValueType(): ValueType = JsonValue.ValueType.FALSE

            override fun toString(): String {
                return "false"
            }

            override fun hashCode(): Int {
                return JsonValue.ValueType.FALSE.hashCode()
            }

            override fun equals(other: Any?): Boolean {
                return if (other is JsonValue) this.getValueType()
                    .equals(other.getValueType()) else false
            }
        }
    }

    fun accept(v : Visitor)

    fun accept(v : JsonVisitor)

    fun accept(key : String, v : JsonVisitor)

    fun getValueType() : ValueType

    enum class ValueType {
        ARRAY,
        OBJECT,
        STRING,
        NUMBER,
        TRUE,
        FALSE,
        NULL
    }
}

