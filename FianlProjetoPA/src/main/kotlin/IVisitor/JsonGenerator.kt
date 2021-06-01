package IVisitor

interface JsonGenerator {
    fun writeStartObject() : JsonGenerator;

    fun writeStartObject(var1 : String) : JsonGenerator;

    fun writeStartArray() : JsonGenerator;

    fun writeStartArray(var1 : String) : JsonGenerator;

    fun write(var1 : String, var2 : String) : JsonGenerator;

    fun write(var1 : String, var2 : Double ) : JsonGenerator;

    fun write(var1 : String, var2 : Int) : JsonGenerator;

    fun write(var1 : String, var2 : Boolean) : JsonGenerator;

    fun writeNull(var1 : String) : JsonGenerator;

    fun write(var1 : String) : JsonGenerator;

    fun write(var1 : Double) : JsonGenerator;

    fun write(var1 : Int) : JsonGenerator;

    fun write(var1 : Boolean) : JsonGenerator;

    fun writeNull(): JsonGenerator;
}