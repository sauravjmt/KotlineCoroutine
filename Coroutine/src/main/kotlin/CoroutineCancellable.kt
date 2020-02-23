import kotlinx.coroutines.*

fun main()= runBlocking {

    var startTime=System.currentTimeMillis()
    val job=launch(Dispatchers.Default) {

        var nextPrintTime=startTime
        var i=0
        while (isActive){
            if(System.currentTimeMillis()>=nextPrintTime){
                println("job: i'm sleeping ${i++}")
                nextPrintTime+=500L
            }
        }
    }

    delay(1300L)
    println("main:tired of sleeping")
    job.cancelAndJoin()
    println("main: i can quit now")


}