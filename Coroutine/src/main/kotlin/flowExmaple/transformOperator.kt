package flowExmaple

import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


suspend fun performRequestinTranform(request:Int):String{
    delay(1000)//pretending to heavy wrk asynchronosly

    return "response $request"
}


fun main() = runBlocking<Unit> {

    (1..3).asFlow()
        .transform{request->
                emit("Making request $request ")
                emit(performRequest(request)) }
        .collect { response-> println(response) }
}