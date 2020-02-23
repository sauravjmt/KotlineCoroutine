import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {

    val job=launch {

            try {
                repeat(1000){i->
                    println("I'm sleeping $i")
                    delay(500L)
                }
            }finally {
                println("job: i'm running finally")
            }

    }

    delay(1300L)
    println("main:tired of sleeping")
    job.cancelAndJoin()
    println("main: i quiting now")

}
