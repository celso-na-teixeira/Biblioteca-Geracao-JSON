import school.Lesson
import school.Student
import school.StudentType
import java.util.*

class MainClass
fun main(){

    val lesson = Lesson(name = "PA", lessonDate = Date())
    val lesson2 = Lesson(name = "MAT", lessonDate = Date())
    val student = Student(numb = 1, nam = "Alberto", typ = StudentType.Bachelor,lesson)

    student.mylessons.add(lesson)
    student.mylessons.add(lesson2)

    println(Date().toString())

    val teste = Json()
    print(teste.parse(student))
}