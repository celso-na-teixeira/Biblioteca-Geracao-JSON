import IVisitor.*
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation

class Reflex {
    //create model
    fun reflectionInference(o: Any) : JsonObject {
        val model = Json.createObjectBuilder()
        var modelArr : JsonArrayBuilder
        val clazz: KClass<Any> = o::class as KClass<Any>

        clazz.declaredMemberProperties.forEach {
            if(it.hasAnnotation<JsonAnnotation.AttributeObject>()){
                model.add(it.name, reflectionInference(it.call(o)!!))
            }else if (it.hasAnnotation<JsonAnnotation.AttributeArray>()){
                val arr = it.call(o) as Collection<Any>
                modelArr = Json.createArrayBuilder()
                arr.forEach{ ar ->
                    modelArr.add(reflectionInference(ar))
                }
                model.add(it.name,modelArr)
            }
            else{
                if(it.call(o) is String){
                    val teste = it.call(o) as String
                    model.add(it.name, teste)
                }else if (it.call(o) is Int){
                    model.add(it.name,it.call(o) as Int)
                }else if(it.call(o) is Boolean){
                    model.add(it.name,it.call(o) as Boolean)
                }
            }
        }
        return model.build()
    }

    //search
    fun getAllStrings(o: Any) : List<String>{

        val visitor = object : Visitor {
            val map = mutableListOf<String>()

            override fun visit(var1: JsonString) {
                map.add(var1.getString())
            }

            override fun visit(var1: JsonNumber) {
            }

            override fun visit(var1: JsonValue) {
                if (var1.getValueType() == JsonValue.ValueType.STRING)
                    map.add((var1 as JsonString).getString())
            }

            override fun endVisit(c: JsonObject) {
            }

            override fun endVisit(c: JsonArray) {
            }
        }

        val model = reflectionInference(o)

        model.accept(visitor)
    return visitor.map
    }
    fun getAllContains(o: Any, name : String) : List<Any>{

        val visitor = object : Visitor {
            val map = mutableListOf<Any>()

            override fun visit(var1: JsonString) {
            }

            override fun visit(var1: JsonNumber) {

            }

            override fun visit(var1: JsonValue) {
            }
            override fun visit(var1 : JsonObject) : Boolean{
                var1.getMap().forEach{
                    if (JsonValue.ValueType.OBJECT.equals(it.value.getValueType()) &&  it.key.contains(name)) {
                        map.add(it)
                    }

                }
                return true
            }
            override fun visit(var1 : JsonArray) : Boolean{
                /*var1.forEach {
                    if (JsonValue.ValueType.OBJECT.equals(it.getValueType()))
                        map.add(it)
                }*/
                return true
            }


            override fun endVisit(c: JsonObject) {
            }

            override fun endVisit(c: JsonArray) {
            }
        }

        val model = reflectionInference(o)

        model.accept(visitor)
        return visitor.map
    }

    fun getJson(){

    }

}