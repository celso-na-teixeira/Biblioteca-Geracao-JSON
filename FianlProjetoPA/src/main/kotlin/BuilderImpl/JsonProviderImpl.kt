package BuilderImpl

import ICom.JsonProvider
import IVisitor.JsonArrayBuilder
import IVisitor.JsonObjectBuilder

class JsonProviderImpl : JsonProvider {

    constructor()

    override fun createObjectBuilder(): JsonObjectBuilder {
        return  JsonObjectImpl()
    }

    override fun JsonArrayBuilder(): JsonArrayBuilder {
        return JsonArrayBuilderImpl()
    }

}