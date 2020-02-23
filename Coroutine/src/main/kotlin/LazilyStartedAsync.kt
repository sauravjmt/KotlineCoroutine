import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//here we have lazilly started async with decalring the start parametr as LAZY
//lazilly started corotine does not start untill its started externnally by the programmer using .start()
//one thing to note if we omit the start method then it will run the code sequentially
fun main()= runBlocking {

    //measureTimeMillis just calculate the time taken by the both function to run
    val time=  measureTimeMillis {
        val one= async(start=CoroutineStart.LAZY) { doSmthUsefullOneLzAsync() }
        val two=   async(start=CoroutineStart.LAZY) { doSmthUefullTwoLzAsync() }
        //here it will start the async coroutine
        //if we remove this then run sequentially
        one.start()
        two.start()
        println("The result is :${one.await()+two.await()}")
    }

    println("Total Time:$time")

}

suspend fun doSmthUsefullOneLzAsync():Int{
    delay(1000L)
    return 13
}

suspend fun doSmthUefullTwoLzAsync():Int{
    delay(1000L)
    return 29
}