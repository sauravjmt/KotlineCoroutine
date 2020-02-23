package flowExmaple

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

// 1. flow{} 2. flowOf() 3. asFlow() are flow builders 

fun fooFlowOf()= flowOf(1,2,3)


fun main()= runBlocking {

    fooFlowOf().collect{num-> println(num)}

    flowOf("Saurav").collect { name-> println(name) }

    flowOf(listOf(1,2,3)).collect { list-> println(list) }


    listOf(1,2,3).asFlow().collect { listval-> println(listval) }
}