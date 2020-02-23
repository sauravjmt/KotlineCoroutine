import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking <Unit>{
    launch (Dispatchers.Unconfined){
        println("Unconfined: ${Thread.currentThread().name}")

        delay(500L)
        println(" Unconfined: ${Thread.currentThread().name}")
    }

    launch {
        println("main runBlocking: ${Thread.currentThread().name}")

        delay(500L)
        println("main runBlocking: ${Thread.currentThread().name}")
    }

}