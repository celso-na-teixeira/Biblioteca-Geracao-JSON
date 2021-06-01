import IVisitor.*
import java.lang.StringBuilder

class JsonGeneratorImpl : JsonGenerator {
    val strg : StringBuilder = StringBuilder()

    fun getJsonString(model: JsonObject) :String{
        model.accept(visitor)
        return strg.toString()
    }
    //-------------------------------------------------------------------
    val visitor = object : JsonVisitor{

        override fun visit(var1: JsonString) {
            write(var1.getString())
        }
        override fun visit(key :String, value: JsonString) {
            write(key, value.getString())
        }

        override fun visit(var1: JsonNumber) {
            writevalue(var1.toString())
        }
        override fun visit(key :String, var1: JsonNumber) {
            writevalue(key, var1.toString())
        }

        override fun visit(obj: JsonValue) {
            when(obj.getValueType()){
                JsonValue.ValueType.ARRAY -> {
                    visit(obj as JsonArray)
                }
                JsonValue.ValueType.OBJECT -> {
                    visit(obj as JsonObject)
                }
                JsonValue.ValueType.STRING -> {
                    visit(obj as JsonString)
                }
                JsonValue.ValueType.NUMBER -> {
                    visit(obj as JsonNumber)
                }
                JsonValue.ValueType.TRUE -> {
                    write(true)
                }
                JsonValue.ValueType.FALSE -> {
                    write(false)
                }
                JsonValue.ValueType.NULL -> {
                    writeNull()
                }
            }
        }
        override fun visit(key :String, value: JsonValue) {
            when(value.getValueType()){
                JsonValue.ValueType.ARRAY -> {
                    visit(key , value as JsonArray)
                }
                JsonValue.ValueType.OBJECT -> {
                    visit(key , value as JsonObject)
                }
                JsonValue.ValueType.STRING -> {
                    visit(key , value as JsonString)
                }
                JsonValue.ValueType.NUMBER -> {
                    visit(key , value as JsonNumber)
                }
                JsonValue.ValueType.TRUE -> {
                    write(key, true)
                }
                JsonValue.ValueType.FALSE -> {
                    write(key, false)
                }
                JsonValue.ValueType.NULL -> {
                    writeNull(key)
                }
            }
        }
        override fun visit(key :String, value: JsonObject): Boolean {
            if (JsonValue.ValueType.OBJECT.equals(value.getValueType())){
                writeStartObject(key)
                return true
            }
            return false
        }

        override fun visit(key :String, value: JsonArray) : Boolean {
            if (JsonValue.ValueType.ARRAY.equals(value.getValueType())){
                writeStartArray(key)
                return true
            }
            return false
        }

        override fun visit(obj: JsonObject) : Boolean {
            if (JsonValue.ValueType.OBJECT.equals(obj.getValueType())){
                writeStartObject()
                return true
            }
            return false
        }

        override fun visit(var1: JsonArray) : Boolean {
            if (JsonValue.ValueType.ARRAY.equals(var1.getValueType())){
                writeStartArray()
                return true
            }
            return false
        }

        override fun endVisit(c: JsonObject) {
            writeEndObject()

        }

        override fun endVisit(c: JsonArray) {
            writeEndArray()
        }


    }
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

        if (strg.isNotEmpty()) {
            val asp = strg.toString().substring(strg.toString().length -1, strg.toString().length)
            if (!asp.equals("{") && !asp.equals("["))
                this.strg.append(",")

        }
    }

    private fun writeName(var1 : String) : JsonGenerator{
        this.writeComma()
        this.strg.append("\"").append(var1).append("\"").append(":")
        return this
    }

    private fun writevalue(value : String){
        this.writeComma()
        this.strg.append(value)
    }
    private fun writevalue(name : String, value : String){
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