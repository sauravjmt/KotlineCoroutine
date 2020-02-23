import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun logg(msg:String)= println("[${Thread.currentThread().name}] $msg")

fun main(){
    newSingleThreadContext("Ctx1").use { ctx1->
        newSingleThreadContext("Ctx2").use { ctx2->


            runBlocking(ctx1) {
                logg("Started in Ctx1")

                withContext(ctx2){
                    logg("Working in Ctx2")
                }
                logg("Back to Ctx1")
            }
        }
    }
}
