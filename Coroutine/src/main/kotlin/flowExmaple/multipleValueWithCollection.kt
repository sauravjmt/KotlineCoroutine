package flowExmaple

fun foo():List<Int> = listOf(1,2,3)

fun main(){
    foo().forEach{data-> println(data)}
}