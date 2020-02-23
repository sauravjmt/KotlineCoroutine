import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun log(msg:String)= println("[${Thread.currentThread().name}] $msg")


fun main()= runBlocking<Unit> {

    val a=async {
        log("I'm computing a piece of answer")
        6
    }

    val b=async{
        log("I'm computing another piece of answer")

        5
    }

    log("The answer is ${a.await() * b.await()}")
}