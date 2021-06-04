import Tree.TreeSkeleton
import school.Lesson
import school.Student
import school.StudentType
import java.time.LocalDateTime

class MainClass

fun main() {
    println(LocalDateTime.now())
    val lesson = Lesson(name = "PA", 1)
    val lesson2 = Lesson(name = "MAT", 2)
    val lesson3 = Lesson(name = "HIST", 3)
    val student = Student(numb = 1, nam = "Alberto", typ = StudentType.Bachelor, lesson)


    student.mylessons.add(lesson3)
    student.mylessons.add(lesson2)


    val rex = Reflex()
    var model3 = rex.reflectionInference(student)
    val jsonGeneratorImpl = JsonGeneratorImpl()
    println(jsonGeneratorImpl.getJsonString(model3))

    TreeSkeleton().open(model3)

    //teste search
    val list1 = rex.getAllStrings(student)
    list1.forEach { t -> println(t) }
    println("______________________________________")
    val list = rex.getAllContains(student, "son")
    list.forEach { t -> println(t) }



}



