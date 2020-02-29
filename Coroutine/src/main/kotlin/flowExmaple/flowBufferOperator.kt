package flowExmaple

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis



// here by using buffer we can run the flow {}... code concrenly to the cod in collection
fun fooBuffer(): Flow<Int> = flow{

    for (i in 1..3){
        delay(100)
        emit(i)
    }
}


fun main() = runBlocking {

    val time= measureTimeMillis {
        fooBuffer()
            .buffer()  // see the result by commenting this line
            .collect {num ->

            delay(300)
            println(num)
        }
    }

    println("Time Taken $time")
}