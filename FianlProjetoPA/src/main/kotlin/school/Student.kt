package school

import IVisitor.Visitable
import IVisitor.Visitor
import JsonAnnotation

@JsonAnnotation.MainObject
class Student(
    numb: Int,
    nam: String,
    typ: StudentType,
    oneLess: Lesson
) : Visitable {

    val number: Int
    val name: String
    val type: StudentType

    @JsonAnnotation.AttributeObject
    val oneLesson: Lesson

    @JsonAnnotation.AttributeArray
    val mylessons = mutableListOf<Lesson>()

    init {
        number = numb
        name = nam
        type = typ
        oneLesson = oneLess
    }

    override fun getStrings(visitor: Visitor): String {
        return visitor.getStrings(this)
    }

    override fun getObjetsByProperties(visitor: Visitor, propertie: String): String {
        return visitor.getObjetsByProperties(this, propertie)
    }

    /*  override fun createModel(visitor: Visitor): JsonObject {
          TODO("Not yet implemented")
      }*/


    override fun toString(): String {
        return super.toString()
    }
}

