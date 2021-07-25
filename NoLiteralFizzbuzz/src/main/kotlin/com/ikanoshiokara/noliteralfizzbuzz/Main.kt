package com.ikanoshiokara.noliteralfizzbuzz

fun main(){
    val fizzbuzz: Fizzbuzz = Fizzbuzz()
    fizzbuzz.fizzbuzz.add(Fizz())
    val one = fizzbuzz.fizzbuzz.size
    fizzbuzz.fizzbuzz.add(Fizz())
    val two = fizzbuzz.fizzbuzz.size
    fizzbuzz.fizzbuzz.add(Fizz())
    val three = fizzbuzz.fizzbuzz.size
    fizzbuzz.fizzbuzz.add(Fizz())
    fizzbuzz.fizzbuzz.add(Buzz())
    val five = fizzbuzz.fizzbuzz.size
    fizzbuzz.fizzbuzz.add(Buzz())
    val minusOne = fizzbuzz.fizzbuzz.indexOf(Fizz())
    val zero = (one + minusOne)

    (one..Math.pow((two*five).toDouble(), two.toDouble()).toInt()).forEach{
        when{
            it % (five * three) == zero -> {
                println(Fizzbuzz().toName())
            }
            it % three == zero -> {
                println(Fizz().toName())
            }
            it % five == zero -> {
                println(Buzz().toName())
            }
            else -> {
                println(it)
            }
        }
    }
}