import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//Thi style of coding is discourage by Kotlin  the reason for this is that if there is an error
//occur between val one and one.await() the calling code will be aborted and the async coroutine would contune running the tha bacgrund
//so this problem does not happen with structure concurrency see StructureConcurrencyAsync
fun main(){

   val time= measureTimeMillis {
        val one =doSmthUsefullOnAsync()
        val two=doSmthUsefullTwAsync()


        runBlocking {
            println("Result:${one.await()+two.await()}")
        }
    }

    println("Time Taken: $time")



}

fun doSmthUsefullOnAsync()=GlobalScope.async {
    doSmthUsefullOneOne()
}


fun doSmthUsefullTwAsync()=GlobalScope.async {
    doSmthUefullTwoTwo()
}


suspend fun doSmthUsefullOneOne():Int{
    delay(1000L)
    return 13
}

suspend fun doSmthUefullTwoTwo():Int{
    delay(1000L)
    return 29
}