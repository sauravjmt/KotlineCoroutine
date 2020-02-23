import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.ArithmeticException

// here if the second child throws an exception it will cancelled the 1st child
// and the exception is propagated to the coroutine hierarchy

fun main()= runBlocking <Unit>{

    try {
        failedConcurrrentSum()

    }catch (e:ArithmeticException){
        print("Computation failed with arithmatic exceptions")
    }
}

suspend fun failedConcurrrentSum():Int= coroutineScope {


   val one= async<Int>{

       try {

           delay(Long.MAX_VALUE)
           42

       }finally {
           println("Child One is cancelled")
       }
    }

    val two=async<Int> {
        println("Second throws exception")
        throw ArithmeticException()
    }
      one.await()+two.await()



}



