package flowExmaple

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

   suspend fun fooCold(): Flow<Int> = flow {
            println("Flow started running")
     for (i in 1..3){
         delay(100)
         emit(i)
     }
}


//fun main(){
//     var foo= fooCold()
//
//
//
//    runBlocking {
//        launch {
//            foo.collect{value-> println(value)}
//        }
//
//
//        //delay(300)
//        }
//
//}


fun main() = runBlocking {

    var foo = fooCold()

    println("Flow is collected")
    foo.collect{value-> println(value) }


}