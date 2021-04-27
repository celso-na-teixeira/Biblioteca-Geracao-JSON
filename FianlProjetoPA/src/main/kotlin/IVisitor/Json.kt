package IVisitor

import ICom.JsonProvider

class Json {
companion object{
    fun createArrayBuilder() : JsonArrayBuilder{
        return JsonProvider.provider().JsonArrayBuilder()
    }

    fun createObjectBuilder() : JsonObjectBuilder{
        return JsonProvider.provider().createObjectBuilder()
    }

    fun createBuilderFactory(conf : Map<String, Any?>) : JsonBuilderFactory{
        return JsonProvider.provider().createBuilderFactory(conf)
    }


}
}