import kotlinx.coroutines.*

fun main()= runBlocking {
    try {
    withTimeout(1300L){
            repeat(1000){i->
                println("I'm sleeping $i")
                delay(500L)
            }
    }

    }catch (e:TimeoutCancellationException){

    }

  val result=  withTimeoutOrNull(1300L){
        repeat(1000){i->
            println("I'm sleeping $i")
            delay(500L)
        }

      "DONE"
    }
    print("Result:$result")




}