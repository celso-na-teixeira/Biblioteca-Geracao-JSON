import IVisitor.Json
import ImplVisitor.ImplVisitor
import school.Lesson
import school.Student
import school.StudentType
import java.util.*

class MainClass

fun main() {

    val lesson = Lesson(name = "PA", lessonDate = Date())
    val lesson2 = Lesson(name = "MAT", lessonDate = Date())
    val lesson3 = Lesson(name = "HIST", lessonDate = Date())
    val student = Student(numb = 1, nam = "Alberto", typ = StudentType.Bachelor, lesson)

    student.mylessons.add(lesson3)
    student.mylessons.add(lesson2)

    println(Date().toString())
    val impl = ImplVisitor()
    val teste = JsonParse()
    val tete2 = "Teste"

   // println(teste.parse(student))

    val model = Json.createObjectBuilder().add(lesson.name, lesson.lessonDate.toString()).build()
    val model2 = Json.createArrayBuilder().add(Json.createObjectBuilder().add(lesson.name, lesson.lessonDate.toString())).build()
    println(model2)

}