package flowExmaple

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

// by default the flow{}... code will run in the context of the calling collector

 fun log(msg:String)= println("[${Thread.currentThread().name}] $msg")

fun fooContext(): Flow<Int> = flow {
              log("Started foo flow")
              for (i in 1..3){
                  emit(i)
              }
}


fun main() = runBlocking {
     fooContext().collect { value-> log("Value Collected $value") }

}





// output

//[main @coroutine#1] Started foo flow
//[main @coroutine#1] Value Collected 1
//[main @coroutine#1] Value Collected 2
//[main @coroutine#1] Value Collected 3
