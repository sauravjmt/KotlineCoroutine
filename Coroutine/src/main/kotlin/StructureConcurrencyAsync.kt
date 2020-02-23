import kotlinx.coroutines.*
import kotlin.system.measureNanoTime


fun main()= runBlocking {

  val time=  measureNanoTime {
        println("The answer is:${concurrentSum()}")
    }


    println("Total Time :$time")
}


 suspend  fun concurrentSum():Int=coroutineScope{

    val one= async {doSmthUsefullExampleOne()}
    val two=async{doSmthUefullExampleTwo()}

     one.await()+two.await()

}



suspend fun doSmthUsefullExampleOne():Int{
    delay(1000L)
    return 13
}

suspend fun doSmthUefullExampleTwo():Int{
    delay(1000L)
    return 29
}







