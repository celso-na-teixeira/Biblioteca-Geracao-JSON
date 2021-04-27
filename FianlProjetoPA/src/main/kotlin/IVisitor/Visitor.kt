package IVisitor

import school.Lesson
import school.Student

interface Visitor {
    fun getStrings(st: Student): String

    fun getStrings(les: Lesson): String

    fun getObjetsByProperties(st: Student, propertie: String): String

    fun getObjetsByProperties(les: Lesson, propertie: String): String

}