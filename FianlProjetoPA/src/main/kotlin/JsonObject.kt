import IVisitor.Visitable
import IVisitor.Visitor

class JsonObject : Visitable {
    val objectName: String?
    val jsonPairsList: MutableList<JsonPair>?
    val jsonArrayList: MutableList<JsonArray2>?

    constructor(objectName: String, jsonPairsList: MutableList<JsonPair>, jsonArrayList: MutableList<JsonArray2>) {
        this.jsonPairsList = jsonPairsList
        this.jsonArrayList = jsonArrayList
        this.objectName = objectName
    }

    override fun getStrings(visitor: Visitor): String {
        TODO("Not yet implemented")
    }

    override fun getObjetsByProperties(visitor: Visitor, propertie: String): String {
        TODO("Not yet implemented")
    }

    /*  override fun createModel(visitor: Visitor): JsonObject {
          return visitor.createModelJson(this);
      }*/

}