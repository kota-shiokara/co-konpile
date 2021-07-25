package com.ikanoshiokara.noliteralfizzbuzz

open class Fizzbuzz {
    val fizzbuzz: MutableList<Fizzbuzz> = mutableListOf()
}

fun Fizzbuzz.toName(): String{
    return javaClass.simpleName as String
}

class Fizz : Fizzbuzz(){

}

class Buzz: Fizzbuzz(){

}