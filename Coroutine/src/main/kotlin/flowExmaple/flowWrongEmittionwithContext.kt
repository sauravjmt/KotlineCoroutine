package flowExmaple

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// the flow{}... builder has to honor the context preservation property and is not allowed to emit from different context

// here the correct way to change the context in flow{}.... to use the flowOn() operator as suggested in Exception
fun fooDiffContext(): Flow<Int> = flow{

                 withContext(Dispatchers.Default){
                     for (i in 1..3){

                         Thread.sleep(100)
                         emit(i)
                     }
                 }
}


fun main()= runBlocking {

    fooDiffContext().collect { num-> println(num) }
}


// OUTPUT
//Exception in thread "main" java.lang.IllegalStateException: Flow invariant is violated:
//Flow was collected in [BlockingCoroutine{Active}@1f2f97ce, BlockingEventLoop@1db2a054],
//but emission happened in [DispatchedCoroutine{Active}@3f43a002, DefaultDispatcher].
//Please refer to 'flow' documentation or use 'flowOn' instead
