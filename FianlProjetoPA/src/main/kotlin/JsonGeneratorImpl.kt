import BuilderImpl.JsonArrayBuilderImpl
import BuilderImpl.JsonObjectBuilderImpl
import IVisitor.*
import java.lang.StringBuilder

class JsonGeneratorImpl : JsonGenerator {
    val strg : StringBuilder = StringBuilder()
    //___________________________________________________________________
    override fun writeStartObject(): JsonGenerator {
        this.writeComma()
        this.strg.append("{")
        return this
    }

    override fun writeStartObject(var1: String): JsonGenerator {
        this.writeName(var1)
        this.strg.append("{")
        return this
    }

    override fun writeStartArray(): JsonGenerator {
        this.writeComma()
        this.strg.append("[")
        return this
    }

    override fun writeStartArray(var1: String): JsonGenerator {
        this.writeName(var1)
        this.strg.append("[")
        return this
    }

    override fun write(name: String, value: JsonValue): JsonGenerator {
        when(value.getValueType()){
            JsonValue.ValueType.ARRAY -> {
                var arr : JsonArray = value as JsonArray
                this.writeStartArray(name)
                var iterator = arr.iterator()

                while (iterator.hasNext()){
                    var child = iterator.next() as JsonValue
                    this.write(child)
                }
                this.writeEndArray()
            }
            JsonValue.ValueType.OBJECT -> {
                var obj : JsonObject = value as JsonObject
                this.writeStartObject(name)
                var iterator = (obj.getJsonObject() as Map<String,JsonValue>).entries.iterator()

                while (iterator.hasNext()){
                    var member = iterator.next()
                    this.write(member.key, member.value)
                }
                this.writeEndObject()
            }
            JsonValue.ValueType.STRING -> {
                var str : JsonString = value as JsonString

                this.write(name, str.getString())
            }
            JsonValue.ValueType.NUMBER -> {
                var numb : JsonNumber = value as JsonNumber

                this.writevalue(name, numb.toString())
            }
            JsonValue.ValueType.TRUE -> {
                this.write(name, true)
            }
            JsonValue.ValueType.FALSE -> {
                this.write(name, false)
            }
            JsonValue.ValueType.NULL -> {
                this.writeNull(name)
            }
        }
        return this
    }

    override fun write(var1: String, var2: String): JsonGenerator {
        this.writeName(var1)
        this.strg.append("\"").append(var2).append("\"")
        return this
    }

    override fun write(var1: String, var2: Double): JsonGenerator {
        this.writeName(var1)
        this.strg.append(var2)
        return this
    }

    override fun write(var1: String, var2: Int): JsonGenerator {
        this.writeName(var1)
        this.strg.append(var2)
        return this
    }

    override fun write(var1: String, var2: Boolean): JsonGenerator {
        this.writeName(var1)
        this.strg.append(var2)
        return this
    }

    override fun write(var1: JsonValue): JsonGenerator {
        when(var1.getValueType()){
            JsonValue.ValueType.ARRAY -> {
                var arr : JsonArray = var1 as JsonArray
                this.writeStartArray()
                var iterator = arr.iterator()

                while (iterator.hasNext()){
                    var child = iterator.next() as JsonValue
                    this.write(child)
                }
                this.writeEndArray()
            }
            JsonValue.ValueType.OBJECT -> {
                var obj : JsonObject = var1 as JsonObject
                this.writeStartObject()
                var iterator = (obj.getJsonObject() as Map<String,JsonValue>).entries.iterator()

                while (iterator.hasNext()){
                    var member = iterator.next()
                    this.write(member.key, member.value)
                }
                this.writeEndObject()
            }
            JsonValue.ValueType.STRING -> {
                var str : JsonString = var1 as JsonString

                this.write(str.getString())
            }
            JsonValue.ValueType.NUMBER -> {
                var numb : JsonNumber = var1 as JsonNumber

                this.writevalue(numb.toString())
            }
            JsonValue.ValueType.TRUE -> {
                this.write(true)
            }
            JsonValue.ValueType.FALSE -> {
                this.write(false)
            }
            JsonValue.ValueType.NULL -> {
                this.writeNull()
            }
        }
        return this
    }

    override fun write(var1: String): JsonGenerator {
        this.writeComma()
        this.strg.append("\"").append(var1).append("\"")
        return this
    }

    override fun write(var1: Double): JsonGenerator {
        this.writeComma()
        this.strg.append(var1)
        return this
    }

    override fun write(var1: Int): JsonGenerator {
        this.writeComma()
        this.strg.append(var1)
        return this
    }

    override fun write(var1: Boolean): JsonGenerator {
        this.writeComma()
        this.strg.append(if (var1) "true" else "false")
        return this
    }

    override fun writeNull(var1: String): JsonGenerator {
        this.writeName(var1)
        this.strg.append("null")
        return this
    }

    override fun writeNull(): JsonGenerator {
        this.writeComma()
        this.strg.append("null")
        return this
    }

    private fun writeComma(){
        if (strg.isNotEmpty())
            this.strg.append(",")
    }

    private fun writeName(var1 : String) : JsonGenerator{
        writeComma()
        this.strg.append("\"").append(var1).append("\"").append(":")
        return this
    }

    private fun writevalue(value : String){
        this.writeComma()
        this.strg.append(value)
    }
    private fun writevalue(name : String, value : String){
        this.writeComma()
        this.writeName(name)
        this.strg.append(value)
    }

    private fun writeEndArray(){
        this.strg.append("]")
    }
    private fun writeEndObject(){
        this.strg.append("}")
    }

    private fun format(str : String) : String{
        val builder : StringBuilder = StringBuilder()

        if (str.isNotEmpty())
            return String().orEmpty()
        val c = 0
        val len = str.length

        builder.append('"')
        for ( i in 0..len){
            var c = str.get(i)
            when(c){

            }

        }

        return builder.toString()
    }

}