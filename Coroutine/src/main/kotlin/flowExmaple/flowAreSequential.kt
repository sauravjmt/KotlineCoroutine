package flowExmaple

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// each collection in Flow is sequential
//the collection works directly in coroutine that calls a terminal operator


fun main()= runBlocking {

    (1..5).asFlow()// asFlow() will convert the range into flow streams
        .filter{
              println("Filter $it")
             it % 2==0
        }
        .map {
            println("Map $it")
            " string $it"
        }
        .collect { println("received $it") }


}