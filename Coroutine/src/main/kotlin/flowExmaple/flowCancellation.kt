package flowExmaple

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


//there is no infrastructure available in flow to cancelled it, it fully transparent it can be cancelled from the coroutine in which it was called or from suspend function
//its flow the same rule as for coroutine

fun fooCancel(): Flow<Int> = flow{

    for (i in 1..3){
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}


fun main() = runBlocking<Unit> {

    withTimeoutOrNull(250){
        fooCancel().collect{value-> println( value) }
    }

    println("Done")
}