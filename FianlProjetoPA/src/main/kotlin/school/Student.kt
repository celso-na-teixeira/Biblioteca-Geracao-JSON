package school

import IVisitor.Visitor
import JsonAnnotation

@JsonAnnotation.MainObject
class Student(
    numb: Int,
    nam: String,
    typ: StudentType,
    oneLess: Lesson
)  {

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

    override fun toString(): String {
        return super.toString()
    }
}

