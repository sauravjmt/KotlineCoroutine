import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//code inside coroutine runs by default sequential
// here we are supposing the value of 1st function is used by 2nd function
// in this we run the both function sequentially which default nature of coroutine
fun main()= runBlocking {

    //measureTimeMillis just calculate the time taken by the both function to run
       val time=  measureTimeMillis {
             val one= doSmthUsefullOne()// 1st this complete
             val two=doSmthUefullTwo()// then this will complete
             println("The result is :${one+two}")
         }

    println("Total Time:$time")

}

suspend fun doSmthUsefullOne():Int{
    delay(1000L)
    return 13
}

suspend fun doSmthUefullTwo():Int{
    delay(1000L)
    return 29
}