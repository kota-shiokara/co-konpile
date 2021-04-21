import kotlin.math.sqrt

fun main(){
    val N: Long = 10000000
    val ans = Eratosthenes(N).solve().getAns()
    println(ans)
}