package flowExmaple

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

// Here flow {}... works in the bacground thread and collection happened in the main thread
// just using the flowOn() operator can run the code in specified thread
fun logg(msg:String)= println("[${Thread.currentThread().name}] $msg")


fun fooFlowOn(): Flow<Int> = flow{

       for (i in 1..3){
           Thread.sleep(100)
           logg("Emitting $i")
           emit(i)

       }

}.flowOn(Dispatchers.Default)




fun main()= runBlocking {
    fooFlowOn().collect { num-> logg("Collected $num") }
}

//Another thing to observe here is that the flowOn operator has changed the default sequential nature of the flow.
//Now collection happens in one coroutine ("coroutine#1") and emission happens in another coroutine ("coroutine#2") that is running in
//another thread concurrently with the collecting coroutine.
//The flowOn operator creates another coroutine for an upstream flow when it has to change the CoroutineDispatcher in its context.



// OUTPUT
//[DefaultDispatcher-worker-1 @coroutine#2] Emitting 1
//[main @coroutine#1] Collected 1
//[DefaultDispatcher-worker-1 @coroutine#2] Emitting 2
//[main @coroutine#1] Collected 2
//[DefaultDispatcher-worker-1 @coroutine#2] Emitting 3
//[main @coroutine#1] Collected 3