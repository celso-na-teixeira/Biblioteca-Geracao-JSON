package IVisitor

interface JsonValue {
    companion object {
        val NULL: JsonValue = object : JsonValue {

            override fun getValueType(): JsonValue.ValueType = JsonValue.ValueType.NULL

            override fun toString(): String {
                return "null"
            }

            override fun hashCode(): Int {
                return JsonValue.ValueType.NULL.hashCode()
            }

            override fun equals(other: Any?): Boolean {
                return if (other is JsonValue) this.getValueType()
                    .equals((other as JsonValue).getValueType()) else false
            }
        }

        val TRUE: JsonValue = object : JsonValue {

            override fun getValueType(): JsonValue.ValueType = JsonValue.ValueType.TRUE

            override fun toString(): String {
                return "true"
            }

            override fun hashCode(): Int {
                return JsonValue.ValueType.TRUE.hashCode()
            }

            override fun equals(other: Any?): Boolean {
                return if (other is JsonValue) this.getValueType()
                    .equals((other as JsonValue).getValueType()) else false
            }
        }

        val FALSE: JsonValue = object : JsonValue {

            override fun getValueType(): JsonValue.ValueType = JsonValue.ValueType.FALSE

            override fun toString(): String {
                return "false"
            }

            override fun hashCode(): Int {
                return JsonValue.ValueType.FALSE.hashCode()
            }

            override fun equals(other: Any?): Boolean {
                return if (other is JsonValue) this.getValueType()
                    .equals((other as JsonValue).getValueType()) else false
            }
        }
    }

   // fun getValueType() : JsonValue.ValueType = JsonValue.ValueType.NULL

    fun getValueType() : JsonValue.ValueType

    override fun toString(): String //todo(remove later)

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

