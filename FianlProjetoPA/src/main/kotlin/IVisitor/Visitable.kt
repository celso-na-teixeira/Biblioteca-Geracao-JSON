package IVisitor

interface Visitable {
    fun getStrings(visitor: Visitor): String

    fun getObjetsByProperties(visitor: Visitor, propertie: String): String

}