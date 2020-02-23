package flowExmaple

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking


// here take operator will cancell the execution of Flow so we have implement try{} .. finally block


fun numbers(): Flow<Int> =flow{


    try {
         emit(1)
        emit(2)
        println("This will not print")
        emit(3)

    }finally {
       println("Finally in number")
    }
}


fun main()= runBlocking {
    numbers()
        .take(2)//take only first two
        .collect{response-> println(response)}
}