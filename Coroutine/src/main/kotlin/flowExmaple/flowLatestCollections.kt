package flowExmaple

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// The collectLatest()  will cancel and restart the collection code on every value
// this is used the situation when collector is slower than emitter
// here emitter taking 100 ms time to emit the value but collector taking the 300 ms time
// so fast the overall execution time we can use the collectLatest()

fun fooLatest(): Flow<Int> = flow{

    for (i in 1..3){
        delay(100)
        emit(i)
    }
}


fun main() = runBlocking {

    val time = measureTimeMillis {
        fooLatest()
            .collectLatest { num -> // cancel and restart on every new value
                println("Collecting $num")

                delay(300)
                println(" Done $num")// this will print on last value emitted 
            }
    }

    println("Time Taken $time ms")
}