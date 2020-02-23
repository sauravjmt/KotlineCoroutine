import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//code inside coroutine runs by default sequential
// here we are using the async to run both suspend function concurrently

//see the time in Total after running the programme and compare with the ComposingSuspendingFunction.kt programme

// conceptually both async and launch are same .They both start a separate coroutine(light weight thread)
// the difference is that launch return Job and does not contained any returning value
//but the async return Deffer which contains the returning value and we can get the returning value by using .await()
fun main()= runBlocking {

    //measureTimeMillis just calculate the time taken by the both function to run
    val time=  measureTimeMillis {
        val one= async { doSmthUsefullOneAsync() }
        val two=   async { doSmthUefullTwoAsync() }
        println("The result is :${one.await()+two.await()}")
    }

    println("Total Time:$time")

}

suspend fun doSmthUsefullOneAsync():Int{
    delay(1000L)
    return 13
}

suspend fun doSmthUefullTwoAsync():Int{
    delay(1000L)
    return 29
}