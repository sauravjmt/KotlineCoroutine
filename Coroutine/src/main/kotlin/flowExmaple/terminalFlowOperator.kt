package flowExmaple

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

// terminal flow operator are a suspension function that start collection of the flow
//collect is the most basic terminal flow operator but there are other also
//like --Conversion to the various Collections toList and toSet
//-operators to get the First value and ensure that a Flow emits Single value
// -- reducing  a flow to a value with reduce and fold



fun main()= runBlocking<Unit> {

   val even =(1..10).asFlow().map{it * it }.first{it%3==0}

    val sum =(1..4).asFlow().map { it * it }.reduce { acc, value -> acc+value }
    val foldSum= (1..4).asFlow().fold(2){acc,num-> acc+num}

    println(even)
    println(sum)

    println(foldSum)


}