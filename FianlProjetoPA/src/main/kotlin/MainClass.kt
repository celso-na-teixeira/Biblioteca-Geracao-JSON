import school.ClassRoom
import school.Lesson
import school.Student
import school.StudentType
import java.util.*

class MainClass

fun main() {

    val lesson = Lesson(name = "PA", 1)
    val lesson2 = Lesson(name = "MAT", 2)
    val lesson3 = Lesson(name = "HIST", 3)
    val student = Student(numb = 1, nam = "Alberto", typ = StudentType.Bachelor, lesson)

    val items = HashMap<String, Int>()
    items["A"] = 10
    items["B"] = 20
    items["C"] = 30

    val room = ClassRoom(items)

    student.mylessons.add(lesson3)
    student.mylessons.add(lesson2)


    var test = Reflex()
    var model3 = test.reflectionInference(student)
    //model3.getMap().forEach { t, u -> }
    println(model3)
    //teste(StudentType.Bachelor)
    //TreeSkeleton().open(model3)

    val map = test.getAllStrings(student)

    map.forEach { t -> println(t) }


}


