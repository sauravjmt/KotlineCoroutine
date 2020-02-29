package flowExmaple

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis




// here emitter and collector are working in different speed
// so when we need only the opertaion status result to show in collector we can use conflate() operator
// which skips the results status and takes the latest one
// like here it takes 1 and 3 skipping the value 2

fun fooConflation(): Flow<Int> = flow{

    for (i in 1..3){
        delay(100)
        emit(i)
    }
}


fun main() = runBlocking {

    val time = measureTimeMillis {
        fooConflation()
            .conflate()
            .collect { num ->

                delay(300)
                println(num)
            }
    }

    println("Time Taken $time")
}