package school

import IVisitor.Visitable
import IVisitor.Visitor
import java.util.*

class Lesson(val name: String, val lessonDate: Date) : Visitable {
    override fun toString(): String {
        return super.toString()
    }

    override fun getStrings(visitor: Visitor): String {
        return visitor.getStrings(this)
    }

    override fun getObjetsByProperties(visitor: Visitor, propertie: String): String {
        return visitor.getObjetsByProperties(this, propertie)
    }

    /*override fun createModel(visitor: Visitor): JsonPair {
        return visitor.createModelJson(this)
    }*/

}