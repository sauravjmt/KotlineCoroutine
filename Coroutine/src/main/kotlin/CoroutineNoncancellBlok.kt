import kotlinx.coroutines.*

fun main()= runBlocking {

    val job=launch {

        try {
            repeat(1000){i->
                println("I'm sleeping $i")
                delay(500L)
            }
        }finally {
            withContext(NonCancellable){
                println("job: i'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }

        }

    }

    delay(1300L)
    println("main:tired of sleeping")
    job.cancelAndJoin()
    println("main: i quiting now")

}