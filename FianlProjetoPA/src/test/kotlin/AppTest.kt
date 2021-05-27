import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import school.Lesson
import school.Student
import school.StudentType

class AppTest {
    private var rex : Reflex = Reflex()

    @BeforeEach
    fun setUp(){
        println("Testing")
        rex = Reflex()
    }


    @Test
    fun getModelShouldWork(){
        val lesson = Lesson(name = "PA", 1)
        val student = Student(numb = 1, nam = "Alberto", typ = StudentType.Bachelor, lesson)

        assertEquals(rex.reflectionInference(student),rex.reflectionInference(student))
    }
    @Test
    fun getModelShouldBreak(){
        assertEquals(rex.reflectionInference("Teste 2"),rex.reflectionInference("Teste 1"))
    }
}