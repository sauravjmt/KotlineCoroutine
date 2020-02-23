import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main()= runBlocking {

    val job =launch {
         doWorld()
        }

    delay(1300L)
    println(" main:I'm tired of waiting...")
    job.cancel()
    job.join()
    println("main:i can quit")


    }


  suspend fun doWorld(){
      repeat(1000){i->
          println("I'm sleeping:$i")
          delay(500L)

      }
}
