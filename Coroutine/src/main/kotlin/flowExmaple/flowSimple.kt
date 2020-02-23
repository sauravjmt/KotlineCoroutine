package flowExmaple

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun fooFlow(): Flow<Int> = flow {
            for (i in 1..3){
                //this will not block the thread in which its running
                delay(100)
                //this will block the main thread uncomment below and comment above to see the effect
               // Thread.sleep(100)
                emit(i)
            }

}


fun main()= runBlocking {



       launch {
           for (k in 1..3){
               println("i'm not blocked $k")
               delay(100)
           }
       }
    fooFlow().collect { value-> println(value) }
}